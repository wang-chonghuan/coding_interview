/*
 +--------------+---------+
| Column Name  | Type    |
+--------------+---------+
| player_id    | int     |
| device_id    | int     |
| event_date   | date    |
| games_played | int     |
+--------------+---------+
(player_id, event_date) is the primary key
 write a solution to find the first login date for each player
 */

SELECT
    A.player_id,
    MIN(A.event_date) AS first_login
FROM
    Activity A
GROUP BY
    A.player_id