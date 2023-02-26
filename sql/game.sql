CREATE SEQUENCE game_seq start with 1;

CREATE TABLE game (
    game_id bigint NOT NULL DEFAULT nextval('game_seq'),
    winner int,
    rounds int,
    p1_id bigint NOT NULL,
    p2_id bigint NOT NULL,
    PRIMARY KEY (game_id),
    FOREIGN KEY (p1_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (p2_id) REFERENCES users(user_id) ON DELETE CASCADE
);