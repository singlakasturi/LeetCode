# Write your MySQL query statement below
select class
from (
    select class, count(distinct(student)) as cnt
    from courses
    group by class
) t
where t.cnt > 4;