/*
 +-------------+------+
| Column Name | Type |
+-------------+------+
| user_id     | int  |
| follower_id | int  |
+-------------+------+
(user_id, follower_id) is the primary key
Write a solution that will, for each user, return the number of followers
 */
SELECT user_id, COUNT(follower_id) as followers_count
FROM Followers GROUP BY user_id
ORDER BY user_id;

/*
 GROUP BY：
这是SQL语言中的一个命令，用于将结果集按照一个或多个列进行分组。

sql
Copy code
GROUP BY user_id
这表示我们想按user_id这一列来分组结果集。当与COUNT()函数结合使用时，它会为每个唯一的user_id计算其对应的follower_id的数量。
 */