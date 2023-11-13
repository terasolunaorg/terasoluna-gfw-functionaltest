----------
-- DROP --
----------
DROP TABLE IF EXISTS person;
DROP TABLE IF EXISTS item1;
DROP TABLE IF EXISTS item2;
DROP TABLE IF EXISTS item3;
DROP TABLE IF EXISTS todo;
DROP TABLE IF EXISTS system_date;
DROP TABLE IF EXISTS operation_date;
DROP TABLE IF EXISTS document;
DROP TABLE IF EXISTS userinfo;
DROP SEQUENCE IF EXISTS integer_seq;
DROP SEQUENCE IF EXISTS long_seq;
DROP SEQUENCE IF EXISTS string_seq;
DROP SEQUENCE IF EXISTS big_integer_seq;
DROP SEQUENCE IF EXISTS error_seq;

------------
-- CREATE --
------------

-- pagination test table
create table person (
    person_id int not null,
    firstname varchar(25) not null,
    lastname varchar(25)  not null,
    constraint pk_person primary key (person_id)
);

-- codelist test table
create table item1 (
    item1_id int not null,
    code varchar(25) not null,
    label varchar(25)  not null,
    constraint pk_item1 primary key (code)
);

-- codelist test table
create table item2 (
    item2_id int not null,
    code varchar(25) not null,
    label varchar(25)  not null,
    constraint pk_item2 primary key (code)
);

-- codelist test table
create table item3 (
    item3_id int not null,
    code varchar(25) not null,
    label_en varchar(25)  not null,
    label_ja varchar(25)  not null,
    constraint pk_item3 primary key (code)
);

-- queryescape test table
create table todo (
    id int not null,
    todo_title varchar(20) not null,
    constraint pk_todo primary key (id)
);

-- Date test table
create table system_date(
	system_date_id int not null,
	now timestamp not null,
	constraint pk_system_date_id primary key (system_date_id)
);
create table operation_date(
	operation_date_id int not null,
	diff bigint not null,
	constraint pk_operation_date_id primary key (operation_date_id)
);

-- File Download table
create table document (
	document_id int not null,
	contents bytea not null,
	constraint pk_document primary key (document_id)
);

-- redirect test table
create table userinfo (
    username varchar(25) not null,
    name varchar(25) not null,
    address varchar(25) not null,
    constraint pk_userinfo primary key (username)
);

CREATE SEQUENCE integer_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9999999999
    START WITH 1
    NO CYCLE
;
CREATE SEQUENCE long_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9999999999
    START WITH 1
    NO CYCLE
;
CREATE SEQUENCE string_seq 
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9999999999
    START WITH 1
    NO CYCLE
;
CREATE SEQUENCE big_integer_seq 
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9999999999
    START WITH 1
    NO CYCLE
;
CREATE SEQUENCE error_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9999999999
    START WITH 1
    NO CYCLE
;