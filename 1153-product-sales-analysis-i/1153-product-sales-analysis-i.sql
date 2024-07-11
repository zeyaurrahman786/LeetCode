# Write your MySQL query statement below
SELECT product_name, s.year, s.price
FROM sales s 
LEFT JOIN product p
ON p.product_id = s.product_id