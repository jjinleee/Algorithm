with recursive child as (
    select id ,1 as gen
    from ecoli_data
    where parent_id is null
    union all
    select e.id, c.gen+1 as gen
    from ecoli_data e join child c on e.parent_id=c.id
)
select id
from child
where gen=3
order by id
