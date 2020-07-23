USE socialcode_db;

INSERT INTO users (username, bio, password, password_to_confirm, city, first_name, last_name, git_hub, linked_in, picture)
    VALUE ('delayne@gmail.com', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. A, aperiam aut commodi consequuntur cum ea excepturi impedit ipsum iusto magnam nemo optio quaerat quibusdam quidem quis quo soluta temporibus ullam vero voluptatibus. Ab asperiores cupiditate error explicabo, illum iste repudiandae suscipit. Aperiam consequatur deleniti maiores neque nostrum quidem tempora totam?
', 'password', 'password', 'Arlington', 'Delayne', 'LaBove', 'delayne', 'delayne', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aperiam consequuntur deserunt dolores quasi?');

INSERT INTO users (username, bio, password, password_to_confirm, city, first_name, last_name, git_hub, linked_in, picture)
    VALUE ('emily@gmail.com', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. A, aperiam aut commodi consequuntur cum ea excepturi impedit ipsum iusto magnam nemo optio quaerat quibusdam quidem quis quo soluta temporibus ullam vero voluptatibus. Ab asperiores cupiditate error explicabo, illum iste repudiandae suscipit. Aperiam consequatur deleniti maiores neque nostrum quidem tempora totam?
', 'password', 'password', 'Arlington', 'Emily', 'Bowersox', 'Emily', 'Emily', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aperiam consequuntur deserunt dolores quasi?');

INSERT INTO users (username, bio, password, password_to_confirm, city, first_name, last_name, git_hub, linked_in, picture)
    VALUE ('sung@gmail.com', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. A, aperiam aut commodi consequuntur cum ea excepturi impedit ipsum iusto magnam nemo optio quaerat quibusdam quidem quis quo soluta temporibus ullam vero voluptatibus. Ab asperiores cupiditate error explicabo, illum iste repudiandae suscipit. Aperiam consequatur deleniti maiores neque nostrum quidem tempora totam?
', 'password', 'password', 'Arlington', 'Sung', 'Lee', 'sung', 'sung', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aperiam consequuntur deserunt dolores quasi?');

INSERT INTO users (username, bio, password, password_to_confirm, city, first_name, last_name, git_hub, linked_in, picture)
    VALUE ('ron@gmail.com', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. A, aperiam aut commodi consequuntur cum ea excepturi impedit ipsum iusto magnam nemo optio quaerat quibusdam quidem quis quo soluta temporibus ullam vero voluptatibus. Ab asperiores cupiditate error explicabo, illum iste repudiandae suscipit. Aperiam consequatur deleniti maiores neque nostrum quidem tempora totam?
', 'password', 'password', 'Arlington', 'Ron', 'Palencia', 'ron', 'ron', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aperiam consequuntur deserunt dolores quasi?');

