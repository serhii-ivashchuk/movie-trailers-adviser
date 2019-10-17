delete from Movie;

insert into Movie (id, movie_Name, ranking)
values ('1', 'Terminator', '10');
insert into Movie (id, movie_Name, ranking)
values ('2', 'The Shawshank Redemption (1994)', '10');
insert into Movie (id, movie_Name, ranking)
values ('3', 'Inception (2010)', '10');
insert into Movie (id, movie_Name, ranking)
values ('4', 'Fight Club (1999)', '10');
insert into Movie (id, movie_Name, ranking)
values ('5', 'Pulp Fiction (1994)', '10');
insert into Movie (id, movie_Name, ranking)
values ('6', 'Forrest Gump (1994)', '10');
insert into Movie (id, movie_Name, ranking)
values ('7', 'The Lord of the Rings: The Fellowship of the Ring (2001)', '10');
insert into Movie (id, movie_Name, ranking)
values ('8', 'The Matrix (1999)', '10');
insert into Movie (id, movie_Name, ranking)
values ('9', 'The Godfather (1972)', '10');

--delete from Users;
--
--insert into Users (id, username, password, enabled)
--values ('1', 'Serhii Ivashchuk', 'password', true);
--insert into Users (id, username, password, enabled)
--values ('1', 'Serhii', 'advisor', true);
--insert into Users (id, username, password, enabled)
--values ('2', 'Robert Martin', 'password', true);
--insert into Users (id, username, password, enabled)
--values ('3 ', 'admin', 'pass', true);

delete from Users;

insert into Users (username, password, enabled)
values ('Serhii Ivashchuk', '{noop}password', true);
insert into Users (username, password, enabled)
values ('Serhii', '{noop}advisor', true);
insert into Users (username, password, enabled)
values ('Robert Martin', '{noop}password', true);
insert into Users (username, password, enabled)
values ('admin', '{noop}pass', true);


INSERT INTO UserAuthorities (username, authority)
  values ('Serhii', 'ROLE_USER');
INSERT INTO UserAuthorities (username, authority)
    values ('admin', 'ROLE_ADMIN');

