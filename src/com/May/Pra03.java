package com.Lantz2024.May;

import java.util.Arrays;

/**
 * <p>Project: Algorithm20230913 - Pra03
 * <p>Powered by Lantz On 2024-05-03 08:59:58
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra03
 * @since 1.8
 */
public class Pra03 {
}

/**
 * 1491. 去掉最低工资和最高工资后的工资平均值
 * 已解答
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 salary ，数组里每个数都是 唯一 的，其中 salary[i] 是第 i 个员工的工资。
 *
 * 请你返回去掉最低工资和最高工资以后，剩下员工工资的平均值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：salary = [4000,3000,1000,2000]
 * 输出：2500.00000
 * 解释：最低工资和最高工资分别是 1000 和 4000 。
 * 去掉最低工资和最高工资以后的平均工资是 (2000+3000)/2= 2500
 * 示例 2：
 *
 * 输入：salary = [1000,2000,3000]
 * 输出：2000.00000
 * 解释：最低工资和最高工资分别是 1000 和 3000 。
 * 去掉最低工资和最高工资以后的平均工资是 (2000)/1= 2000
 * 示例 3：
 *
 * 输入：salary = [6000,5000,4000,3000,2000,1000]
 * 输出：3500.00000
 * 示例 4：
 *
 * 输入：salary = [8000,9000,2000,3000,6000,1000]
 * 输出：4750.00000
 */

class Solution03 {
    public double average(int[] salary) {
        int n = salary.length;
        Arrays.sort(salary);
        double ans = 0;
        for(int i = 1; i < n-1; i++){
            ans += salary[i];
        }
        return ans / (n - 2);
    }
}