-- 코드를 입력하세요
with recursive time as (
    select 0 as hour
    union all
    select hour+1 as hour
    from time
    where hour<23
)
SELECT t.hour, count(animal_id) as count
from animal_outs o right join time t on hour(o.datetime)=t.hour
group by hour
order by hour