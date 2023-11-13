--------------------
-- DROP SEQUENCE --
--------------------
CREATE OR REPLACE PROCEDURE DROP_SEQUENCE(sequenceName VARCHAR2)
IS
    cnt int := 0;
BEGIN
	SELECT COUNT(*) INTO cnt FROM USER_SEQUENCES WHERE SEQUENCE_NAME = UPPER(sequenceName);
	if cnt > 0 then
		execute immediate 'DROP SEQUENCE ' || sequenceName; 
	end if;
END;
