drop table if exists public.t_matrix_user;

CREATE TABLE public.t_matrix_user
(
    id SERIAL primary key,
    employee_number integer,
    user_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
	user_password character varying(255) COLLATE pg_catalog."default" NOT NULL,
	state integer,
    description text COLLATE pg_catalog."default",
	phone character varying(255) COLLATE pg_catalog."default",
	email character varying(255) COLLATE pg_catalog."default",
	create_time timestamp without time zone,
	update_time timestamp without time zone,
	created_by integer,
	updated_by integer,
	user_type integer,
	expire_time timestamp without time zone
)

TABLESPACE pg_default;

ALTER TABLE "public"."t_matrix_user" ADD CONSTRAINT "user_name" UNIQUE ("user_name");


drop table if exists public.t_matrix_resource_space;

CREATE TABLE public.t_matrix_resource_space
(
    id SERIAL primary key,
    resource_space_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
	resource_space_alias character varying(255) COLLATE pg_catalog."default" NOT NULL,
    description text COLLATE pg_catalog."default",
	create_time timestamp without time zone,
	update_time timestamp without time zone,
	created_by integer,
	updated_by integer
)

ALTER TABLE "public"."t_matrix_resource_space" ADD CONSTRAINT "resource_space_name" UNIQUE ("resource_space_name");


TABLESPACE pg_default;

drop table if exists public.t_matrix_menu;

CREATE TABLE public.t_matrix_menu
(
    id SERIAL primary key,
    menu_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    description text COLLATE pg_catalog."default",
	create_time timestamp without time zone,
	update_time timestamp without time zone
)


drop table if exists public.t_matrix_relation_menu_user;

CREATE TABLE public.t_matrix_relation_menu_user
(
    id SERIAL primary key,
    user_id integer NOT NULL,
	menu_id integer NOT NULL,
	create_time timestamp without time zone,
	update_time timestamp without time zone
)

TABLESPACE pg_default;

TABLESPACE pg_default;

drop table if exists public.t_matrix_group_space;

CREATE TABLE public.t_matrix_group_space
(
    id SERIAL primary key,
    group_space_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    description text COLLATE pg_catalog."default",
	create_time timestamp without time zone,
	update_time timestamp without time zone,
	owner integer,
	created_by integer,
	updated_by integer
)
ALTER TABLE "public"."t_matrix_group_space" ADD CONSTRAINT "group_space_name" UNIQUE ("group_space_name");


TABLESPACE pg_default;



drop table if exists public.t_matrix_relation_resource_space_user;

CREATE TABLE public.t_matrix_relation_resource_space_user
(
    id SERIAL primary key,
    user_id integer NOT NULL,
	resource_space_id integer NOT NULL,
	create_time timestamp without time zone,
	update_time timestamp without time zone
)

TABLESPACE pg_default;



drop table if exists  public.t_matrix_relation_group_space_user;

CREATE TABLE public.t_matrix_relation_group_space_user
(
    id SERIAL primary key,
    user_id integer NOT NULL,
	group_space_id integer NOT NULL,
	create_time timestamp without time zone,
	update_time timestamp without time zone
)

TABLESPACE pg_default;

ALTER TABLE public.t_matrix_relation_group_space_user
    OWNER to postgres;
ALTER TABLE public.t_matrix_user
    OWNER to postgres;
ALTER TABLE public.t_matrix_relation_resource_space_user
    OWNER to postgres;
ALTER TABLE public.t_matrix_resource_space
    OWNER to postgres;
ALTER TABLE public.t_matrix_resource_space
    OWNER to postgres;


INSERT INTO "t_matrix_menu" VALUES (1, 'Notebook', 'Notebook', '2020-06-18 14:37:51', '2020-06-18 14:37:51+08');
INSERT INTO "t_matrix_menu" VALUES (2, 'Hummingbird', 'Hummingbird', '2020-06-18 14:37:51', '2020-06-18 14:37:51+08');
INSERT INTO "t_matrix_menu" VALUES (3, 'HaoModel', 'HaoModel', '2020-06-18 14:37:51', '2020-06-18 14:37:51+08');
INSERT INTO "t_matrix_menu" VALUES (4, 'Monitor', 'Monitor', '2020-06-18 14:37:51', '2020-06-18 14:37:51+08');
INSERT INTO "t_matrix_menu" VALUES (5, 'ModelMarket', 'ModelMarket', '2020-06-18 14:37:51', '2020-06-18 14:37:51+08');
