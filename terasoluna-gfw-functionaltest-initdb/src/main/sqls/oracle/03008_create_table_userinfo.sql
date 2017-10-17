-- redirect test table
create table userinfo (
    username varchar(25) not null,
    name varchar(25) not null,
    address varchar(25) not null,
    constraint pk_userinfo primary key (username)
)
