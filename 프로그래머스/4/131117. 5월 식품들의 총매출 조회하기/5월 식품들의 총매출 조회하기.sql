-- 코드를 입력하세요
SELECT p.PRODUCT_ID, PRODUCT_NAME, price*sum(amount) as TOTAL_SALES
FROM food_product p join food_order o on p.product_id=o.product_id
where produce_date like '2022-05%'
group by p.product_id
order by total_sales desc, p.product_id