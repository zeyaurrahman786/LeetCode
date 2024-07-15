# Write your MySQL query statement below
SELECT contest_id ,
round(count(DISTINCT user_id)*100 / (SELECT count(user_id) FROM users), 2) AS percentage
FROM Register
GROUP BY contest_id
ORDER BY percentage desc , contest_id asc 