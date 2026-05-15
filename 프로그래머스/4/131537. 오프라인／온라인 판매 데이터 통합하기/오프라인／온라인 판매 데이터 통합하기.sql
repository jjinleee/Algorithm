-- 코드를 입력하세요
SELECT to_char(sales_date,'yyyy-mm-dd') as sales_date , product_id, user_id, sales_amount
from online_sale 
where sales_date between date '2022-03-01' and date '2022-03-31'

union all

SELECT to_char(sales_date,'yyyy-mm-dd') as sales_date , product_id, null as user_id, sales_amount
from offline_sale 
where sales_date between date '2022-03-01' and date '2022-03-31'

order by sales_date, product_id, user_id