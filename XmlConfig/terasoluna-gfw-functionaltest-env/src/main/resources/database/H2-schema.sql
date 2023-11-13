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


-- redirect test table
create table userinfo (
    username varchar(25) not null,
    name varchar(25) not null,
    address varchar(25) not null,
    constraint pk_userinfo primary key (username)
);

-- sequencer test integer sequence
create sequence integer_seq
start with 1
increment by 1;

-- sequencer test long sequence
create sequence long_seq
start with 1
increment by 1;

-- sequencer test string sequence
create sequence string_seq 
start with 1
increment by 1;

-- sequencer test biginteger sequence
create sequence big_integer_seq 
start with 1
increment by 1;

-- sequencer test error sequence
create sequence error_seq
start with 1
increment by 1;

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
	contents BLOB not null,
	constraint pk_document primary key (document_id)
);
