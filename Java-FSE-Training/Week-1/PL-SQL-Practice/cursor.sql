-- Cursor example
DECLARE
    CURSOR c_students IS SELECT id, first_name, last_name FROM students;
    v_id students.id%TYPE;
    v_first students.first_name%TYPE;
    v_last students.last_name%TYPE;
BEGIN
    OPEN c_students;
    LOOP
        FETCH c_students INTO v_id, v_first, v_last;
        EXIT WHEN c_students%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(v_id || ': ' || v_first || ' ' || v_last);
    END LOOP;
    CLOSE c_students;
END;
/
