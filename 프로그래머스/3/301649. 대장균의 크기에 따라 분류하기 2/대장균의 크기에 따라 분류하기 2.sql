-- 코드를 작성해주세요
with ranked as(
select id, size_of_colony, percent_rank() over (order by size_of_colony desc) as pct
from ecoli_data
)
select id, 
case when pct<=0.25 then 'CRITICAL'
     when pct<=0.50 then 'HIGH'
     when pct<=0.75 then 'MEDIUM'
     else 'LOW'
    end as colony_name
    from ranked
    order by id