CREATE TABLE todo.USER (
    id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    deleted smallint NOT NULL,
    created_at DATETIME NOT NULL,
    updated_at DATETIME NOT NULL
);

CREATE TABLE todo.TODO (
    id int PRIMARY KEY AUTO_INCREMENT,
    user_id int NOT NULL,
    title varchar(255) NOT NULL,
    detail text NOT NULL,
    date DATETIME NOT NULL,
    status smallint NOT NULL DEFAULT(0),
    FOREIGN KEY (user_id) REFERENCES todo.USER(id)
);