SELECT 
    p.product_id,
    p.product_name,
    SUM(o.amount) * p.price AS total_sales
FROM food_product p
JOIN food_order o
ON p.product_id = o.product_id
WHERE o.produce_date BETWEEN DATE '2022-05-01' AND DATE '2022-05-31'
GROUP BY p.product_id, p.product_name, p.price
ORDER BY total_sales DESC, p.product_id ASC;