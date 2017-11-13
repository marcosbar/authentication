USE auth;

DROP TABLE user_roles;
DROP TABLE user;
DROP TABLE rol;

CREATE TABLE user(
  id VARCHAR (50) PRIMARY KEY,
  name VARCHAR (255),
  password VARCHAR(255),
  last_login datetime
);

CREATE TABLE rol(
  id VARCHAR (50) PRIMARY KEY,
  description VARCHAR (255)
);

CREATE TABLE user_roles(
  user_id VARCHAR(50),
  rol_id VARCHAR (50),
  FOREIGN KEY (user_id) REFERENCES user(id),
  FOREIGN KEY (rol_id) REFERENCES rol(id)
);


