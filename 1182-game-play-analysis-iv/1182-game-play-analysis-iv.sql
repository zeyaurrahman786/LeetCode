# Write your MySQL query statement below
SELECT 
round(sum(player_login)/count(DISTINCT player_id),2) AS fraction
FROM
(SELECT player_id ,
datediff(event_date, min(event_date) OVER(PARTITION BY player_id))=1 AS player_login
FROM activity) AS new_table