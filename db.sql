CREATE DATABASE student;

CREATE USER Java;
\du # show all user role and privileges

GRANT ALL PRIVILEGES ON DATABASE "student" TO Java;
\c student