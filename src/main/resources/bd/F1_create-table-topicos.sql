create table topicos(

    id bigint not null auto_increment,
    titulo varchar(100) not null unique,
    mensagem varchar(500) not null unique,
    data varchar(10) not null ,
    status tinyint not null,
    autor varchar(100) not null,
    curso varchar(100) not null,
    primary key(id)

);