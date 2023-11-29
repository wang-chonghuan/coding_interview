/*
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| date_id     | date    |
| make_name   | varchar |
| lead_id     | int     |
| partner_id  | int     |
+-------------+---------+
no primary key
For each date_id and make_name,
find the number of distinct lead_id's
and distinct partner_id's.
 */
 SELECT
     date_id,
     make_name,
     COUNT(DISTINCT lead_id) AS unique_leads,
     COUNT(DISTINCT partner_id) AS unique_partners
FROM
    DailySales
GROUP BY date_id, make_name;


