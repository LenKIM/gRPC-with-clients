create table user_id_auto
(
    id bigint default nextval('user_id_seq'::regclass) not null
        constraint user_id_pk
            primary key,
    name varchar
);

alter table user_id_auto owner to len;

create table user_protobuf_id
(
    id bigint not null
        constraint user_protobuf_id_pk
            primary key,
    name varchar
);

alter table user_protobuf_id owner to len;

create unique index user_protobuf_id_id_uindex
    on user_protobuf_id (id);

create table user_id_uuid
(
    id varchar,
    name varchar
);

alter table user_id_uuid owner to len;

