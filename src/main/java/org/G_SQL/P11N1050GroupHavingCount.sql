/*
able: ActorDirector

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| actor_id    | int     |
| director_id | int     |
| timestamp   | int     |
+-------------+---------+
timestamp is the primary key
Write a solution to find all the pairs (actor_id, director_id) where the actor has cooperated with the director at least three times.
 */

SELECT actor_id, director_id
FROM ActorDirector
GROUP BY actor_id, director_id
HAVING COUNT(timestamp) >= 3

/*

HAVING can replace WHERE in special cases, but it can never completely replace WHERE. This is because the data filtering mechanism of SQL for WHERE and HAVING is completely different. Always using HAVING may result in low performance.


我们告诉数据库将数据按照actor_id和director_id的组合进行分组。这意味着，如果一个演员与一个导演合作了多次，这些合作都会被归入一个单一的组。
 归入单一的一组,是单一的一行的意思吗


 不完全是。当我们说“归入单一的组”时，我们指的是这些数据行在逻辑上被视为一个分组，但它们在物理上仍然是多行数据。但是，当我们对这个组应用聚合函数（如`COUNT()`, `SUM()`, `AVG()`等）时，这个组会产生单一的输出行。

以前面的例子为例，考虑以下数据：

```
actor_id  |  director_id  |  timestamp
---------+---------------+-----------
   1     |       1       |     100
   1     |       1       |     101
   1     |       1       |     102
   1     |       2       |     103
   2     |       1       |     104
```

当我们按照`actor_id`和`director_id`进行分组，并计算每组的数量时：

```sql
SELECT actor_id, director_id, COUNT(timestamp)
FROM table_name
GROUP BY actor_id, director_id;
```

结果会是：

```
actor_id  |  director_id  |  COUNT(timestamp)
---------+---------------+-------------------
   1     |       1       |       3
   1     |       2       |       1
   2     |       1       |       1
```

如您所见，尽管演员1和导演1有三行数据，但在分组后的结果中，它们被聚合成一个单一的输出行，其中`COUNT(timestamp)`的值为3。

所以，当我们说“归入一个组”，我们指的是逻辑分组。但在输出结果中，这个组会被聚合成一个单一的行。
 */