-- File Download table
create table document (
	document_id integer not null,
	contents blob not null,
	constraint pk_document primary key (document_id)
)