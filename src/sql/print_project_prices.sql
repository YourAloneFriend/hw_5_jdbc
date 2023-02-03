SELECT duration_project.id, client_id, start_date, finish_date, SUM(salary) * duration_project.monthes AS cost
 FROM worker
 JOIN project_worker ON worker.id = project_worker.worker_id
 JOIN (SELECT *, DATEDIFF(finish_date, start_date)/30 AS monthes FROM project) AS duration_project
 ON duration_project.id = project_worker.project_id
 GROUP BY duration_project.id ORDER BY duration_project.id;