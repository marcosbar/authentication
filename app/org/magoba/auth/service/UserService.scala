package org.magoba.auth.service

import javax.inject.Inject

import org.magoba.auth.repository.UserRepository

class UserService@Inject()(userRepository: UserRepository, encryptionService: EncryptionService) {

  def login(login: String, password: String) = {
    val encryptedPassword = encryptionService.encrypt(password)
    val result = userRepository.findById(login)
      .filter(user => encryptedPassword.equals(user.encryptedPassword))
      .map(user => user.copy(roles = userRepository.findRoles(user.id))
    )
    result
  }
}