package com.Lantz2024.April;

/**
 * <p>Project: Algorithm20230913 - Pra28
 * <p>Powered by Lantz On 2024-04-28 15:40:40
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra28
 * @since 1.8
 */
public class Pra28 {
}

/**
 * 1017. 负二进制转换
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数 n ，以二进制字符串的形式返回该整数的 负二进制（base -2）表示。
 *
 * 注意，除非字符串就是 "0"，否则返回的字符串中不能含有前导零。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出："110"
 * 解释：(-2)2 + (-2)1 = 2
 * 示例 2：
 *
 * 输入：n = 3
 * 输出："111"
 * 解释：(-2)2 + (-2)1 + (-2)0 = 3
 * 示例 3：
 *
 * 输入：n = 4
 * 输出："100"
 * 解释：(-2)2 = 4
 */

class Solution28 {
    public String baseNeg2(int n) {
        // 2 = 110  (-2)^2 = 4  -2 = 2  4 - 2 = 2
        // 19 = -9 * (-2) + 1
        // 19 / (-2) = -9...1   -9 / (-2) = 5...1, 5 / (-2) = -2...1, -2 / (-2) = 1...0, 1 / (-2)直接余数为 1
        // 每一次都要保证余数是1
        if(n == 0){
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        while(n != 0){
            // 偶数的情况
            if(n % -2 == 0){
                ans.append("0");
            } else { // 当前n为奇数时，最低位 f 为 1
                n -= 1; // 将最低位的 1 抹去，将 n 变为偶数
                ans.append("1"); // 这里就是把奇数情况的余数 1 加进去
            }
            n /= -2;
        }
        return ans.reverse().toString(); // 最后按照二进制写法，把进制数从低到高写成自左向右，这里直接反转就可
    }
}
