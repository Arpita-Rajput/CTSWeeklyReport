-- Exception handling example
BEGIN
    BEGIN
        RAISE_APPLICATION_ERROR(-20001, 'Custom error');
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error occurred: ' || SQLERRM);
    END;
END;
/
