PGDMP         ;    
            {            postgres    14.6 (Homebrew)    15.1                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    14034    postgres    DATABASE     j   CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'C';
    DROP DATABASE postgres;
                tuongnh    false                       0    0    DATABASE postgres    COMMENT     N   COMMENT ON DATABASE postgres IS 'default administrative connection database';
                   tuongnh    false    3610                        2615    2200    public    SCHEMA     2   -- *not* creating schema, since initdb creates it
 2   -- *not* dropping schema, since initdb creates it
                tuongnh    false                       0    0    SCHEMA public    ACL     Q   REVOKE USAGE ON SCHEMA public FROM PUBLIC;
GRANT ALL ON SCHEMA public TO PUBLIC;
                   tuongnh    false    4            ?            1259    33189    department_generator    SEQUENCE     ~   CREATE SEQUENCE public.department_generator
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.department_generator;
       public          tuongnh    false    4            ?            1259    33191    departments    TABLE     ]   CREATE TABLE public.departments (
    id bigint NOT NULL,
    name character varying(255)
);
    DROP TABLE public.departments;
       public         heap    tuongnh    false    4            ?            1259    32831    departments_seq    SEQUENCE     y   CREATE SEQUENCE public.departments_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.departments_seq;
       public          tuongnh    false    4            ?            1259    33190    employee_generator    SEQUENCE     |   CREATE SEQUENCE public.employee_generator
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.employee_generator;
       public          tuongnh    false    4            ?            1259    33196 	   employees    TABLE     ?   CREATE TABLE public.employees (
    id bigint NOT NULL,
    address character varying(255),
    is_manager boolean,
    name character varying(255),
    department_id bigint NOT NULL
);
    DROP TABLE public.employees;
       public         heap    tuongnh    false    4            ?            1259    32832    employees_seq    SEQUENCE     w   CREATE SEQUENCE public.employees_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.employees_seq;
       public          tuongnh    false    4            ?            1259    32768    t_departments_seq    SEQUENCE     {   CREATE SEQUENCE public.t_departments_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.t_departments_seq;
       public          tuongnh    false    4            ?            1259    32769    t_employees_seq    SEQUENCE     y   CREATE SEQUENCE public.t_employees_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.t_employees_seq;
       public          tuongnh    false    4                      0    33191    departments 
   TABLE DATA           /   COPY public.departments (id, name) FROM stdin;
    public          tuongnh    false    215                    0    33196 	   employees 
   TABLE DATA           Q   COPY public.employees (id, address, is_manager, name, department_id) FROM stdin;
    public          tuongnh    false    216   %                  0    0    department_generator    SEQUENCE SET     B   SELECT pg_catalog.setval('public.department_generator', 1, true);
          public          tuongnh    false    213                       0    0    departments_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.departments_seq', 1, false);
          public          tuongnh    false    211                       0    0    employee_generator    SEQUENCE SET     A   SELECT pg_catalog.setval('public.employee_generator', 51, true);
          public          tuongnh    false    214                        0    0    employees_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.employees_seq', 51, true);
          public          tuongnh    false    212            !           0    0    t_departments_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.t_departments_seq', 51, true);
          public          tuongnh    false    209            "           0    0    t_employees_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.t_employees_seq', 1, false);
          public          tuongnh    false    210            ~           2606    33195    departments departments_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.departments
    ADD CONSTRAINT departments_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.departments DROP CONSTRAINT departments_pkey;
       public            tuongnh    false    215            ?           2606    33202    employees employees_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.employees
    ADD CONSTRAINT employees_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.employees DROP CONSTRAINT employees_pkey;
       public            tuongnh    false    216            ?           2606    33203 %   employees fkgy4qe3dnqrm3ktd76sxp7n4c2    FK CONSTRAINT     ?   ALTER TABLE ONLY public.employees
    ADD CONSTRAINT fkgy4qe3dnqrm3ktd76sxp7n4c2 FOREIGN KEY (department_id) REFERENCES public.departments(id) ON DELETE CASCADE;
 O   ALTER TABLE ONLY public.employees DROP CONSTRAINT fkgy4qe3dnqrm3ktd76sxp7n4c2;
       public          tuongnh    false    3454    216    215                  x?3???????? 	??         c   x?3??HT????,??K/?L?S????y?
N????\F@??T?<?4E!??y?@yc|?? &?U@ P?)?5?-2???Wp??T??????&F??? ?@     