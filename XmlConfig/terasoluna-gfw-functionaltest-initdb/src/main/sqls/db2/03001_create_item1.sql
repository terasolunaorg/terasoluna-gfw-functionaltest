-- codelist test table
create table item1 (
    item1_id integer not null,
    code varchar(25) not null,
    label varchar(25)  not null,
    constraint pk_item1 primary key (code)
)