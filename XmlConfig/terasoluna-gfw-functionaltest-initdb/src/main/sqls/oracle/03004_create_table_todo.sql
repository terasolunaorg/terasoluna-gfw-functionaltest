-- queryescape test table
create table todo (
    id number(38) not null,
    todo_title varchar(20) not null,
    constraint pk_todo primary key (id)
)