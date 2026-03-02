INSERT INTO app_user (id, name, email, password) VALUES
(1,'Vivaan Khanna', 'vivaan.khanna@example.com', '$2a$10$examplePasswordHash2'),
(2,'Aditya Verma', 'aditya.verma@example.com', '$2a$10$examplePasswordHash3'),
(3,'Vihaan Kapoor', 'vihaan.kapoor@example.com', '$2a$10$examplePasswordHash4'),
(4,'Arjun Patel', 'arjun.patel@example.com', '$2a$10$examplePasswordHash5'),
(5,'Sai Reddy', 'sai.reddy@example.com', '$2a$10$examplePasswordHash6'),
(6,'Ananya Nair', 'ananya.nair@example.com', '$2a$10$examplePasswordHash7'),
(7,'Ishaan Thakur', 'ishaan.thakur@example.com', '$2a$10$examplePasswordHash8'),
(8,'Aryan Rao', 'aryan.rao@example.com', '$2a$10$examplePasswordHash9'),
(9,'Diya Singh', 'diya.singh@example.com', '$2a$10$examplePasswordHash10'),
(10,'Kabir Joshi', 'kabir.joshi@example.com', '$2a$10$examplePasswordHash11'),
(11,'Krishna Iyer', 'krishna.iyer@example.com', '$2a$10$examplePasswordHash12'),
(12,'Reyansh Pandey', 'reyansh.pandey@example.com', '$2a$10$examplePasswordHash13'),
(13,'Ayaan Mehta', 'ayaan.mehta@example.com', '$2a$10$examplePasswordHash14'),
(14,'Anaya Mishra', 'anaya.mishra@example.com', '$2a$10$examplePasswordHash15'),
(15,'Navya Kulkarni', 'navya.kulkarni@example.com', '$2a$10$examplePasswordHash16'),
(16,'Naira Desai', 'naira.desai@example.com', '$2a$10$examplePasswordHash17'),
(17,'Dhruv Saxena', 'dhruv.saxena@example.com', '$2a$10$examplePasswordHash18'),
(18,'Sara Bajaj', 'sara.bajaj@example.com', '$2a$10$examplePasswordHash19'),
(19,'Arnav Malhotra', 'arnav.malhotra@example.com', '$2a$10$examplePasswordHash20'),
(20,'Rahul Kumar', 'rahul.kumar@example.com', '$2a$10$examplePasswordHash21'),
(21,'Rohit Gupta', 'rohit.gupta@example.com', '$2a$10$examplePasswordHash22'),
(22,'Pooja Sharma', 'pooja.sharma@example.com', '$2a$10$examplePasswordHash23'),
(23,'Karan Singh', 'karan.singh@example.com', '$2a$10$examplePasswordHash24');

INSERT INTO user_roles (user_id, roles) VALUES
(1, 'RIDER'),

(2, 'DRIVER'),
(3, 'RIDER'),
(4, 'RIDER'),

(5, 'DRIVER'),
(6, 'DRIVER'),
(7, 'DRIVER'),
(8, 'RIDER'),
(9, 'RIDER'),
(10, 'DRIVER'),
(11, 'DRIVER'),
(12, 'DRIVER'),
(13, 'DRIVER'),
(14, 'RIDER'),
(15, 'RIDER'),
(16, 'RIDER'),
(17, 'RIDER'),
(18, 'DRIVER'),
(19, 'DRIVER'),
(20, 'DRIVER'),
(21, 'DRIVER'),
(22, 'DRIVER'),
(23, 'DRIVER');

-- Insert data into rider table
INSERT INTO rider (user_id, rating) VALUES
(1, 4.9);

-- Insert data into driver table
INSERT INTO driver (user_id, rating,available, current_location) VALUES
( 2, 4.7, true, ST_GeomFromText('POINT(77.1025 28.7041)', 4326)),
( 3, 4.8, true, ST_GeomFromText('POINT(77.2167 28.6667)', 4326)),
( 5, 4.8, true, ST_GeomFromText('POINT(77.2273 28.6353)', 4326)),
( 6, 4.9, true, ST_GeomFromText('POINT(77.2500 28.5500)', 4326)),
( 7, 4.7, true, ST_GeomFromText('POINT(77.2800 28.5790)', 4326)),
( 8, 4.5, true, ST_GeomFromText('POINT(77.2600 28.6800)', 4326)),
( 9, 4.6, true, ST_GeomFromText('POINT(77.2200 28.6400)', 4326)),
( 10, 4.4, true, ST_GeomFromText('POINT(77.2700 28.6700)', 4326)),
(11, 4.3, true, ST_GeomFromText('POINT(77.2400 28.6900)', 4326)),
(12, 4.2, true, ST_GeomFromText('POINT(77.2800 28.6000)', 4326)),
(13, 4.3, true, ST_GeomFromText('POINT(77.2500 28.6200)', 4326)),
(14, 4.1, true, ST_GeomFromText('POINT(77.1900 28.7000)', 4326)),
(15, 4.5, true, ST_GeomFromText('POINT(77.1000 28.6200)', 4326)),
(16, 4.3, true, ST_GeomFromText('POINT(77.1200 28.6300)', 4326)),
(17, 4.3, true, ST_GeomFromText('POINT(77.1200 28.6700)', 4326)),
(18, 4.4, true, ST_GeomFromText('POINT(77.1400 28.6900)', 4326)),
(19, 4.7, true, ST_GeomFromText('POINT(77.1300 28.7000)', 4326)),
(20, 4.8, true, ST_GeomFromText('POINT(77.1100 28.7100)', 4326)),
(22, 4.5, true, ST_GeomFromText('POINT(77.2285 28.6159)', 4326)),
(23, 4.3, true, ST_GeomFromText('POINT(77.2345 28.6229)', 4326));

INSERT INTO wallet (id, user_id, balance) VALUES
(1,1, 100),
(2,2, 500);