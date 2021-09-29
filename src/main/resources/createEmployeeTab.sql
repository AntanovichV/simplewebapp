CREATE TYPE GENDER AS ENUM ('MALE', 'FEMALE');
DROP TABLE IF EXISTS employee;
CREATE TABLE employee
(
    employee_Id   SERIAL PRIMARY KEY,
    first_Name    VARCHAR(50) NOT NULL,
    last_Name     VARCHAR(50 NOT NULL,
    department_Id int  NOT NULL,
    job_Title     VARCHAR(255) NOT NULL,
    gender        VARCHAR(16) NOT NULL,
    date_Of_Birth DATE  NOT NULL
);

INSERT INTO employee (first_name, last_name, department_id, job_title, gender, date_of_birth)
VALUES ('Vasiiy', 'Tamello', 1, 'Assistant', 'MALE', '2012-07-17'),
       ('Maks', 'Moroz', 3, 'Administrator', 'MALE', '2017-07-07'),
       ('Mike', 'Williams', 5, 'Bodyguard', 'MALE', '1996-11-14'),
       ('Ivan', 'Golovonog', 43, 'Architect', 'MALE', '1990-08-30'),
       ('Valery', 'Veselova', 65, 'Consultant', 'FEMALE', '2001-08-20');