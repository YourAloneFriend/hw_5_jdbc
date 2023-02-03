SELECT id, client_id, DATEDIFF(finish_date, start_date) AS duration 
 FROM project
 HAVING duration = (SELECT MAX(DATEDIFF(finish_date, start_date)) FROM project);