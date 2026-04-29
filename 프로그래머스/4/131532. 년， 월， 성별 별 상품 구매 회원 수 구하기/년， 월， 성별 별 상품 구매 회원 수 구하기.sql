-- 코드를 입력하세요
SELECT year(sales_date) as year, month(sales_date) as month, gender, count(distinct i.user_id) as users
from user_info i join online_sale o on i.user_id=o.user_id
where gender is not null
group by year(sales_date), month(sales_date), gender
order by year, month, gender