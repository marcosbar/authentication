package org.magoba.auth.repository

import org.magoba.auth.model.{Rol, User}
import scalikejdbc.{AutoSession, DBSession, _}

/**
  * Created by MB on 02/10/2017.
  */
class UserRepository {

  def findById(id: String)(implicit s: DBSession = AutoSession): Option[User] = {
    sql"select id, name, password, last_login from user WHERE id = ${id}"
      .map { rs => buildUser(rs) }.single.apply()
  }

  private def buildUser(rs: WrappedResultSet): User = {
    User(rs.get("id"), rs.get("name"), rs.get("password"), Option.apply(rs.get("last_login")), Nil)
  }

  def findRoles(id: String)(implicit s: DBSession = AutoSession): List[Rol] = {
    sql"select r.id, r.description from rol r JOIN user_roles ur ON r.id=ur.rol_id WHERE ur.user_id = ${id}"
      .map { rs => Rol(rs.get("r.id"), rs.get("r.description")) }.list.apply()
  }
}
