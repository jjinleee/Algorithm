-- 코드를 작성해주세요
select d.id, d.email, d.first_name, d.last_name
from developers d
join (
select sum(code) as mask
from skillcodes
where name in ('Python','C#')
) r
where  ( d.skill_code & r.mask) >0
order by d.id