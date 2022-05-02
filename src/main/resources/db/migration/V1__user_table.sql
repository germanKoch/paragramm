CREATE TABLE user_details(
    id bigserial primary key,
    name text,
    phone text,
    username text,
    password text,
    creation_date timestamp with time zone NOT NULL
)