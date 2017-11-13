package org.magoba.auth.model

import org.joda.time.DateTime

case class User(id: String, name:String, encryptedPassword: String, lastLogin: Option[DateTime], roles: List[Rol])

case class Rol(rol: String, description: String)
