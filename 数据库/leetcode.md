- [175.组合两个表](#175.组合两个表)
- [176.第二高的薪水](#176.第二高的薪水)
- [177.第N高的薪水](#177.第N高的薪水)
- [178.分数排名](#178.分数排名)
- [180.连续出现的数字](#180.连续出现的数字)
- [181.超过经理收入的员工](#181.超过经理收入的员工)
- [182.查找重复的电子邮箱](#182.查找重复的电子邮箱)
- [183.从不订购的客户](#183.从不订购的客户)
- [184.部门工资最高的员工](#184.部门工资最高的员工)
- [185.部门工资前三高的员工](#185.部门工资前三高的员工)
- [196.删除重复的电子邮箱](#196.删除重复的电子邮箱)
- [197.上升的温度](#197.上升的温度)
- [262.行程和用户](#262.行程和用户)
- [595.大的国家](#595.大的国家)
- [596.超过5名学生的课](#596.超过5名学生的课)
- [601.体育馆的人流量](#601.体育馆的人流量)
- [620.有趣的电影](#620.有趣的电影)
- [626.换座位](#626.换座位)
- [627.交换工资](#627.交换工资)



## 175.组合两个表

<https://leetcode-cn.com/problems/combine-two-tables/>

SQL架构

表1: `Person`

```
+-------------+---------+
| 列名         | 类型     |
+-------------+---------+
| PersonId    | int     |
| FirstName   | varchar |
| LastName    | varchar |
+-------------+---------+
PersonId 是上表主键
```

表2: `Address`

```
+-------------+---------+
| 列名         | 类型    |
+-------------+---------+
| AddressId   | int     |
| PersonId    | int     |
| City        | varchar |
| State       | varchar |
+-------------+---------+
AddressId 是上表主键
```

 

编写一个 SQL 查询，满足条件：无论 person 是否有地址信息，都需要基于上述两表提供 person 的以下信息：

 

```
FirstName, LastName, City, State
```

#### Solution:

```sql
SELECT FirstName, LastName, City, State
FROM Person P
	LEFT JOIN Address A ON P.PersonId = A.PersonId;
```



## 176.第二高的薪水

<https://leetcode-cn.com/problems/second-highest-salary/>

编写一个 SQL 查询，获取 `Employee` 表中第二高的薪水（Salary） 。

```html
+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
```

例如上述 `Employee` 表，SQL查询应该返回 `200` 作为第二高的薪水。如果不存在第二高的薪水，那么查询应返回 `null`。

```html
+---------------------+
| SecondHighestSalary |
+---------------------+
| 200                 |
+---------------------+
```

#### Solution:

```sql
SELECT (
    SELECT DISTINCT Salary
    FROM Employee
    ORDER BY Salary DESC
    LIMIT 1, 1
) AS SecondHighestSalary;
```



## 177.第N高的薪水

<https://leetcode-cn.com/problems/nth-highest-salary/>

编写一个 SQL 查询，获取 `Employee` 表中第 *n* 高的薪水（Salary）。

```
+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
```

例如上述 `Employee` 表，*n = 2* 时，应返回第二高的薪水 `200`。如果不存在第 *n* 高的薪水，那么查询应返回 `null`。

```
+------------------------+
| getNthHighestSalary(2) |
+------------------------+
| 200                    |
+------------------------+
```

#### Solution:

```sql
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
	SET N = N - 1;
    RETURN (
        SELECT (
            SELECT DISTINCT Salary
            FROM Employee
            ORDER BY Salary DESC
            LIMIT N, 1
        )
    );
END
```



## 178.分数排名

<https://leetcode-cn.com/problems/rank-scores/>

编写一个 SQL 查询来实现分数排名。如果两个分数相同，则两个分数排名（Rank）相同。请注意，平分后的下一个名次应该是下一个连续的整数值。换句话说，名次之间不应该有“间隔”。

```
+----+-------+
| Id | Score |
+----+-------+
| 1  | 3.50  |
| 2  | 3.65  |
| 3  | 4.00  |
| 4  | 3.85  |
| 5  | 4.00  |
| 6  | 3.65  |
+----+-------+
```

例如，根据上述给定的 `Scores` 表，你的查询应该返回（按分数从高到低排列）：

```
+-------+------+
| Score | Rank |
+-------+------+
| 4.00  | 1    |
| 4.00  | 1    |
| 3.85  | 2    |
| 3.65  | 3    |
| 3.65  | 3    |
| 3.50  | 4    |
+-------+------+
```

#### Solution:

```sql
SELECT Score,
	(
		SELECT COUNT(DISTINCT Score)
		FROM Scores
		WHERE Score >= s.Score
	) AS Rank
FROM Scores s
ORDER BY s.Score DESC;
```



## 180.连续出现的数字

<https://leetcode-cn.com/problems/consecutive-numbers/>

编写一个 SQL 查询，查找所有至少连续出现三次的数字。

```
+----+-----+
| Id | Num |
+----+-----+
| 1  |  1  |
| 2  |  1  |
| 3  |  1  |
| 4  |  2  |
| 5  |  1  |
| 6  |  2  |
| 7  |  2  |
+----+-----+
```

例如，给定上面的 `Logs` 表， `1` 是唯一连续出现至少三次的数字。

```
+-----------------+
| ConsecutiveNums |
+-----------------+
| 1               |
+-----------------+
```

#### Solution:

```sql
SELECT DISTINCT l1.Num AS ConsecutiveNums
FROM Logs l1, Logs l2, Logs l3
WHERE l1.Id = l2.Id - 1
	AND l2.Id = l3.Id - 1
	AND l1.Num = l2.Num
	AND l2.Num = l3.Num;
```



## 181.超过经理收入的员工

<https://leetcode-cn.com/problems/employees-earning-more-than-their-managers/>

`Employee` 表包含所有员工，他们的经理也属于员工。每个员工都有一个 Id，此外还有一列对应员工的经理的 Id。

```
+----+-------+--------+-----------+
| Id | Name  | Salary | ManagerId |
+----+-------+--------+-----------+
| 1  | Joe   | 70000  | 3         |
| 2  | Henry | 80000  | 4         |
| 3  | Sam   | 60000  | NULL      |
| 4  | Max   | 90000  | NULL      |
+----+-------+--------+-----------+
```

给定 `Employee` 表，编写一个 SQL 查询，该查询可以获取收入超过他们经理的员工的姓名。在上面的表格中，Joe 是唯一一个收入超过他的经理的员工。

```
+----------+
| Employee |
+----------+
| Joe      |
+----------+
```

#### Solution:

```sql
SELECT e1.Name AS Employee
FROM Employee e1
	JOIN Employee e2
	ON e1.ManagerId = e2.Id
		AND e1.Salary > e2.Salary;
```



## 182.查找重复的电子邮箱

<https://leetcode-cn.com/problems/duplicate-emails/>

编写一个 SQL 查询，查找 `Person` 表中所有重复的电子邮箱。

**示例：**

```
+----+---------+
| Id | Email   |
+----+---------+
| 1  | a@b.com |
| 2  | c@d.com |
| 3  | a@b.com |
+----+---------+
```

根据以上输入，你的查询应返回以下结果：

```
+---------+
| Email   |
+---------+
| a@b.com |
+---------+
```

#### Solution:

```sql
SELECT Email
FROM Person
GROUP BY Email
HAVING COUNT(*) > 1;
```



## 183.从不订购的客户

<https://leetcode-cn.com/problems/customers-who-never-order/>

某网站包含两个表，`Customers` 表和 `Orders` 表。编写一个 SQL 查询，找出所有从不订购任何东西的客户。

`Customers` 表：

```
+----+-------+
| Id | Name  |
+----+-------+
| 1  | Joe   |
| 2  | Henry |
| 3  | Sam   |
| 4  | Max   |
+----+-------+
```

`Orders` 表：

```
+----+------------+
| Id | CustomerId |
+----+------------+
| 1  | 3          |
| 2  | 1          |
+----+------------+
```

例如给定上述表格，你的查询应返回：

```
+-----------+
| Customers |
+-----------+
| Henry     |
| Max       |
+-----------+
```

#### Solution:

``` sql
SELECT c.Name AS Customers
FROM Customers c
	LEFT JOIN Orders o ON c.Id = o.CustomerId
WHERE o.CustomerId IS NULL;
```



## 184.部门工资最高的员工

<https://leetcode-cn.com/problems/department-highest-salary/>

`Employee` 表包含所有员工信息，每个员工有其对应的 Id, salary 和 department Id。

```
+----+-------+--------+--------------+
| Id | Name  | Salary | DepartmentId |
+----+-------+--------+--------------+
| 1  | Joe   | 70000  | 1            |
| 2  | Henry | 80000  | 2            |
| 3  | Sam   | 60000  | 2            |
| 4  | Max   | 90000  | 1            |
+----+-------+--------+--------------+
```

`Department` 表包含公司所有部门的信息。

```
+----+----------+
| Id | Name     |
+----+----------+
| 1  | IT       |
| 2  | Sales    |
+----+----------+
```

编写一个 SQL 查询，找出每个部门工资最高的员工。例如，根据上述给定的表格，Max 在 IT 部门有最高工资，Henry 在 Sales 部门有最高工资。

```
+------------+----------+--------+
| Department | Employee | Salary |
+------------+----------+--------+
| IT         | Max      | 90000  |
| Sales      | Henry    | 80000  |
+------------+----------+--------+
```