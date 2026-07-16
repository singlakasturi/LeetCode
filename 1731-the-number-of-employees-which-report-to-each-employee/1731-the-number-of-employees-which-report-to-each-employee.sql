# Write your MySQL query statement below
select e.employee_id, e.name, count(*) as reports_count, round(avg(t.age)) as average_age
from Employees e
join Employees t
on e.employee_id = t.reports_to
group by e.employee_id, e.name
order by e.employee_id;