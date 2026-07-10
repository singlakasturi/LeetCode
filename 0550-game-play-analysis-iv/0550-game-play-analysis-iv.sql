# Write your MySQL query statement below
with temp as(
    select player_id, MIN(event_date) as first_login
    from activity
    group by player_id
)

select round(
    sum(
        case
            when a.event_date = DATE_ADD(first_login, INTERVAL 1 DAY) then 1
            else 0
        end
    ) / (select count(distinct(player_id))
         from activity), 2) as fraction
from activity a
join temp
on a.player_id = temp.player_id;