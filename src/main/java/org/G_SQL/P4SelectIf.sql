/*
 Write a solution to calculate the bonus of each employee. The bonus of an employee is 100% of their salary if the ID of the employee is an odd number and the employee's name does not start with the character 'M'. The bonus of an employee is 0 otherwise.

Return the result table ordered by employee_id.
 */
select
    employee_id,
    if(employee_id % 2 = 1 and name not regexp '^M', salary, 0) as bonus
from
    employees
order by
    employee_id