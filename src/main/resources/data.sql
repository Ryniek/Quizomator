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
VALUES (3, 'Twórcą opery "Aida" jest? ', 'Georges Bizet', 'Giacomo Puccini', 'Gioacchino Rossini', 'Giuseppe Verdi', 'D', 'michalrynski96@gmail.com', FALSE, FALSE);
INSERT INTO question (id, content, answer_a, answer_b, answer_c, answer_d, correct_answer, author, is_private, is_accepted)
VALUES (4, 'Zwycięzcą Ligi Mistrzów w siatkówkę w sezonie 2019/2020 został? ', 'Zenit Kazań', 'PGE Skra Bełchatów', 'Sir Safety Perugia', 'Cucine Lube Civitanova', 'D', 'GLOBAL', FALSE, TRUE);
INSERT INTO question (id, content, answer_a, answer_b, answer_c, answer_d, correct_answer, author, is_private, is_accepted)
VALUES (5, 'Która adnotacja służy do wywołania metody od razu przy starcie aplikacji? ', '@EventHandler(ApplicationReadyContext.class)', '@Service', '@Id', '@SpringBootApplication', 'A', 'michalrynski96@gmail.com', TRUE, TRUE);
INSERT INTO question (id, content, answer_a, answer_b, answer_c, answer_d, correct_answer, author, is_private, is_accepted)
VALUES (6, 'Kto w 1914 roku zamordował arcyksięcia Ferdynanda? ', 'Jurji Szatałow', 'Gawriło Princip', 'Iwan Mostow', 'Franciszek Józef I', 'B', 'GLOBAL', FALSE, TRUE);
INSERT INTO question (id, content, answer_a, answer_b, answer_c, answer_d, correct_answer, author, is_private, is_accepted)
VALUES (7, 'Jaką wyspę ostrzeliwał pancernik Schleswig-Holstein dnia 1 września 1939 o godzinie 4:45? ', 'Westerplatte', 'Wolin', 'Półwysep Helski', 'Mierzeje Wiślaną', 'A', 'GLOBAL', FALSE, TRUE);
INSERT INTO question (id, content, answer_a, answer_b, answer_c, answer_d, correct_answer, author, is_private, is_accepted)
VALUES (8, 'W 1920 roku podjęto decyzję o budowie nowego polskiego portu. W jakim mieście? ', 'Gdańsk', 'Sopot', 'Gdynia', 'Szczecin', 'C', 'GLOBAL', FALSE, TRUE);
INSERT INTO question (id, content, answer_a, answer_b, answer_c, answer_d, correct_answer, author, is_private, is_accepted)
VALUES (9, 'Ile trwa jedna część meczu piłki ręcznej? ', '10 minut', '20 minut', '30 minut', '40 minut', 'C', 'GLOBAL', FALSE, TRUE);
INSERT INTO question (id, content, answer_a, answer_b, answer_c, answer_d, correct_answer, author, is_private, is_accepted)
VALUES (10, 'Jak ma na imie żona Roberta Lewandowskiego? ', 'Anna', 'Zofia', 'Małgorzata', 'Katarzyna', 'A', 'GLOBAL', FALSE, TRUE);
INSERT INTO question (id, content, answer_a, answer_b, answer_c, answer_d, correct_answer, author, is_private, is_accepted)
VALUES (11, 'Jaka jest długość bieżni stadionu lekkoatletycznego? ', '420 metrów', '400 metrów', '500 metrów', '350 metrów', 'B', 'GLOBAL', FALSE, TRUE);


INSERT INTO question_category (question_id, category_id)
VALUES (1, 1);
INSERT INTO question_category (question_id, category_id)
VALUES (2, 1);
INSERT INTO question_category (question_id, category_id)
VALUES (3, 5);
INSERT INTO question_category (question_id, category_id)
VALUES (4, 4);
INSERT INTO question_category (question_id, category_id)
VALUES (5, 7);
INSERT INTO question_category (question_id, category_id)
VALUES (6, 1);
INSERT INTO question_category (question_id, category_id)
VALUES (7, 1);
INSERT INTO question_category (question_id, category_id)
VALUES (8, 1);
INSERT INTO question_category (question_id, category_id)
VALUES (9, 4);
INSERT INTO question_category (question_id, category_id)
VALUES (10, 4);
INSERT INTO question_category (question_id, category_id)
VALUES (11, 4);

