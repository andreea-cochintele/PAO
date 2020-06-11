
drop table contact;
drop table adresa;
drop table dates;
drop table istoric;
drop table optiuni;
drop table candidat;
drop table specializare;


create table contact(
    id_candidat number(4) primary key,
    mail varchar2(64),
    telefon varchar2(64)
);

create table adresa(
    id_candidat number(4) primary key,
    localitate varchar2(64),
    judet varchar2(64),
    tara varchar2(64)
);

create table dates(
    id_candidat number(4) primary key,
    dataNasterii varchar2(64),
    cnp varchar2(30)
);

create table istoric(
    id_candidat number(4) primary key,
    numeLiceu varchar2(64),
    medieLiceu number(4,2)
);

create table optiuni(

    id_candidat number(4) primary key,
    id_facultate number(4),
    numeFacultate varchar2(64)
    
);

create table specializare(
    id_specializare number(4) primary key,
    id_facultate number(4),
    numeProfil varchar2(64),
    situatieAdmitere varchar2(64),
    medieExamen number(4,2),
    medieAdmitere number(4,2)
);


create table candidat(
    id_candidat number(4) primary key,
    numarOptiuni number(4),
    id_facultate number(4) ,
    nume varchar2(64),
    prenume varchar2(64)
);






insert into candidat values (1,1,1,'Ionescu','Marius');
insert into candidat values (2,1,1,'Popescu','Ioana');
insert into candidat values (3,1,1,'Popa','Raluca');
insert into candidat values (4,1,1,'Corint','Paul');


insert into  contact values(1,'ionescu.marius@gmail.com',0725846356);
insert into  contact values(2,'popescu.ioana@gmail.com',0725545456);
insert into  contact values(3,'popa.raluca@gmail.com',0754989543);
insert into  contact values(4,'corint_paul@gmail.com',0652534356);

insert into  adresa values(1,'Suceava','Suceava','Romania');
insert into  adresa values(2,'Ramnicu-Valcea','Valcea','Romania');
insert into  adresa values(3,'Bucuresti','Bucuresti','Romania');
insert into  adresa values(4,'Slatina','Olt','Romania');

insert into dates values(1,'05/03/1999','1990305373537');
insert into dates values(2,'08/09/1999','2990908345538');
insert into dates values(3,'02/01/2000','60002013453533');
insert into dates values(4,'25/07/1998','1980725646464');


insert into istoric values(1,'Liceu_nr.67',9.40);
insert into istoric values(2,'Liceu_nr.40',6.20);
insert into istoric values(3,'Liceu_nr.75',9.00);
insert into istoric values(4,'Liceul_nr5',8.80);

insert into optiuni values(1,1,'Facultatea_de_matematica_si_informatica');
insert into optiuni values(2,1,'Facultatea_de_matematica_si_informatica');
insert into optiuni values(3,2,'Facultatea_de_biologie');
insert into optiuni values(4,2,'Facultatea_de_biologie');

insert into specializare values(1,1,'Informatica','-',6.50,0);
insert into specializare values(2,1,'Informatica','-',6.50,0);
insert into specializare values(3,2,'Biochimie','-',8.2,0);
insert into specializare values(4,2,'Biologie','-',7.8,0);



commit;
