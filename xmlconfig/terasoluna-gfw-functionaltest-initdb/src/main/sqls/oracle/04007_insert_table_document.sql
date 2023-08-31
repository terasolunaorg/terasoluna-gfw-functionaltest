-- file download table
INSERT ALL
INTO document VALUES (1, TO_BLOB(UTL_RAW.CAST_TO_RAW('Spring Framework')))
SELECT * FROM DUAL
