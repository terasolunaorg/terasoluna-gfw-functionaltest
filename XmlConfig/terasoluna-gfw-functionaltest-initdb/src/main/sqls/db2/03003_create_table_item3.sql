-- codelist test table
create table item3 (
    item3_id integer not null,
    code varchar(25) not null,
    label_en varchar(25)  not null,
    label_ja varchar(25)  not null,
    constraint pk_item3 primary key (code)
)