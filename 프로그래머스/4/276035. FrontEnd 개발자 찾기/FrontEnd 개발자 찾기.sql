-- 코드를 작성해주세요
-- 코드를 작성해주세요
select distinct id, email, first_name, last_name
from developers d join skillcodes s 
on d.skill_code & code =code
where category='Front End'
order by id