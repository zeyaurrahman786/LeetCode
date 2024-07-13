# Write your MySQL query statement below
SELECT s.user_id,
#round(avg(if(c.action = 'confirmed', 1,0)),2) AS confirmation_rate
ifnull(round(sum(c.action = 'confirmed')/count(*),2),0.00) AS confirmation_rate
FROM Signups s
LEFT JOIN Confirmations c 
ON s.user_id = c.user_id
GROUP BY s.user_id