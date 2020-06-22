package com.jia.leetCode;
/**
 * 最大三角形面积
难度
简单

29


收藏

分享
切换为英文
关注
通过次数

4,196

提交次数

7,170

题目描述
评论 (57)
题解(11)
提交记录
给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。

示例:
输入: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
输出: 2
解释: 
这五个点如下图所示。组成的橙色三角形是最大的，面积为2。


注意:

3 <= points.length <= 50.
不存在重复的点。
 -50 <= points[i][j] <= 50.
结果误差值在 10^-6 以内都认为是正确答案
 * @author Administrator
 *
 */
public class Pro0812 {
	public double largestTriangleArea(int[][] points) {

        double a , b , c;
        double S = 0 , temp;
        for(int i = 0;i < points.length - 2;i++){
            for(int j = 0;j < points.length - 1;j++){
                for(int k = 0;k < points.length;k++){
                    a = Math.sqrt((points[i][0] - points[j][0])*((points[i][0] - points[j][0])) + (points[i][1] - points[j][1])*((points[i][1] - points[j][1])));
                    b = Math.sqrt((points[i][0] - points[k][0])*((points[i][0] - points[k][0])) + (points[i][1] - points[k][1])*((points[i][1] - points[k][1])));
                    c = Math.sqrt((points[j][0] - points[k][0])*((points[j][0] - points[k][0])) + (points[j][1] - points[k][1])*((points[j][1] - points[k][1])));
                    temp = getS(a,b,c);
                    if(S < temp){
                        S = temp;
                    }
                }
            }
        }
        return S;

    }

    //海伦公式
    public double getS(double a , double b , double c){
        double p = (a + b + c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }

    public double largestTriangleArea2(int[][] points) {
        double maxArea = 0;
        double x1 , y1, x2, y2, x3, y3;
        for(int i = 0;i < points.length;i++){
            x1 = points[i][0];
            y1 = points[i][1];
            for(int j = i+1;j < points.length;j++){
                x2 = points[j][0];
                y2 = points[j][1];
                for(int k = j+1;k < points.length;k++){
                    x3 = points[k][0];
                    y3 = points[k][1];
                    //计算三角形的面积，利用向量的向量积。三角形ABC，向量AB×向量AC = |AB|*|AC|sinθ，即三角形ABC面积为：S=|AB × AC|/2
                    maxArea = Math.max(maxArea , Math.abs(x1*y2+x2*y3+x3*y1-x2*y1-x3*y2-x1*y3)/2.0);
                }
            }
        }
        return maxArea;
    }

}
