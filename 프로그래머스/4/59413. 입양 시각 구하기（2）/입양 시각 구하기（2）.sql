-- 코드를 입력하세요
with hours (hour) as(
    select 0 as hour
    from dual
    union all
    select hour+1
    from hours
    where hour<23
)
select h.hour, nvl(count(to_char(o.datetime, 'hh24')),0) as count
from hours h left join animal_outs o on h.hour=to_char(o.datetime,'hh24')
group by h.hour
order by hour