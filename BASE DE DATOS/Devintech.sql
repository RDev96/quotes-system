-- Database: Devintech

-- DROP DATABASE IF EXISTS "Devintech";

CREATE DATABASE "Devintech"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_El Salvador.1252'
    LC_CTYPE = 'Spanish_El Salvador.1252'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

COMMENT ON DATABASE "Devintech"
    IS 'Prueba Tecnica';




-- Migrations will appear here as you chat with AI

create table rol (
  id bigint primary key generated always as identity,
  rol_name text not null unique,
  status boolean not null default true
);

create table permissions (
  id bigint primary key generated always as identity,
  screen_name text not null,
  url text not null
);

create table users (
  id bigint primary key generated always as identity,
  name text not null,
  lastname text not null,
  email text not null unique,
  rol int not null,
  foreign key (rol) references rol (id)
);

create table login (
  id bigint primary key generated always as identity,
  username text not null unique,
  password text not null,
  user_id int not null,
  foreign key (user_id) references users (id)
);

create table rol_permissions (
  id bigint primary key generated always as identity,
  rol_id int not null,
  permissions_id int not null,
  foreign key (rol_id) references rol (id),
  foreign key (permissions_id) references permissions (id),
  unique (rol_id, permissions_id)
);

create table products (
  id bigint primary key generated always as identity,
  product_name text not null,
  discount json not null
);

create table transactions (
  id bigint primary key generated always as identity,
  user_id bigint not null,
  product_id bigint not null,
  email text not null,
  additional_costs json not null,
  product_weight float8 not null,
  product_cost float8 not null,
  added_cost float8 not null,
  total float8 not null,
  creation_date 
  foreign key (user_id) references users (id),
  foreign key (product_id) references products (id)
);

alter table transactions
add column creation_date timestamp with time zone default now();


alter table transactions
alter column additional_costs type varchar(1500) using additional_costs::varchar(1500);