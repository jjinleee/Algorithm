-- 코드를 입력하세요
select member_id, member_name, gender, date_format(date_of_birth, '%Y-%m-%d')
from member_profile
where gender='w' and date_of_birth like ('%-03-%') and tlno is not null
order by member_id 