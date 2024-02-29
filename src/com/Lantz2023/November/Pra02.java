package com.Lantz2023.November;

/**
 * 2023.11.03
 * LeetCode第十一题：盛最多水的容器
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 示例 2：
 *
 * 输入：height = [1,1]
 * 输出：1
 *
 *
 * 提示：
 *
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 */
public class Pra02 {
    public static void main(String[] args) {

        Solution02_1 solution02 = new Solution02_1();
        int[] height = {1,8,6,2,5,4,8,3,7};
        int result = solution02.maxArea(height);
        System.out.println(result);
    }
}

class Solution02 {
    public int maxArea(int[] height) {

        int i = 0, j = height.length - 1, res = 0;
        while (i<j){
            res = height[i] < height[j] ?
                    Math.max(res, (j-i) * height[i++]) :
                    Math.max(res, (j-i) * height[j--]);
        }

        return res;
    }
}

// 使用双指针
class Solution02_1{
    public int maxArea(int[] height){
        int i = 0, j = height.length-1, area = 0;
        while (i<j){
            // 矩形的面积公式
            area = height[i] < height[j] ?
            Math.max(area, (j-i)*height[i++]):
            Math.max(area, (j-i)*height[j--]);
        }

        return area;
    }
}