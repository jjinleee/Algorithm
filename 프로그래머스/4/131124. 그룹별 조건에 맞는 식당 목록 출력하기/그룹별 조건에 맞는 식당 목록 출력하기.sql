-- 코드를 입력하세요
SELECT member_name, review_text, to_char(review_date,'yyyy-mm-dd') as review_date
from member_profile m join rest_review r on m.member_id=r.member_id
where m.member_id = (
    select member_id
    from rest_review
    group by member_id
    order by count(*) desc 
    fetch first 1 rows only 
)
order by review_date, review_text