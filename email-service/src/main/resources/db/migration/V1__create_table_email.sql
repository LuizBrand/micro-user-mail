CREATE TABLE tb_email (
    email_id UUID NOT NULL,
    user_id UUID,
    email_from VARCHAR(255),
    email_to VARCHAR(255),
    email_subject VARCHAR(255),
    email_body TEXT,
    email_status SMALLINT,
    email_send_date TIMESTAMP,
    PRIMARY KEY (email_id)
);
