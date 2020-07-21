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

INSERT INTO posts (title, body, create_date, end_date_time, start_date_time, event_time)
VALUES ('First Post', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad, aspernatur dolor exercitationem nemo quia quis quo saepe. Ad aspernatur, autem beatae dolorem impedit labore nesciunt non officia, sed sequi veniam!
', curdate(), '2021-12-08T08:30:00.000', '2021-12-09T16:30:00.000', '12:00');

INSERT INTO posts (title, body, create_date, end_date_time, start_date_time, event_time)
VALUES ('Second Post', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad, aspernatur dolor exercitationem nemo quia quis quo saepe. Ad aspernatur, autem beatae dolorem impedit labore nesciunt non officia, sed sequi veniam!
', curdate(), '2021-12-08T08:30:00.000', '2021-12-09T16:30:00.000', '12:00');

INSERT INTO posts (title, body, create_date, end_date_time, start_date_time, event_time)
VALUES ('Third Post', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad, aspernatur dolor exercitationem nemo quia quis quo saepe. Ad aspernatur, autem beatae dolorem impedit labore nesciunt non officia, sed sequi veniam!
', curdate(), '2021-12-08T08:30:00.000', '2021-12-09T16:30:00.000', '12:00');

INSERT INTO posts (title, body, create_date, end_date_time, start_date_time, event_time)
VALUES ('Fourth Post', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad, aspernatur dolor exercitationem nemo quia quis quo saepe. Ad aspernatur, autem beatae dolorem impedit labore nesciunt non officia, sed sequi veniam!
', curdate(), '2021-12-08T08:30:00.000', '2021-12-09T16:30:00.000', '12:00');

INSERT INTO posts (title, body, create_date, end_date_time, start_date_time, event_time)
VALUES ('Fifth Post', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad, aspernatur dolor exercitationem nemo quia quis quo saepe. Ad aspernatur, autem beatae dolorem impedit labore nesciunt non officia, sed sequi veniam!
', curdate(), '2021-12-08T08:30:00.000', '2021-12-09T16:30:00.000', '12:00');


INSERT INTO comments (body, post_id, user_id) VALUE('I want to join!.', 1, 1);
INSERT INTO comments (body, post_id, user_id) VALUE('I want to join!.', 2, 1);
INSERT INTO comments (body, post_id, user_id) VALUE('I want to join!.', 1, 2);
INSERT INTO comments (body, post_id, user_id) VALUE('I want to join!.', 3, 1);
INSERT INTO comments (body, post_id, user_id) VALUE('I want to join!.', 4, 1);

INSERT INTO categories(id, name) VALUES (1, 'Java');
INSERT INTO categories(id, name) VALUES (2, 'JavaScript');
INSERT INTO categories(id, name) VALUES (3, 'Bootstrap');
INSERT INTO categories(id, name) VALUES (4, 'CSS');
INSERT INTO categories(id, name) VALUES (5, 'Frontend');
INSERT INTO categories(id, name) VALUES (6, 'Backend');
INSERT INTO categories(id, name) VALUES (7, 'Spring');
INSERT INTO categories(id, name) VALUES (9, 'TechLife');

INSERT INTO rsvp(post_id, user_id) VALUES (1, 1);
INSERT INTO rsvp(post_id, user_id) VALUES (2, 2);
INSERT INTO rsvp(post_id, user_id) VALUES (1, 2);
INSERT INTO rsvp(post_id, user_id) VALUES (3, 1);
INSERT INTO rsvp(post_id, user_id) VALUES (4, 1);
INSERT INTO rsvp(post_id, user_id) VALUES (2, 1);
INSERT INTO rsvp(post_id, user_id) VALUES (1, 3);
INSERT INTO rsvp(post_id, user_id) VALUES (2, 2);
INSERT INTO rsvp(post_id, user_id) VALUES (3, 3);