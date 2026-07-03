-- Trigger example
CREATE OR REPLACE TRIGGER students_before_insert
BEFORE INSERT ON students
FOR EACH ROW
BEGIN
    :NEW.created_at := SYSDATE;
END;
/
