--------------------
-- DROP SEQUENCE --
--------------------
CREATE OR REPLACE PROCEDURE DROP_SEQUENCE(IN sequenceName VARCHAR(50)) 
LANGUAGE SQL 
BEGIN 
	DECLARE cnt INTEGER DEFAULT 0; 

	SELECT COUNT(seqname) into cnt FROM syscat.sequences WHERE seqname = UPPER(sequenceName); 
	if cnt > 0 then 
		execute immediate 'DROP SEQUENCE ' || sequenceName; 
	end if; 
END 

