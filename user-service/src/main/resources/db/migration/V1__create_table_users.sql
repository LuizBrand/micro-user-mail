CREATE TABLE tb_user (
    user_id UUID NOT NULL,
    name VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    PRIMARY KEY (user_id)
);
