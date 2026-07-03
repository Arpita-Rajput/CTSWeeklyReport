-- Create table example
CREATE TABLE students (
    id NUMBER PRIMARY KEY,
    first_name VARCHAR2(100),
    last_name VARCHAR2(100),
    created_at DATE DEFAULT SYSDATE
);
