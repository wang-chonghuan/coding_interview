/*
 +-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| email       | varchar |
+-------------+---------+
 id is the primary key
 The emails will not contain uppercase letters and not null
 write a solution to report all the duplicate emails
 */

 SELECT Email FROM
                  (
                      SELECT Email, COUNT(Email) as num
                      FROM Person
                      GROUP BY Email
                  ) AS statistics
WHERE num > 1

/*
 AS关键字用于为列或者子查询的结果赋予一个别名。别名是临时的，并仅在查询的上下文中存在
 总之，在为表或子查询赋予别名时，AS关键字是可选的，但为了代码的清晰性和可读性，有时最好还是加上。

 是的，你可以这样理解。当你在SQL查询中使用子查询，特别是在FROM子句中使用的子查询（有时被称为内联视图或派生表），它的行为在逻辑上就像一个临时表。

这个"临时表"只在查询的上下文中存在，它不会实际存储在数据库中。

 子查询：

sql
Copy code
SELECT Email, COUNT(Email) as num
FROM Person
GROUP BY Email
FROM Person: 这告诉我们从Person表中选择数据。

GROUP BY Email: 这将结果集按电子邮件地址分组，因此每个电子邮件只出现一次。

COUNT(Email) as num: 对于每个唯一的电子邮件地址，这会计算它在表中出现的次数，并将该次数命名为num。

 外层查询：

sql
Copy code
SELECT Email FROM ( ... ) AS statistics
WHERE num > 1
FROM ( ... ) AS statistics: 这将子查询的结果作为一个临时的、名为statistics的表来使用。

WHERE num > 1: 这个条件过滤出那些num值（即电子邮件出现的次数）大于1的行，意味着我们只关心出现多于一次的电子邮件
 */