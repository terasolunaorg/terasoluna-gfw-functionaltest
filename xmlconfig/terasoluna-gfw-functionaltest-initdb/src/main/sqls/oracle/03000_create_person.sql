-- pagination test table
create table person (
    person_id number(38) not null,
    firstname varchar(25) not null,
    lastname varchar(25)  not null,
    constraint pk_person primary key (person_id)
)