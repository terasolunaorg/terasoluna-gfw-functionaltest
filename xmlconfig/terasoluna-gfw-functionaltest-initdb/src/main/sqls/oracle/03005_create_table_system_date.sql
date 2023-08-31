-- Date test table
create table system_date(
	system_date_id number(38) not null,
	now timestamp not null,
	constraint pk_system_date_id primary key (system_date_id)
)