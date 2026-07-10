# Write your MySQL query statement below
select r.contest_id, round(count(r.contest_id) * 100 / (select count(*) from Users), 2) as percentage
from Register r
left join Users u
on r.user_id = u.user_id
group by r.contest_id
order by percentage DESC, contest_id ASC;