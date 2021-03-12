CREATE TABLE IF NOT EXISTS todo_list (
    message_id CHAR(18) NOT NULL,
    todo_status ENUM(NOT_STARTED,IN_PROGRESS,FINISHED)

    PRIMARY KEY (message_id)
);