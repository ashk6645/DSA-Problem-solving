# Write your MySQL query statement below
SELECT e.name
FROM Employee e
JOIN (
    SELECT managerID
    FROM Employee
    WHERE managerID IS NOT NULL
    GROUP BY managerID
    HAVING COUNT(*) >= 5
) m ON e.id = m.managerID;