create table topicos(
    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensaje varchar(400) not null,
    fecha_creacion timestamp default CURRENT_TIMESTAMP not null,
    estatus varchar(20) not null,
    autor varchar(15) not null,
    curso varchar(30) not null,
    primary key(id)
);