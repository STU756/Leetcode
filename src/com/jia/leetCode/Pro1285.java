package com.jia.leetCode;
/**
 * 
 * 1285. Find the Start and End Number of Continuous Ranges
 * 
 * 
 * able: Logs

+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| log_id        | int     |
+---------------+---------+
id is the primary key for this table.
Each row of this table contains the ID in a log Table.

Since some IDs have been removed from Logs. Write an SQL query to find the start and end number of continuous ranges in table Logs.

Order the result table by start_id.

The query result format is in the following example:

Logs table:
+------------+
| log_id     |
+------------+
| 1          |
| 2          |
| 3          |
| 7          |
| 8          |
| 10         |
+------------+

Result table:
+------------+--------------+
| start_id   | end_id       |
+------------+--------------+
| 1          | 3            |
| 7          | 8            |
| 10         | 10           |
+------------+--------------+
The result table should contain all ranges in table Logs.
From 1 to 3 is contained in the table.
From 4 to 6 is missing in the table
From 7 to 8 is contained in the table.
Number 9 is missing in the table.
Number 10 is contained in the table.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-the-start-and-end-number-of-continuous-ranges
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * @author Administrator
 *
 */
public class Pro1285 {
/**
 * 
 * select t1.log_id as start_id, min(t2.log_id) as end_id from
    (select log_id from logs where log_id - 1 not in (select log_id from logs)) t1,
    (select log_id from logs where log_id + 1 not in (select log_id from logs)) t2
where t2.log_id>=t1.log_id group by t1.log_id;
 */
}
