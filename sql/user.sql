CREATE SEQUENCE user_seq start with 1;

CREATE TABLE users (
    user_id bigint NOT NULL DEFAULT nextval('user_seq'),
    user_name varchar(30) NOT NULL UNIQUE,
    password varchar(30) NOT NULL,
    total_games int DEFAULT 0,
    total_win int DEFAULT 0,
    total_loss int DEFAULT 0,
    total_tie int DEFAULT 0,
    PRIMARY KEY (user_id)
);