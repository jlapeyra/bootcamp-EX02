insert into dentista(nom_cognoms, dni, num_colegiat) values('Bonaventura Clotet', '12345678A', '1111');
insert into dentista(nom_cognoms, dni, num_colegiat) values('Oriol Mitjà', '12345678B', '2222');

insert into pacient(nom_cognoms, dni, naixament) values('Pau Garcia', '12345678C', '2000-01-01');
insert into pacient(nom_cognoms, dni, naixament) values('Jose Gómez', '12345678D', '2000-01-01');

insert into cita(pacient, dentista, inici, fi) values(1, 1, '2023-05-01T17:00:00+2:00', '2023-05-01T17:00:00+2:00');
insert into cita(pacient, dentista, inici, fi) values(2, 2, '2023-05-01T17:00:00+2:00', '2023-05-01T17:00:00+2:00');