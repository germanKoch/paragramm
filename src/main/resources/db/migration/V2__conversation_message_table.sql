CREATE TABLE conversation
(
    id            bigserial primary key,
    title         text,
    picture       text,
    creation_date timestamp with time zone NOT NULL
);

CREATE TABLE user_conversation
(
    id              bigserial primary key,
    conversation_id bigint,
    user_id         bigint,
    creation_date   timestamp with time zone NOT NULL,

    constraint fk_user_conversation_conversation
        foreign key (conversation_id)
            references conversation (id),

    constraint fk_user_conversation_user
        foreign key (user_id)
            references user_details (id)
);

CREATE TABLE message
(
    id              bigserial primary key,
    conversation_id bigint,
    sender_id       bigint,
    text            text,
    creation_date   timestamp with time zone NOT NULL,

    constraint fk_message_conversation
        foreign key (conversation_id)
            references conversation (id),

    constraint fk_message_user
        foreign key (sender_id)
            references user_details (id)
);