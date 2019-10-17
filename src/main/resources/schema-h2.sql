 create table if not exists Movie (
  id identity,
  movie_Name varchar(100) not null,
  ranking varchar(2) not null
);


 create table if not exists Users (
--  id identity,
  username varchar(25) not null,
  password varchar(50) not null,
  enabled boolean not null,
  PRIMARY KEY (username)
);

 create table if not exists UserAuthorities (
 username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    FOREIGN KEY (username) REFERENCES users(username)
 );