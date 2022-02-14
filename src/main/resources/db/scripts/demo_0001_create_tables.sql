--
-- Migration Version 0001 - Create tables
-- ------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS users;

CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       first_name VARCHAR(225) NOT NULL,
                       last_name VARCHAR(225) NOT NULL,
                       email VARCHAR(225) NOT NULL UNIQUE
);