 create table if not exists Movie (
  id identity,
  movieName varchar(50) not null,
  ranking varchar(2) not null
);


 create table if not exists User (
  id identity,
  username varchar(25) not null,
  password varchar(10) not null
);