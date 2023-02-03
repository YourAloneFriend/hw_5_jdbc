SELECT *, IF(birthday = 
 (SELECT MAX(birthday) FROM worker), 'youngest', 'eldest')
 AS type FROM worker
 WHERE birthday = (SELECT MAX(birthday) FROM worker)
 OR birthday = (SELECT MIN(birthday) FROM worker);