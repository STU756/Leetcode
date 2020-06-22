package com.jia.leetCode;
/**
 * 
 * 从 survey_log 表中获得回答率最高的问题，survey_log 表包含这些列：uid, action, question_id, answer_id, q_num, timestamp。

uid 表示用户 id；action 有以下几种值："show"，"answer"，"skip"；当 action 值为 "answer" 时 answer_id 非空，而 action 值为 "show" 或者 "skip" 时 answer_id 为空；q_num 表示当前会话中问题的编号。

请编写SQL查询来找到具有最高回答率的问题。

示例:

输入:
+------+-----------+--------------+------------+-----------+------------+
| uid  | action    | question_id  | answer_id  | q_num     | timestamp  |
+------+-----------+--------------+------------+-----------+------------+
| 5    | show      | 285          | null       | 1         | 123        |
| 5    | answer    | 285          | 124124     | 1         | 124        |
| 5    | show      | 369          | null       | 2         | 125        |
| 5    | skip      | 369          | null       | 2         | 126        |
+------+-----------+--------------+------------+-----------+------------+
输出:
+-------------+
| survey_log  |
+-------------+
|    285      |
+-------------+
解释:
问题285的回答率为 1/1，而问题369回答率为 0/1，因此输出285。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/get-highest-answer-rate-question
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Administrator
 *
 */
public class Pro0578 {
/**
 * select question_id as 'survey_log' from survey_log GROUP by question_id
ORDER by COUNT(answer_id)/COUNT(IF(action='show',1,0)) DESC LIMIT 1
 */
}
