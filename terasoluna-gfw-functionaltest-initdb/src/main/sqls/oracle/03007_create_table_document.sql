-- File Download table
create table document (
	document_id number(38) not null,
	contents blob not null,
	constraint pk_document primary key (document_id)
)