INSERT INTO posts (title, body, create_date, end_date_time, start_date_time, start_time, end_time, user_id)
VALUES ('First Post', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad, aspernatur dolor exercitationem nemo quia quis quo saepe. Ad aspernatur, autem beatae dolorem impedit labore nesciunt non officia, sed sequi veniam!
', curdate(), '2020-17-07T16:00:00.000', '2020-17-07T16:30:00.000', '12:00', '12:00', 1);

INSERT INTO posts (title, body, create_date, end_date_time, start_date_time, start_time, end_time, user_id)
VALUES ('Second Post', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad, aspernatur dolor exercitationem nemo quia quis quo saepe. Ad aspernatur, autem beatae dolorem impedit labore nesciunt non officia, sed sequi veniam!
', curdate(), '2020-16-07T16:00:00.000', '2020-16-07T16:30:00.000', '12:00', '12:00', 1);

INSERT INTO posts (title, body, create_date, end_date_time, start_date_time, start_time, end_time, user_id)
VALUES ('Third Post', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad, aspernatur dolor exercitationem nemo quia quis quo saepe. Ad aspernatur, autem beatae dolorem impedit labore nesciunt non officia, sed sequi veniam!
', curdate(), '2020-15-07T16:00:00.000', '2020-15-07T16:30:00.000', '12:00', '12:00', 3);

INSERT INTO posts (title, body, create_date, end_date_time, start_date_time, start_time, end_time, user_id)
VALUES ('Fourth Post', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad, aspernatur dolor exercitationem nemo quia quis quo saepe. Ad aspernatur, autem beatae dolorem impedit labore nesciunt non officia, sed sequi veniam!
', curdate(), '2020-14-07T16:00:00.000', '2020-14-07T16:30:00.000', '12:00', '12:00', 1);

INSERT INTO posts (title, body, create_date, end_date_time, start_date_time, start_time, end_time, user_id)
VALUES ('Fifth Post', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad, aspernatur dolor exercitationem nemo quia quis quo saepe. Ad aspernatur, autem beatae dolorem impedit labore nesciunt non officia, sed sequi veniam!
', curdate(), '2020-13-07T16:00:00.000', '2020-13-07T16:30:00.000', '12:00', '12:00', 1);

INSERT INTO posts (title, body, create_date, end_date_time, start_date_time, start_time, end_time, user_id)
VALUES ('Sixth Post', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad, aspernatur dolor exercitationem nemo quia quis quo saepe. Ad aspernatur, autem beatae dolorem impedit labore nesciunt non officia, sed sequi veniam!
', curdate(), '2020-13-07T16:00:00.000', '2020-13-07T16:30:00.000', '12:00', '12:00', 2);

INSERT INTO posts (title, body, create_date, end_date_time, start_date_time, start_time, end_time, user_id)
VALUES ('Seventh Post', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad, aspernatur dolor exercitationem nemo quia quis quo saepe. Ad aspernatur, autem beatae dolorem impedit labore nesciunt non officia, sed sequi veniam!
', curdate(), '2020-13-07T16:00:00.000', '2020-13-07T16:30:00.000', '12:00', '12:00', 3);

INSERT INTO posts (title, body, create_date, end_date_time, start_date_time, start_time, end_time, user_id)
VALUES ('Eight Post', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad, aspernatur dolor exercitationem nemo quia quis quo saepe. Ad aspernatur, autem beatae dolorem impedit labore nesciunt non officia, sed sequi veniam!
', curdate(), '2020-13-07T16:00:00.000', '2020-13-07T16:30:00.000', '12:00', '12:00', 1);

INSERT INTO posts (title, body, create_date, end_date_time, start_date_time, start_time, end_time, user_id)
VALUES ('Ninth Post', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad, aspernatur dolor exercitationem nemo quia quis quo saepe. Ad aspernatur, autem beatae dolorem impedit labore nesciunt non officia, sed sequi veniam!
', curdate(), '2020-13-07T16:00:00.000', '2020-13-07T16:30:00.000', '12:00', '12:00', 1);

INSERT INTO posts (title, body, create_date, end_date_time, start_date_time, start_time, end_time, user_id)
VALUES ('Tenth Post', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad, aspernatur dolor exercitationem nemo quia quis quo saepe. Ad aspernatur, autem beatae dolorem impedit labore nesciunt non officia, sed sequi veniam!
', curdate(), '2020-13-07T16:00:00.000', '2020-13-07T16:30:00.000', '12:00', '12:00', 1);

INSERT INTO categories(id, name) VALUES (1, 'Javascript');
INSERT INTO categories(id, name) VALUES (2, 'Java');
INSERT INTO categories(id, name) VALUES (3, 'Bootstrap');
INSERT INTO categories(id, name) VALUES (4, 'CSS');
INSERT INTO categories(id, name) VALUES (5, 'HTML');
INSERT INTO categories(id, name) VALUES (6, 'MySQL');
INSERT INTO categories(id, name) VALUES (7, 'JQuery');
INSERT INTO categories(id, name) VALUES (8, 'Spring');
INSERT INTO categories(id, name) VALUES (9, 'UX Design');
INSERT INTO categories(id, name) VALUES (10, 'Front-end');
INSERT INTO categories(id, name) VALUES (11, 'Back-end');
INSERT INTO categories(id, name) VALUES (13, 'Github');
INSERT INTO categories(id, name) VALUES (14, 'Code Review');
INSERT INTO categories(id, name) VALUES (15, 'Tech Life');
INSERT INTO categories(id, name) VALUES (16, 'Other');

INSERT INTO post_categories(post_id, category_id) VALUES (1, 2);
INSERT INTO post_categories(post_id, category_id) VALUES (2, 3);
INSERT INTO post_categories(post_id, category_id) VALUES (3, 4);
INSERT INTO post_categories(post_id, category_id) VALUES (4, 5);
INSERT INTO post_categories(post_id, category_id) VALUES (5, 6);
INSERT INTO post_categories(post_id, category_id) VALUES (6, 7);
INSERT INTO post_categories(post_id, category_id) VALUES (7, 8);
INSERT INTO post_categories(post_id, category_id) VALUES (8, 9);
INSERT INTO post_categories(post_id, category_id) VALUES (9, 10);
INSERT INTO post_categories(post_id, category_id) VALUES (10, 11);


INSERT INTO comments (body, post_id, user_id) VALUE('I want to join!', 1, 1);
INSERT INTO comments (body, post_id, user_id) VALUE('I want to join!', 2, 1);
INSERT INTO comments (body, post_id, user_id) VALUE('I want to join!', 1, 2);
INSERT INTO comments (body, post_id, user_id) VALUE('I want to join!', 3, 1);
INSERT INTO comments (body, post_id, user_id) VALUE('I want to join!', 4, 1);

INSERT INTO rsvp(post_id, user_id) VALUES (1, 1);
INSERT INTO rsvp(post_id, user_id) VALUES (2, 2);
INSERT INTO rsvp(post_id, user_id) VALUES (1, 2);
INSERT INTO rsvp(post_id, user_id) VALUES (3, 1);
INSERT INTO rsvp(post_id, user_id) VALUES (4, 1);
INSERT INTO rsvp(post_id, user_id) VALUES (2, 1);
INSERT INTO rsvp(post_id, user_id) VALUES (1, 3);
INSERT INTO rsvp(post_id, user_id) VALUES (2, 2);
INSERT INTO rsvp(post_id, user_id) VALUES (3, 3);