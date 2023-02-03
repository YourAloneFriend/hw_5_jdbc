CREATE TABLE IF NOT EXISTS worker(
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(1000) NOT NULL,
birthday DATE NOT NULL,
level VARCHAR(10) NOT NULL,
salary INT NOT NULL,
CONSTRAINT worker_name_check CHECK (CHAR_LENGTH(name) >= 2),
CONSTRAINT worker_birthday_check CHECK (birthday > '1900-12-31'),
CONSTRAINT worker_level_check CHECK (level IN ('Trainee', 'Junior', 'Middle', 'Senior')),
CONSTRAINT worker_salary_check CHECK (salary >= 100 AND salary <= 100000)
);


CREATE TABLE IF NOT EXISTS client(
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(1000) NOT NULL,
CONSTRAINT client_name_check CHECK (CHAR_LENGTH(name) >= 2)
);


CREATE TABLE IF NOT EXISTS project(
id INT AUTO_INCREMENT PRIMARY KEY,
client_id INT NOT NULL,
start_date DATE NOT NULL,
finish_date DATE,
FOREIGN KEY(client_id) REFERENCES client(id) 
);


CREATE TABLE IF NOT EXISTS project_worker(
project_id INT NOT NULL,
worker_id INT NOT NULL,
PRIMARY KEY (project_id, worker_id),
FOREIGN KEY (project_id) REFERENCES project(id),
FOREIGN KEY (worker_id) REFERENCES worker(id)
);
