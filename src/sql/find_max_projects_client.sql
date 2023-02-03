CREATE VIEW IF NOT EXISTS max_count_table AS SELECT MAX(project_count) AS max_count FROM(
 SELECT name, COUNT(*) AS project_count FROM worker
 JOIN project_worker ON worker.id = project_worker.worker_id
 JOIN project ON project.id = project_worker.project_id
 GROUP BY worker.id) AS max_result;

SELECT worker.id, name, COUNT(*) AS project_count FROM worker
 JOIN project_worker ON worker.id = project_worker.worker_id
 JOIN project ON project.id = project_worker.project_id
 GROUP BY worker.id
 HAVING project_count = (SELECT max_count FROM max_count_table);