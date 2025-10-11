-- 코드를 입력하세요
SELECT r.REST_ID, REST_NAME, FOOD_TYPE, FAVORITES, ADDRESS, round(avg(r.review_score),2) as SCORE
from rest_info i join rest_review r on i.rest_id=r.rest_id
group by r.rest_id
having i.address like '서울%' 
order by score desc, i.favorites desc