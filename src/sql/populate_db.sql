INSERT INTO worker(name, birthday, level, salary) VALUES('Vlad', '1999-12-03', 'Junior', 400);
INSERT INTO worker(name, birthday, level, salary) VALUES('Stas', '1998-10-02', 'Junior', 580);
INSERT INTO worker(name, birthday, level, salary) VALUES('Nikita', '1994-12-23', 'Middle', 1400);
INSERT INTO worker(name, birthday, level, salary) VALUES('Volodymyr', '2000-01-10', 'Middle', 1200);
INSERT INTO worker(name, birthday, level, salary) VALUES('Maxim', '2002-12-13', 'Junior', 400);
INSERT INTO worker(name, birthday, level, salary) VALUES('George', '2004-03-13', 'Trainee', 100);
INSERT INTO worker(name, birthday, level, salary) VALUES('Oleksandr', '2003-05-03', 'Trainee', 100);
INSERT INTO worker(name, birthday, level, salary) VALUES('Viktoria', '1990-11-03', 'Senior', 4000);
INSERT INTO worker(name, birthday, level, salary) VALUES('Serhei', '1999-08-03', 'Senior', 4200);
INSERT INTO worker(name, birthday, level, salary) VALUES('Vano', '1989-03-03', 'Senior', 5400);


INSERT INTO client(name) VALUES('Stas');
INSERT INTO client(name) VALUES('Marina');
INSERT INTO client(name) VALUES('Volodymyr');
INSERT INTO client(name) VALUES('Nazar');
INSERT INTO client(name) VALUES('Gordon');


INSERT INTO project(client_id, start_date, finish_date) VALUES(1, '2022-03-03', '2023-03-03');
INSERT INTO project(client_id, start_date, finish_date) VALUES(1, '2022-05-03', '2023-01-23');
INSERT INTO project(client_id, start_date, finish_date) VALUES(2, '2022-06-13', '2022-07-13');
INSERT INTO project(client_id, start_date, finish_date) VALUES(2, '2022-10-23', '2022-12-23');
INSERT INTO project(client_id, start_date, finish_date) VALUES(3, '2022-03-03', '2025-03-03');
INSERT INTO project(client_id, start_date, finish_date) VALUES(3, '2022-03-03', '2026-03-03');
INSERT INTO project(client_id, start_date, finish_date) VALUES(4, '2022-03-03', '2024-03-03');
INSERT INTO project(client_id, start_date, finish_date) VALUES(4, '2022-03-03', '2023-03-03');
INSERT INTO project(client_id, start_date, finish_date) VALUES(5, '2022-10-03', '2024-03-03');
INSERT INTO project(client_id, start_date, finish_date) VALUES(5, '2022-10-03', '2023-03-03');


INSERT INTO project_worker(project_id, worker_id) VALUES(1, 1);
INSERT INTO project_worker(project_id, worker_id) VALUES(1, 8);
INSERT INTO project_worker(project_id, worker_id) VALUES(1, 5);

INSERT INTO project_worker(project_id, worker_id) VALUES(2, 9);

INSERT INTO project_worker(project_id, worker_id) VALUES(3, 6);
INSERT INTO project_worker(project_id, worker_id) VALUES(3, 7);

INSERT INTO project_worker(project_id, worker_id) VALUES(4, 10);

INSERT INTO project_worker(project_id, worker_id) VALUES(5, 3);

INSERT INTO project_worker(project_id, worker_id) VALUES(6, 2);
INSERT INTO project_worker(project_id, worker_id) VALUES(6, 4);
INSERT INTO project_worker(project_id, worker_id) VALUES(6, 5);

INSERT INTO project_worker(project_id, worker_id) VALUES(7, 3);

INSERT INTO project_worker(project_id, worker_id) VALUES(8, 1);
INSERT INTO project_worker(project_id, worker_id) VALUES(8, 8);

INSERT INTO project_worker(project_id, worker_id) VALUES(9, 2);
INSERT INTO project_worker(project_id, worker_id) VALUES(9, 6);

INSERT INTO project_worker(project_id, worker_id) VALUES(10, 6);
INSERT INTO project_worker(project_id, worker_id) VALUES(10, 1);
INSERT INTO project_worker(project_id, worker_id) VALUES(10, 5);
INSERT INTO project_worker(project_id, worker_id) VALUES(10, 10);
INSERT INTO project_worker(project_id, worker_id) VALUES(10, 9);