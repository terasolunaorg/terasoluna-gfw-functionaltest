--------------------
-- DROP PROCEDURE --
--------------------
CREATE OR REPLACE PROCEDURE DROP_TABLE(IN tableName VARCHAR(50)) 
LANGUAGE SQL 
BEGIN 
	DECLARE cnt INTEGER DEFAULT 0; 

	SELECT COUNT(tabname) into cnt FROM syscat.tables WHERE tabname = UPPER(tableName); 
	if cnt > 0 then 
		execute immediate 'DROP TABLE ' || tableName; 
	end if; 
END 

