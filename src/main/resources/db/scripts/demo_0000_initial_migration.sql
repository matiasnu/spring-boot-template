-- Migration Version 0000 - Initial Migration
-- ------------------------------------------------------


-- USER TO OPERATE DB --

-- CREATE USER IF NOT EXISTS 'demo'@'%' IDENTIFIED BY 'demo';

-- FLUSH PRIVILEGES;

-- CREATE DEMO DB --
-- CREATE DATABASE IF NOT EXISTS demo;


-- GRANTS TO DEMO DB USERS --

-- GRANT SELECT, INSERT, UPDATE, DELETE ON demo.* TO 'demo'@'%';
-- FLUSH PRIVILEGES;