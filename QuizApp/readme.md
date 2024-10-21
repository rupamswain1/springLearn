run the below querry to load sample data to database


INSERT INTO question (id,description, option1, option2, option3, option4, correct_answer, category, difficulty)
VALUES
(1,'What is the size of an int in Java?', '4 bytes', '8 bytes', '16 bytes', 'Depends on the JVM', '4 bytes', 'Java', 'Easy'),
(2,'Which of these is a Python data structure?', 'Array', 'List', 'Queue', 'Stack', 'List', 'Python', 'Easy'),
(3,'Which keyword is used to define a function in JavaScript?', 'def', 'function', 'lambda', 'fun', 'function', 'JavaScript', 'Easy'),
(4,'Which of the following is not a valid Java data type?', 'int', 'float', 'number', 'char', 'number', 'Java', 'Medium'),
(5,'How do you declare a variable in Python?', 'let x', 'var x', 'x = 10', 'const x', 'x = 10', 'Python', 'Easy'),
(6,'Which operator is used for strict equality in JavaScript?', '=', '==', '===', '!=', '===', 'JavaScript', 'Medium'),
(7,'What is the correct way to start a multi-line comment in Java?', '/*', '//', '#', '--', '/*', 'Java', 'Easy'),
(8,'How do you create a dictionary in Python?', '{}', '[]', '()', '<>', '{}', 'Python', 'Easy'),
(9,'What does "this" refer to in JavaScript?', 'Global object', 'Current object', 'Window object', 'None', 'Current object', 'JavaScript', 'Medium'),
(10,'Which of these is a primitive data type in Java?', 'String', 'Integer', 'Boolean', 'Float', 'Boolean', 'Java', 'Easy'),
(11,'How do you declare a list in Python?', 'array()', 'list[]', '[1, 2, 3]', '<1, 2, 3>', '[1, 2, 3]', 'Python', 'Easy'),
(12,'Which of these is a valid way to declare a variable in JavaScript?', 'let x = 10;', 'var x := 10;', 'int x = 10;', 'constant x = 10;', 'let x = 10;', 'JavaScript', 'Easy'),
(13,'What is the default value of an int variable in Java?', '0', 'null', 'undefined', '-1', '0', 'Java', 'Easy'),
(14,'How do you handle exceptions in Python?', 'try/catch', 'try/except', 'try/finally', 'throw', 'try/except', 'Python', 'Medium'),
(15,'Which method is used to remove the last element from an array in JavaScript?', 'pop()', 'remove()', 'splice()', 'cut()', 'pop()', 'JavaScript', 'Medium'),
(16,'What is a constructor in Java?', 'A method', 'A variable', 'A class', 'A special method to initialize objects', 'A special method to initialize objects', 'Java', 'Medium'),
(17,'How do you define a lambda function in Python?', 'lambda()', 'lambda x: x + 1', 'function()', 'def lambda()', 'lambda x: x + 1', 'Python', 'Medium'),
(18,'What is "use strict" in JavaScript?', 'A variable declaration', 'A function', 'A directive for strict mode', 'A library', 'A directive for strict mode', 'JavaScript', 'Medium'),
(19,'Which of these is a loop structure in Java?', 'while', 'foreach', 'forof', 'repeat', 'while', 'Java', 'Easy'),
(20,'How do you create a class in Python?', 'class MyClass:', 'def MyClass:', 'create class MyClass', 'new MyClass:', 'class MyClass:', 'Python', 'Medium');
