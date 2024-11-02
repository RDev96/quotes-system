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








-- Table: public.login

-- DROP TABLE IF EXISTS public.login;

CREATE TABLE IF NOT EXISTS public.login
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    username text COLLATE pg_catalog."default" NOT NULL,
    password text COLLATE pg_catalog."default" NOT NULL,
    user_id integer NOT NULL,
    CONSTRAINT login_pkey PRIMARY KEY (id),
    CONSTRAINT login_username_key UNIQUE (username),
    CONSTRAINT login_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.login
    OWNER to postgres;



-- Table: public.permissions

-- DROP TABLE IF EXISTS public.permissions;

CREATE TABLE IF NOT EXISTS public.permissions
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    screen_name text COLLATE pg_catalog."default" NOT NULL,
    url text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT permissions_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.permissions
    OWNER to postgres;





-- Table: public.products

-- DROP TABLE IF EXISTS public.products;

CREATE TABLE IF NOT EXISTS public.products
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    product_name text COLLATE pg_catalog."default" NOT NULL,
    discount json NOT NULL,
    CONSTRAINT products_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.products
    OWNER to postgres;






-- Table: public.rol

-- DROP TABLE IF EXISTS public.rol;

CREATE TABLE IF NOT EXISTS public.rol
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    rol_name text COLLATE pg_catalog."default" NOT NULL,
    status boolean NOT NULL DEFAULT true,
    CONSTRAINT rol_pkey PRIMARY KEY (id),
    CONSTRAINT rol_rol_name_key UNIQUE (rol_name)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.rol
    OWNER to postgres;








-- Table: public.rol_permissions

-- DROP TABLE IF EXISTS public.rol_permissions;

CREATE TABLE IF NOT EXISTS public.rol_permissions
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    rol_id integer NOT NULL,
    permissions_id integer NOT NULL,
    CONSTRAINT rol_permissions_pkey PRIMARY KEY (id),
    CONSTRAINT rol_permissions_rol_id_permissions_id_key UNIQUE (rol_id, permissions_id),
    CONSTRAINT rol_permissions_permissions_id_fkey FOREIGN KEY (permissions_id)
        REFERENCES public.permissions (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT rol_permissions_rol_id_fkey FOREIGN KEY (rol_id)
        REFERENCES public.rol (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.rol_permissions
    OWNER to postgres;









-- Table: public.transactions

-- DROP TABLE IF EXISTS public.transactions;

CREATE TABLE IF NOT EXISTS public.transactions
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    user_id bigint NOT NULL,
    product_id bigint NOT NULL,
    email text COLLATE pg_catalog."default" NOT NULL,
    additional_costs character varying(1500) COLLATE pg_catalog."default" NOT NULL,
    product_weight double precision NOT NULL,
    product_cost double precision NOT NULL,
    added_cost double precision NOT NULL,
    total double precision NOT NULL,
    creation_date timestamp with time zone DEFAULT now(),
    CONSTRAINT transactions_pkey PRIMARY KEY (id),
    CONSTRAINT transactions_product_id_fkey FOREIGN KEY (product_id)
        REFERENCES public.products (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT transactions_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.transactions
    OWNER to postgres;








-- Table: public.users

-- DROP TABLE IF EXISTS public.users;

CREATE TABLE IF NOT EXISTS public.users
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    name text COLLATE pg_catalog."default" NOT NULL,
    lastname text COLLATE pg_catalog."default" NOT NULL,
    email text COLLATE pg_catalog."default" NOT NULL,
    rol integer NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (id),
    CONSTRAINT users_email_key UNIQUE (email),
    CONSTRAINT fk_users_rol FOREIGN KEY (rol)
        REFERENCES public.rol (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.users
    OWNER to postgres;    








