package com.jia.explore.binarysearch;
/**
 * 猜数字大小
 * 
 * 我们正在玩一个猜数字游戏。 游戏规则如下：
我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
每次你猜错了，我会告诉你这个数字是大了还是小了。
你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：

-1 : 我的数字比较小
 1 : 我的数字比较大
 0 : 恭喜！你猜对了！
示例 :

输入: n = 10, pick = 6
输出: 6

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/guess-number-higher-or-lower
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Administrator
 *
 */
public class Pro03 {
    public int guessNumber(int n) {
        int L = 1;
        int R = n;
        while(L<R){
        	int M = L + (R - L)/2;
        	if(guess(M) == 0)return M;
        	else if(guess(M) == -1) R  = M-1;
        	else L = M + 1;
        }
        return R;
    }
    private int guess(int n) {
    	return 1;
    }
}
