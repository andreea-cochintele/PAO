drop table alegere;
drop table facultati;



create table facultati(
    id_facultati number(4) primary key,
    numeFacultati varchar2(64),
    numarSpecializari number(2)
);
create table alegere(
    id_facultati number(4),
    id_specializari number(4) primary key,
    aniStudii number(4),
    numeSpecializare varchar2(64),
    numarLocuri number(4),
    ultimaMedie number(4,2)
);



insert into alegere values(1,1,3,'Informatica',20,0.00);
insert into alegere values(1,2,3,'Matematica',10,0.00);
insert into alegere values(1,3,4,'CTI',7,0.00);
insert into alegere values(2,4,3,'Biologie',15,0.00);
insert into alegere values(2,5,3,'Biochimie',5,0.00);


insert into facultati values(1,'Facultatea_de_matematica_si_informatica',3);
insert into facultati values(2,'Facultatea_de_biologie',2);


commit;