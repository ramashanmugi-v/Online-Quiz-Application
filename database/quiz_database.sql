CREATE DATABASE online_quiz_db;

USE online_quiz_db;

CREATE TABLE users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE questions (
    question_id INT PRIMARY KEY AUTO_INCREMENT,
    question_text VARCHAR(500) NOT NULL,
    option_a VARCHAR(200) NOT NULL,
    option_b VARCHAR(200) NOT NULL,
    option_c VARCHAR(200) NOT NULL,
    option_d VARCHAR(200) NOT NULL,
    correct_answer CHAR(1) NOT NULL,
    category VARCHAR(50)
);

CREATE TABLE quiz_results (
    result_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    total_questions INT NOT NULL,
    correct_answers INT NOT NULL,
    wrong_answers INT NOT NULL,
    score INT NOT NULL,
    percentage DECIMAL(5,2) NOT NULL,
    result_status VARCHAR(20),
    quiz_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

INSERT INTO questions
(question_text, option_a, option_b, option_c, option_d, correct_answer, category)
VALUES
('Which keyword is used to inherit a class in Java?',
 'implements', 'extends', 'inherits', 'super', 'B', 'Java'),

('Which method is the entry point of a Java program?',
 'start()', 'run()', 'main()', 'execute()', 'C', 'Java'),

('Which data type is used to store whole numbers in Java?',
 'float', 'double', 'int', 'char', 'C', 'Java'),

('Which symbol is used to end a statement in Java?',
 '.', ':', ';', ',', 'C', 'Java'),

('Which concept allows the same method name with different parameters?',
 'Inheritance', 'Polymorphism', 'Encapsulation', 'Abstraction', 'B', 'Java'),

('Which keyword is used to create an object in Java?',
 'class', 'object', 'new', 'create', 'C', 'Java'),

('Which collection does not allow duplicate elements?',
 'List', 'ArrayList', 'Set', 'Queue', 'C', 'Java'),

('Which operator is used for logical AND in Java?',
 '&', '&&', '||', '!', 'B', 'Java'),

('Which keyword is used to define a constant in Java?',
 'static', 'final', 'const', 'fixed', 'B', 'Java'),

('Which exception occurs when dividing a number by zero?',
 'NullPointerException',
 'IOException',
 'ArithmeticException',
 'SQLException',
 'C', 'Java');

SELECT * FROM questions;