--------------------
-- DROP VIEW --
--------------------
CREATE OR REPLACE PROCEDURE DROP_VIEW(viewName VARCHAR2)
IS
    cnt int := 0;
BEGIN
	SELECT COUNT(*) INTO cnt FROM USER_VIEWS WHERE VIEW_NAME = UPPER(viewName);
	if cnt > 0 then
		execute immediate 'DROP VIEW ' || viewName; 
	end if;
END;

