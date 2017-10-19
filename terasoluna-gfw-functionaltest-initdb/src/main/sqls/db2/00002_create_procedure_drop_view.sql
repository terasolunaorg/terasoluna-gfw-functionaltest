--------------------
-- DROP VIEW --
--------------------
CREATE OR REPLACE PROCEDURE DROP_VIEW(IN viewName VARCHAR(50))
LANGUAGE SQL
BEGIN
    DECLARE cnt INTEGER DEFAULT 0;

	SELECT COUNT(seqname) INTO cnt FROM syscat.sequences WHERE seqname = UPPER(viewName);
	if cnt > 0 then
		execute immediate 'DROP VIEW ' || viewName; 
	end if;
END
