-- Function example
CREATE OR REPLACE FUNCTION get_full_name(p_id IN NUMBER) RETURN VARCHAR2 IS
    v_first VARCHAR2(100);
    v_last VARCHAR2(100);
BEGIN
    SELECT first_name, last_name INTO v_first, v_last FROM students WHERE id = p_id;
    RETURN v_first || ' ' || v_last;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN NULL;
END get_full_name;
/
