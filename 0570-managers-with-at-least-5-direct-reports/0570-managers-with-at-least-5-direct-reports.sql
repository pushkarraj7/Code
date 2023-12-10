# Write your MySQL query statement below
SELECT manager.name
FROM Employee manager
JOIN Employee employee ON manager.id = employee.managerId
GROUP BY manager.id, manager.name
HAVING COUNT(DISTINCT employee.id) >= 5;