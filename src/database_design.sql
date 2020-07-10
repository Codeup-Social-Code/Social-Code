CREATE DATABASE IF NOT EXISTS capstone_db;
USE capstone_db;

CREATE TABLE users (
                       id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                       first_name VARCHAR(50) NOT NULL,
                       last_name  VARCHAR(100) NOT NULL,
                       picture text,
                       email VARCHAR(100) NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       city VARCHAR(255) NOT NULL,
                       linkedin VARCHAR(255),
                       github VARCHAR(255),
                       bio TEXT,
                       PRIMARY KEY (id)
);

CREATE TABLE posts (
                       id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                       title TEXT NOT NULL,
                       user_id INT UNSIGNED NOT NULL,
                       body TEXT NOT NULL,
                       create_date LONG NOT NULL,
                       date VARCHAR(255) NOT NULL,
                       time LONG NOT NULL,
                       PRIMARY KEY (id),
                       FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE categories (
                            id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                            name VARCHAR(255),
                            PRIMARY KEY (id)
);

CREATE TABLE post_categories (
                                 post_id INTEGER UNSIGNED NOT NULL,
                                 category_id INTEGER UNSIGNED NOT NULL,
                                 FOREIGN KEY (post_id) REFERENCES posts(id),
                                 FOREIGN KEY (category_id) REFERENCES category(id)
);

SELECT * FROM post_categories
                  LEFT JOIN category ON post_categories.category_id = category.id
                  LEFT JOIN posts ON posts.id = post_categories.post_id;

CREATE TABLE comments (
                          id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                          post_id INTEGER UNSIGNED NOT NULL,
                          user_id INTEGER UNSIGNED NOT NULL,
                          create_date LONG NOT NULL,
                          body TEXT NOT NULL,
                          PRIMARY KEY (id),
                          FOREIGN KEY (post_id) REFERENCES posts(id),
                          FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE post_users (
                            post_id INTEGER UNSIGNED NOT NULL,
                            users_id INTEGER UNSIGNED NOT NULL,
                            FOREIGN KEY (post_id) REFERENCES posts(id),
                            FOREIGN KEY (users_id) REFERENCES users(id)
);



