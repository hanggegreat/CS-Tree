- [175.组合两个表](#175组合两个表)
- [176.第二高的薪水](#176第二高的薪水)
- [177.第N高的薪水](#177第N高的薪水)
- [178.分数排名](#178分数排名)
- [180.连续出现的数字](#180连续出现的数字)
- [181.超过经理收入的员工](#181超过经理收入的员工)
- [182.查找重复的电子邮箱](#182查找重复的电子邮箱)
- [183.从不订购的客户](#183从不订购的客户)
- [184.部门工资最高的员工](#184部门工资最高的员工)
- [185.部门工资前三高的员工](#185部门工资前三高的员工)
- [196.删除重复的电子邮箱](#196删除重复的电子邮箱)
- [197.上升的温度](#197上升的温度)
- [262.行程和用户](#262行程和用户)
- [595.大的国家](#595大的国家)
- [596.超过5名学生的课](#596超过5名学生的课)
- [601.体育馆的人流量](#601体育馆的人流量)
- [620.有趣的电影](#620有趣的电影)
- [626.换座位](#626换座位)
- [627.交换工资](#627交换工资)



## 175.组合两个表

<https://leetcode-cn.com/problems/combine-two-tables/>

SQL架构

表1: `Person`

```html
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

```html
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

 

```html
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

```html
+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
```

例如上述 `Employee` 表，*n = 2* 时，应返回第二高的薪水 `200`。如果不存在第 *n* 高的薪水，那么查询应返回 `null`。

```html
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

```html
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

```html
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

```html
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

```html
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

```html
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

```html
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

```html
+----+---------+
| Id | Email   |
+----+---------+
| 1  | a@b.com |
| 2  | c@d.com |
| 3  | a@b.com |
+----+---------+
```

根据以上输入，你的查询应返回以下结果：

```html
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

```html
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

```html
+----+------------+
| Id | CustomerId |
+----+------------+
| 1  | 3          |
| 2  | 1          |
+----+------------+
```

例如给定上述表格，你的查询应返回：

```html
+-----------+
| Customers |
+-----------+
| Henry     |
| Max       |
+-----------+
```

#### Solution:

```sql
SELECT c.Name AS Customers
FROM Customers c
	LEFT JOIN Orders o ON c.Id = o.CustomerId
WHERE o.CustomerId IS NULL;
```



## 184.部门工资最高的员工

<https://leetcode-cn.com/problems/department-highest-salary/>

`Employee` 表包含所有员工信息，每个员工有其对应的 Id, salary 和 department Id。

```html
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

```html
+----+----------+
| Id | Name     |
+----+----------+
| 1  | IT       |
| 2  | Sales    |
+----+----------+
```

编写一个 SQL 查询，找出每个部门工资最高的员工。例如，根据上述给定的表格，Max 在 IT 部门有最高工资，Henry 在 Sales 部门有最高工资。

```html
+------------+----------+--------+
| Department | Employee | Salary |
+------------+----------+--------+
| IT         | Max      | 90000  |
| Sales      | Henry    | 80000  |
+------------+----------+--------+
```

#### Solution:

```sql
SELECT d.Name AS Department, e.Name AS Employee, temp.Salary
FROM (
	SELECT DepartmentId, MAX(Salary) AS Salary
	FROM Employee
	GROUP BY DepartmentId
) temp, Department d, Employee e
WHERE temp.DepartmentId = d.Id
	AND e.Salary = temp.Salary
	AND e.DepartmentId = d.Id;
```



## 185.部门工资前三高的员工

<https://leetcode-cn.com/problems/department-top-three-salaries/>

`Employee` 表包含所有员工信息，每个员工有其对应的 Id, salary 和 department Id 。

```html
+----+-------+--------+--------------+
| Id | Name  | Salary | DepartmentId |
+----+-------+--------+--------------+
| 1  | Joe   | 70000  | 1            |
| 2  | Henry | 80000  | 2            |
| 3  | Sam   | 60000  | 2            |
| 4  | Max   | 90000  | 1            |
| 5  | Janet | 69000  | 1            |
| 6  | Randy | 85000  | 1            |
+----+-------+--------+--------------+


```

`Department` 表包含公司所有部门的信息。

```html
+----+----------+
| Id | Name     |
+----+----------+
| 1  | IT       |
| 2  | Sales    |
+----+----------+


```

编写一个 SQL 查询，找出每个部门工资前三高的员工。例如，根据上述给定的表格，查询结果应返回： 

```html
+------------+----------+--------+
| Department | Employee | Salary |
+------------+----------+--------+
| IT         | Max      | 90000  |
| IT         | Randy    | 85000  |
| IT         | Joe      | 70000  |
| Sales      | Henry    | 80000  |
| Sales      | Sam      | 60000  |
+------------+----------+--------+

```

```sql
SELECT d.Name Department, e1.Name Employee, Salary
FROM Department d
	JOIN Employee e1 ON d.Id = e1.DepartmentId
WHERE(
    SELECT COUNT(DISTINCT Salary)
    FROM Employee e2
    WHERE e2.DepartmentId = e1.DepartmentId
    AND e2.Salary >= e1.Salary
) <= 3
ORDER BY DepartmentId, Salary DESC;
```



## 196.删除重复的电子邮箱

<https://leetcode-cn.com/problems/delete-duplicate-emails/>

编写一个 SQL 查询， 来删除 `Person` 表中所有重复的电子邮箱，重复的邮箱里只保留 **Id** *最小* 的那个。

```html
+----+------------------+
| Id | Email            |
+----+------------------+
| 1  | john@example.com |
| 2  | bob@example.com  |
| 3  | john@example.com |
+----+------------------+
Id 是这个表的主键。

```

例如，在运行你的查询语句之后，上面的 `Person` 表应返回以下几行:

```html
+----+------------------+
| Id | Email            |
+----+------------------+
| 1  | john@example.com |
| 2  | bob@example.com  |
+----+------------------+

```

#### Solution:

```sql
DELETE FROM Person
WHERE Id NOT IN (
    SELECT Id
    FROM (
        SELECT MIN(Id) AS Id
        FROM Person
        GROUP BY email
    ) temp
);
```



## 197.上升的温度

<https://leetcode-cn.com/problems/rising-temperature/>

给定一个 `Weather` 表，编写一个 SQL 查询，来查找与之前（昨天的）日期相比温度更高的所有日期的 Id。

```html
+---------+------------------+------------------+
| Id(INT) | RecordDate(DATE) | Temperature(INT) |
+---------+------------------+------------------+
|       1 |       2015-01-01 |               10 |
|       2 |       2015-01-02 |               25 |
|       3 |       2015-01-03 |               20 |
|       4 |       2015-01-04 |               30 |
+---------+------------------+------------------+


```

例如，根据上述给定的 `Weather` 表格，返回如下 Id:

```html
+----+
| Id |
+----+
|  2 |
|  4 |
+----+

```

```sql
SELECT w2.Id
FROM Weather w1
	JOIN Weather w2
	ON w1.RecordDate = date_sub(w2.RecordDate, INTERVAL 1 DAY)
		AND w1.Temperature < w2.Temperature;
```



## 262.行程和用户

<https://leetcode-cn.com/problems/trips-and-users/>

`Trips` 表中存所有出租车的行程信息。每段行程有唯一键 Id，Client_Id 和 Driver_Id 是 `Users` 表中 Users_Id 的外键。Status 是枚举类型，枚举成员为 (‘completed’, ‘cancelled_by_driver’, ‘cancelled_by_client’)。

```html
+----+-----------+-----------+---------+--------------------+----------+
| Id | Client_Id | Driver_Id | City_Id |        Status      |Request_at|
+----+-----------+-----------+---------+--------------------+----------+
| 1  |     1     |    10     |    1    |     completed      |2013-10-01|
| 2  |     2     |    11     |    1    | cancelled_by_driver|2013-10-01|
| 3  |     3     |    12     |    6    |     completed      |2013-10-01|
| 4  |     4     |    13     |    6    | cancelled_by_client|2013-10-01|
| 5  |     1     |    10     |    1    |     completed      |2013-10-02|
| 6  |     2     |    11     |    6    |     completed      |2013-10-02|
| 7  |     3     |    12     |    6    |     completed      |2013-10-02|
| 8  |     2     |    12     |    12   |     completed      |2013-10-03|
| 9  |     3     |    10     |    12   |     completed      |2013-10-03| 
| 10 |     4     |    13     |    12   | cancelled_by_driver|2013-10-03|
+----+-----------+-----------+---------+--------------------+----------+


```

`Users` 表存所有用户。每个用户有唯一键 Users_Id。Banned 表示这个用户是否被禁止，Role 则是一个表示（‘client’, ‘driver’, ‘partner’）的枚举类型。

```html
+----------+--------+--------+
| Users_Id | Banned |  Role  |
+----------+--------+--------+
|    1     |   No   | client |
|    2     |   Yes  | client |
|    3     |   No   | client |
|    4     |   No   | client |
|    10    |   No   | driver |
|    11    |   No   | driver |
|    12    |   No   | driver |
|    13    |   No   | driver |
+----------+--------+--------+


```

写一段 SQL 语句查出 **2013年10月1日** 至 **2013年10月3日** 期间非禁止用户的取消率。基于上表，你的 SQL 语句应返回如下结果，取消率（Cancellation Rate）保留两位小数。

```html
+------------+-------------------+
|     Day    | Cancellation Rate |
+------------+-------------------+
| 2013-10-01 |       0.33        |
| 2013-10-02 |       0.00        |
| 2013-10-03 |       0.50        |
+------------+-------------------+

```

```sql
SELECT Request_at AS Day
	, ROUND(SUM(t.Status != 'completed') / COUNT(Status), 2) AS 'Cancellation Rate'
FROM Trips t
	JOIN Users u ON t.Client_Id = u.Users_Id
WHERE u.Banned = 'No'
	AND t.Request_at BETWEEN '2013-10-01' AND '2013-10-03'
GROUP BY t.Request_at;
```



## 595.大的国家

<https://leetcode-cn.com/problems/big-countries/>

这里有张 `World` 表

```html
+-----------------+------------+------------+--------------+---------------+
| name            | continent  | area       | population   | gdp           |
+-----------------+------------+------------+--------------+---------------+
| Afghanistan     | Asia       | 652230     | 25500100     | 20343000      |
| Albania         | Europe     | 28748      | 2831741      | 12960000      |
| Algeria         | Africa     | 2381741    | 37100000     | 188681000     |
| Andorra         | Europe     | 468        | 78115        | 3712000       |
| Angola          | Africa     | 1246700    | 20609294     | 100990000     |
+-----------------+------------+------------+--------------+---------------+


```

如果一个国家的面积超过300万平方公里，或者人口超过2500万，那么这个国家就是大国家。

编写一个SQL查询，输出表中所有大国家的名称、人口和面积。

例如，根据上表，我们应该输出:

```html
+--------------+-------------+--------------+
| name         | population  | area         |
+--------------+-------------+--------------+
| Afghanistan  | 25500100    | 652230       |
| Algeria      | 37100000    | 2381741      |
+--------------+-------------+--------------+

```

```sql
SELECT name, population, area
FROM World w
WHERE area > 3000000
	OR population > 25000000;
```



## 596.超过5名学生的课

<https://leetcode-cn.com/problems/classes-more-than-5-students/>

有一个`courses` 表 ，有: **student (学生)** 和 **class (课程)**。

请列出所有超过或等于5名学生的课。

例如,表:

```html
+---------+------------+
| student | class      |
+---------+------------+
| A       | Math       |
| B       | English    |
| C       | Math       |
| D       | Biology    |
| E       | Math       |
| F       | Computer   |
| G       | Math       |
| H       | Math       |
| I       | Math       |
+---------+------------+


```

应该输出:

```html
+---------+
| class   |
+---------+
| Math    |
+---------+


```

**Note:**
学生在每个课中不应被重复计算。

#### Solution:

```sql
SELECT class
FROM courses
GROUP BY class
HAVING COUNT(DISTINCT student) >= 5;
```



## 601.体育馆的人流量

<https://leetcode-cn.com/problems/human-traffic-of-stadium>

X 市建了一个新的体育馆，每日人流量信息被记录在这三列信息中：**序号** (id)、**日期** (date)、 **人流量** (people)。

请编写一个查询语句，找出高峰期时段，要求连续三天及以上，并且每天人流量均不少于100。

例如，表 `stadium`：

```html
+------+------------+-----------+
| id   | date       | people    |
+------+------------+-----------+
| 1    | 2017-01-01 | 10        |
| 2    | 2017-01-02 | 109       |
| 3    | 2017-01-03 | 150       |
| 4    | 2017-01-04 | 99        |
| 5    | 2017-01-05 | 145       |
| 6    | 2017-01-06 | 1455      |
| 7    | 2017-01-07 | 199       |
| 8    | 2017-01-08 | 188       |
+------+------------+-----------+


```

对于上面的示例数据，输出为：

```html
+------+------------+-----------+
| id   | date       | people    |
+------+------------+-----------+
| 5    | 2017-01-05 | 145       |
| 6    | 2017-01-06 | 1455      |
| 7    | 2017-01-07 | 199       |
| 8    | 2017-01-08 | 188       |
+------+------------+-----------+


```

**Note:**
每天只有一行记录，日期随着 id 的增加而增加。

#### Solution:

```sql
SELECT DISTINCT s4.*
FROM stadium s1, stadium s2, stadium s3, stadium s4
WHERE s1.id = s2.id - 1
	AND s2.id = s3.id - 1
	AND s1.people >= 100
	AND s2.people >= 100
	AND s3.people >= 100
	AND s4.id IN (s1.id, s2.id, s3.id);
```



## 620.有趣的电影

<https://leetcode-cn.com/problems/not-boring-movies/>

某城市开了一家新的电影院，吸引了很多人过来看电影。该电影院特别注意用户体验，专门有个 LED显示板做电影推荐，上面公布着影评和相关电影描述。

作为该电影院的信息部主管，您需要编写一个 SQL查询，找出所有影片描述为**非** `boring` (不无聊) 的并且 **id 为奇数** 的影片，结果请按等级 `rating` 排列。

 

例如，下表 `cinema`:

```html
+---------+-----------+--------------+-----------+
|   id    | movie     |  description |  rating   |
+---------+-----------+--------------+-----------+
|   1     | War       |   great 3D   |   8.9     |
|   2     | Science   |   fiction    |   8.5     |
|   3     | irish     |   boring     |   6.2     |
|   4     | Ice song  |   Fantacy    |   8.6     |
|   5     | House card|   Interesting|   9.1     |
+---------+-----------+--------------+-----------+


```

对于上面的例子，则正确的输出是为：

```html
+---------+-----------+--------------+-----------+
|   id    | movie     |  description |  rating   |
+---------+-----------+--------------+-----------+
|   5     | House card|   Interesting|   9.1     |
|   1     | War       |   great 3D   |   8.9     |
+---------+-----------+--------------+-----------+

```

#### Solution:

```sql
SELECT id, movie, description, rating
FROM cinema
WHERE description != 'boring'
	AND id & 1 = 1
ORDER BY rating DESC;
```



## 626.换座位

<https://leetcode-cn.com/problems/exchange-seats/>

小美是一所中学的信息科技老师，她有一张 `seat` 座位表，平时用来储存学生名字和与他们相对应的座位 id。

其中纵列的 **id** 是连续递增的

小美想改变相邻俩学生的座位。

你能不能帮她写一个 SQL query 来输出小美想要的结果呢？

 

**示例：**

```html
+---------+---------+
|    id   | student |
+---------+---------+
|    1    | Abbot   |
|    2    | Doris   |
|    3    | Emerson |
|    4    | Green   |
|    5    | Jeames  |
+---------+---------+


```

假如数据输入的是上表，则输出结果如下：

```html
+---------+---------+
|    id   | student |
+---------+---------+
|    1    | Doris   |
|    2    | Abbot   |
|    3    | Green   |
|    4    | Emerson |
|    5    | Jeames  |
+---------+---------+


```

**注意：**

如果学生人数是奇数，则不需要改变最后一个同学的座位。

#### Solution:

```sql
SELECT s2.id - 1 AS id, s2.student
FROM seat s2
WHERE s2.id & 1 = 0
UNION
SELECT s1.id + 1 AS id, s1.student
FROM seat s1
WHERE s1.id & 1 = 1
	AND s1.id != (
		SELECT MAX(s3.id)
		FROM seat s3
	)
UNION
SELECT *
FROM seat s4
WHERE s4.id & 1 = 1
	AND s4.id = (
		SELECT MAX(s5.id)
		FROM seat s5
	)
ORDER BY id;
```



## 627. 交换工资

<https://leetcode-cn.com/problems/swap-salary/>

给定一个 `salary`表，如下所示，有m=男性 和 f=女性的值 。交换所有的 f 和 m 值(例如，将所有 f 值更改为 m，反之亦然)。要求使用一个更新查询，并且没有中间临时表。

例如:

```html
| id | name | sex | salary |
|----|------|-----|--------|
| 1  | A    | m   | 2500   |
| 2  | B    | f   | 1500   |
| 3  | C    | m   | 5500   |
| 4  | D    | f   | 500    |


```

运行你所编写的查询语句之后，将会得到以下表:

```html
| id | name | sex | salary |
|----|------|-----|--------|
| 1  | A    | f   | 2500   |
| 2  | B    | m   | 1500   |
| 3  | C    | f   | 5500   |
| 4  | D    | m   | 500    |

```

#### Solution:

```sql
UPDATE salary
SET sex = IF('m', 'f', 'm');
```