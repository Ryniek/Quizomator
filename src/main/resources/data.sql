INSERT INTO category (id, name, author) VALUES (1, 'Historia', 'GLOBAL');
INSERT INTO category (id, name, author) VALUES (2, 'Matematyka', 'GLOBAL');
INSERT INTO category (id, name, author) VALUES (3, 'Chemia', 'GLOBAL');
INSERT INTO category (id, name, author) VALUES (4, 'Sport', 'GLOBAL');
INSERT INTO category (id, name, author) VALUES (5, 'Sztuka', 'GLOBAL');
INSERT INTO category (id, name, author) VALUES (6, 'Medycyna', 'GLOBAL');
INSERT INTO category (id, name, author) VALUES (7, 'Spring', 'michalrynski96@gmail.com');
INSERT INTO category (id, name, author) VALUES (8, 'Java', 'michalrynski96@gmail.com');
INSERT INTO category (id, name, author) VALUES (9, 'Wzorce projektowe', 'michalrynski96@gmail.com');
INSERT INTO category (id, name, author) VALUES (10, 'Git', 'michalrynski96@gmail.com');
INSERT INTO category (id, name, author) VALUES (11, 'Hibernate', 'michalrynski96@gmail.com');

INSERT INTO question (id, content, answer_a, answer_b, answer_c, answer_d, correct_answer, author, is_private, is_accepted)
VALUES (1, 'Kiedy wybuchła II Wojna Światowa?' , '8 maja 1945', '1 września 1939', '10 września 1939', '20 października 1940', 'B', 'michalrynski96@gmail.com', FALSE, TRUE);
INSERT INTO question (id, content, answer_a, answer_b, answer_c, answer_d, correct_answer, author, is_private, is_accepted)
VALUES (2, 'Gdzie Tadeusz Kościuszko ogłosił "akt powstania"? ', 'W Krakowie', 'W Warszawie', 'W Gdańsku', 'W Poznaniu', 'A', 'michalrynski96@gmail.com', FALSE, FALSE);
INSERT INTO question (id, content, answer_a, answer_b, answer_c, answer_d, correct_answer, author, is_private, is_accepted)
VALUES (3, 'Twórcą opery "Aida" jest: ', 'Georges Bizet', 'Giacomo Puccini', 'Gioacchino Rossini', 'Giuseppe Verdi', 'D', 'michalrynski96@gmail.com', FALSE, FALSE);
INSERT INTO question (id, content, answer_a, answer_b, answer_c, answer_d, correct_answer, author, is_private, is_accepted)
VALUES (4, 'Zwycięzcą Ligi Mistrzów w siatkówkę w sezonie 2019/2020 został: ', 'Zenit Kazań', 'PGE Skra Bełchatów', 'Sir Safety Perugia', 'Cucine Lube Civitanova', 'D', 'GLOBAL', FALSE, TRUE);
INSERT INTO question (id, content, answer_a, answer_b, answer_c, answer_d, correct_answer, author, is_private, is_accepted)
VALUES (5, 'Która adnotacja służy uruchomienia danej metody od razu przy starcie aplikacji: ', '@EventHandler(ApplicationReadyContext.class)', '@Service', '@Id', '@SpringBootApplication', 'A', 'michalrynski96@gmail.com', TRUE, TRUE);


INSERT INTO question_category (question_id, category_id)
VALUES (1, 1);
INSERT INTO question_category (question_id, category_id)
VALUES (2, 1);
INSERT INTO question_category (question_id, category_id)
VALUES (3, 2);
INSERT INTO question_category (question_id, category_id)
VALUES (4, 4);
INSERT INTO question_category (question_id, category_id)
VALUES (5, 7);

