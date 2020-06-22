package com.jia.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 531. 孤独像素 I
 * 
 * 给定一幅黑白像素组成的图像, 计算黑色孤独像素的数量。

图像由一个由‘B’和‘W’组成二维字符数组表示, ‘B’和‘W’分别代表黑色像素和白色像素。

黑色孤独像素指的是在同一行和同一列不存在其他黑色像素的黑色像素。

示例:

输入: 
[['W', 'W', 'B'],
 ['W', 'B', 'W'],
 ['B', 'W', 'W']]

输出: 3
解析: 全部三个'B'都是黑色孤独像素。
 

注意:

输入二维数组行和列的范围是 [1,500]。

 * 
 * @author Administrator
 *
 */
public class Pro0531 {
    public int findLonelyPixel(char[][] picture) {
        //创建两个map，分别储存每行/每列有几个'B'
        Map<Integer,Integer> rowMap = new HashMap<>();
        Map<Integer,Integer> colMap = new HashMap<>();
        for(int i = 0;i < picture.length;i++){
            for(int j = 0;j < picture[0].length;j++){
                if(picture[i][j] == 'B'){
                    rowMap.put(i,rowMap.getOrDefault(i,0)+1);
                    colMap.put(j,colMap.getOrDefault(j,0)+1);
                }
            }
        }
        //再次遍历，如果当前元素为'B'且当前行和列只有1个
        int res = 0;
        for(int i = 0;i < picture.length;i++){
            for(int j = 0;j < picture[0].length;j++){
                if(picture[i][j] == 'B' && rowMap.get(i) == 1 && colMap.get(j) == 1){
                    res++;
                }
            }
        }
        return res;
    }
}
