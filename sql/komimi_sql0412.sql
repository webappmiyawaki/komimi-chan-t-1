create database komimi_chan_t_1;

create table user_base_info
(
    user_id       varchar(100) not null
        constraint user_base_info_pk
            primary key,
    user_name     varchar(100),
    user_password varchar(100),
    img_address   varchar(100),
    user_type	varchar(100)
);

create table talent_base_info
(
    talent_id          varchar(100) not null
        constraint talent_base_info_pk
            primary key,
    talent_name        varchar(100),
    talent_img_address varchar(100),
    talent_birth_place varchar(100),
    talent_birthday    date,
    talent_blood_type  varchar(100),
    talent_group_name  varchar(100),
    talent_info08      varchar(100),
    twitter_address    varchar(500),
    youtube_address    varchar(500),
    tiktok_address	varchar(500)
);

create table talent_live_info
(
    talent_id          varchar(100) not null
        constraint talent_live_info_pk
            primary key
        constraint talent_live_info_talent_base_info_talent_id_fk
            references talent_base_info
            on update cascade on delete cascade,
    talent_live_info01 varchar(100),
    talent_live_info02 varchar(100),
    talent_live_info03 varchar(100),
    talent_live_info04 varchar(100),
    talent_live_info05 varchar(100)
);

create table user_favorite
(
    user_id      varchar(100)
        constraint user_favorite_user_base_info_user_id_fk
            references user_base_info
            on update cascade on delete cascade,
    talent_id    varchar(100)
        constraint user_favorite_talent_base_info_talent_id_fk
            references talent_base_info
            on update cascade on delete cascade,
    user_comment varchar(500)
);

create table product_by_talent
(
    product_id        varchar(100) not null
        constraint product_by_talent_pk
            primary key,
    talent_id         varchar(100)
        constraint product_by_talent_talent_base_info_talent_id_fk
            references talent_base_info
            on update cascade on delete cascade
            deferrable,
    product_type      varchar(100),
    product_name      varchar(100),
    product_price     integer,
    registration_date date
);

create table user_purchase_history
(
    history_no        serial
        constraint user_purchase_history_pk
            primary key,
    user_id           varchar(100)
        constraint user_purchase_history_user_base_info_user_id_fk
            references user_base_info
            on update cascade on delete cascade,
    product_id        varchar(100),
    registration_date date
);

create table user_request
(
    request_no   serial
        constraint user_request_pk
            primary key,
    user_id      varchar(100)
        constraint user_request_talent_base_info_talent_id_fk
            references talent_base_info
            on update cascade on delete cascade
        constraint user_request_user_base_info_user_id_fk
            references user_base_info
            on update cascade on delete cascade,
    request_text varchar(100)
);