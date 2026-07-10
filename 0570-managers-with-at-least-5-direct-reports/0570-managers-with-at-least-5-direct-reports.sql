# Write your MySQL query statement below
select e.name
from Employee e
left join Employee ee
on e.id = ee.managerId
group by e.id
having count(e.id) > 4;