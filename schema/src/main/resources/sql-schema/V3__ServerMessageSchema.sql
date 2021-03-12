CREATE TABLE IF NOT EXISTS ticket_creation_messages (
    message_id CHAR(18) NOT NULL,
    ticket_creation_type ENUM(COMMISSION,STAFF_APPLICATION) NOT NULL,

    PRIMARY KEY (message_id)
);

