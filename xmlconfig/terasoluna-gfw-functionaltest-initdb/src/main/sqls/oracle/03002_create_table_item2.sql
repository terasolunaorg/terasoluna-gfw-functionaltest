-- codelist test table
create table item2 (
    item2_id number(38) not null,
    code varchar(25) not null,
    label varchar(25)  not null,
    constraint pk_item2 primary key (code)
)