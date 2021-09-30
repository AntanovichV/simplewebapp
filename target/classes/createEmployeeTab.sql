DROP SCHEMA IF EXISTS employee_db;
CREATE SCHEMA IF NOT EXISTS employee_db;
USE employee_db;
CREATE TABLE employee (
    employee_id   SERIAL PRIMARY KEY AUTO_INCREMENT,
    first_name    VARCHAR(255) NOT NULL,
    last_name     VARCHAR(255) NOT NULL,
    department_id INT NOT NULL,
    job_title     VARCHAR(255) NOT NULL,
    gender        VARCHAR(16) NOT NULL,
    date_of_birth DATE  NOT NULL
);

INSERT INTO employee (first_name, last_name, department_id, job_title, gender, date_of_birth)
VALUES ('Vasiliy', 'Tamello', 1, 'Assistant', 'MALE', '2012-07-17'),
       ('Maks', 'Moroz', 3, 'Administrator', 'MALE', '2017-07-07'),
       ('Mike', 'Williams', 5, 'Bodyguard', 'MALE', '1996-11-14'),
       ('Ivan', 'Golovonog', 43, 'Architect', 'MALE', '1990-08-30'),
       ('Valery', 'Vessel', 65, 'Consultant', 'FEMALE', '2001-08-20');