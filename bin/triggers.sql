-- CUSTOMER ---------------------------------------------------------------------------------------

CREATE OR REPLACE FUNCTION set_CREATED_AT_for_CUSTOMER() RETURNS TRIGGER AS $BODY$
BEGIN
    NEW.CREATED_AT = now();
    RETURN NEW;
END; $BODY$
LANGUAGE plpgsql;

CREATE TRIGGER set_CREATED_AT_on_before_INSERT
BEFORE INSERT ON CUSTOMER
FOR EACH ROW
EXECUTE PROCEDURE set_CREATED_AT_for_CUSTOMER();


-- BACKLOG ---------------------------------------------------------------------------------------

CREATE OR REPLACE FUNCTION set_CREATED_AT_for_BACKLOG() RETURNS TRIGGER AS $BODY$
BEGIN
    NEW.CREATED_AT = now();
    RETURN NEW;
END; $BODY$
LANGUAGE plpgsql;

CREATE TRIGGER set_CREATED_AT_on_before_INSERT
BEFORE INSERT ON BACKLOG
FOR EACH ROW
EXECUTE PROCEDURE set_CREATED_AT_for_BACKLOG();


-- TASK ---------------------------------------------------------------------------------------

CREATE OR REPLACE FUNCTION set_CREATED_AT_for_TASK() RETURNS TRIGGER AS $BODY$
BEGIN
    NEW.CREATED_AT = now();
    RETURN NEW;
END; $BODY$
LANGUAGE plpgsql;

CREATE TRIGGER set_CREATED_AT_on_before_INSERT
BEFORE INSERT ON TASK
FOR EACH ROW
EXECUTE PROCEDURE set_CREATED_AT_for_TASK();