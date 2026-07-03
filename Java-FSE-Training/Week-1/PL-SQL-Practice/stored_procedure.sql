-- Stored procedure example
CREATE OR REPLACE PROCEDURE add_student(p_id IN NUMBER, p_first IN VARCHAR2, p_last IN VARCHAR2) IS
BEGIN
    INSERT INTO students(id, first_name, last_name) VALUES (p_id, p_first, p_last);
    COMMIT;
END add_student;
/
