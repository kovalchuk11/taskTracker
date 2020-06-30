create schema if not exists tracker;

create table tracker.users
(
    user_id bigserial not null unique,
    first_name varchar,
    last_name varchar,
    email varchar unique,
    password varchar,
    registration_date timestamp,
    username varchar not null unique
);

create table tracker.tasks
(
    id serial not null unique,
    description varchar,
    title varchar not null unique,
    status varchar not null
);

create table tracker.users_tasks
(
    users_tasks_id serial not null
        constraint users_tasks_pkey
            primary key,
    user_id integer not null unique
        constraint users_tasks_user_id_fkey
            references tracker.users (user_id)
            on update cascade on delete cascade,
    task_id integer not null
        constraint users_tasks_task_id_fkey
            references tracker.tasks (id)
            on update cascade on delete cascade,
    constraint users_tasks_user_id_task_id_key
        unique (user_id, task_id)
);

