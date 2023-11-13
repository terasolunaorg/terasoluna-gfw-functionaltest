-- queryescape test table
create table todo (
    id integer not null,
    todo_title varchar(20) not null,
    constraint pk_todo primary key (id)
)