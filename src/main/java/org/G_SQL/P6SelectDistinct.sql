/*
 Write a solution to find all the authors that viewed at least one of their own articles.

Return the result table sorted by id in ascending order.

 以下是一个更简短的总结：

使用DISTINCT： 这个关键字用于消除查询结果中的重复行。对于所选的列，每个唯一值在结果中只出现一次。

选择多个字段： 若你选择多个字段并使用DISTINCT，那么只有当所有选定字段的值全都相同时，行才会被视为重复并合并。

特定查询解析： 在查询select distinct author_id from Views where author_id = viewer_id中，首先选出author_id等于viewer_id的行，然后消除结果中author_id的重复值。
 */
select
    distinct author_id as id
from
    Views
where
    author_id = viewer_id
order by id;