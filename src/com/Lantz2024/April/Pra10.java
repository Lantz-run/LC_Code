package com.Lantz2024.April;

/**
 * <p>Project: Algorithm20230913 - Pra10
 * <p>Powered by Lantz On 2024-04-10 11:53:02
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra10
 * @since 1.8
 */
public class Pra10 {

}

/**
 * 1702. 修改后的最大二进制字符串
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个二进制字符串 binary ，它仅有 0 或者 1 组成。你可以使用下面的操作任意次对它进行修改：
 *
 * 操作 1 ：如果二进制串包含子字符串 "00" ，你可以用 "10" 将其替换。
 * 比方说， "00010" -> "10010"
 * 操作 2 ：如果二进制串包含子字符串 "10" ，你可以用 "01" 将其替换。
 * 比方说， "00010" -> "00001"
 * 请你返回执行上述操作任意次以后能得到的 最大二进制字符串 。如果二进制字符串 x 对应的十进制数字大于二进制字符串 y 对应的十进制数字，
 * 那么我们称二进制字符串 x 大于二进制字符串 y 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：binary = "000110"
 * 输出："111011"
 * 解释：一个可行的转换为：
 * "000110" -> "000101"
 * "000101" -> "100101"
 * "100101" -> "110101"
 * "110101" -> "110011"
 * "110011" -> "111011"
 * 示例 2：
 *
 * 输入：binary = "01"
 * 输出："01"
 * 解释："01" 没办法进行任何转换
 */

class Solution10 {
    public String maximumBinaryString(String binary) {
        int i = binary.indexOf('0');
        if(i < 0) // 小于 0 就是指字符串里面没有 0，全是 1
            return binary;
        char[] s = binary.toCharArray();
        int cnt1 = 0;
        for(i++; i < s.length; i++){ // 第一个 i++ 放不放都可以
            cnt1 += s[i] - '0'; // 统计 binary[] 0 后面 1 的个数
        }
        return "1".repeat(s.length - 1 - cnt1) + "0" + "1".repeat(cnt1);
    }
}
