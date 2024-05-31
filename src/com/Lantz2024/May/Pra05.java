package com.Lantz2024.May;

/**
 * <p>Project: Algorithm20230913 - Pra05
 * <p>Powered by Lantz On 2024-05-05 08:55:28
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra05
 * @since 1.8
 */
public class Pra05 {
}

/**
 * 1652. 拆炸弹
 * 已解答
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 你有一个炸弹需要拆除，时间紧迫！你的情报员会给你一个长度为 n 的 循环 数组 code 以及一个密钥 k 。
 *
 * 为了获得正确的密码，你需要替换掉每一个数字。所有数字会 同时 被替换。
 *
 * 如果 k > 0 ，将第 i 个数字用 接下来 k 个数字之和替换。
 * 如果 k < 0 ，将第 i 个数字用 之前 k 个数字之和替换。
 * 如果 k == 0 ，将第 i 个数字用 0 替换。
 * 由于 code 是循环的， code[n-1] 下一个元素是 code[0] ，且 code[0] 前一个元素是 code[n-1] 。
 *
 * 给你 循环 数组 code 和整数密钥 k ，请你返回解密后的结果来拆除炸弹！
 *
 *
 *
 * 示例 1：
 *
 * 输入：code = [5,7,1,4], k = 3
 * 输出：[12,10,16,13]
 * 解释：每个数字都被接下来 3 个数字之和替换。解密后的密码为 [7+1+4, 1+4+5, 4+5+7, 5+7+1]。注意到数组是循环连接的。
 * 示例 2：
 *
 * 输入：code = [1,2,3,4], k = 0
 * 输出：[0,0,0,0]
 * 解释：当 k 为 0 时，所有数字都被 0 替换。
 * 示例 3：
 *
 * 输入：code = [2,4,9,3], k = -2
 * 输出：[12,5,6,13]
 * 解释：解密后的密码为 [3+9, 2+3, 4+2, 9+4] 。注意到数组是循环连接的。如果 k 是负数，那么和为 之前 的数字。
 */

class Solution05 {
    public int[] decrypt(int[] code, int k) {
        // 循环队列
        int n = code.length;
        int[] ans = new int[n];
        int r = k > 0 ? k + 1 : n;
        k = Math.abs(k);
        int s = 0;
        for(int i = r - k; i < r; i++){
            s += code[i]; // 计算 ans[0]
        }
        // 移入窗口的元素下标为 r mod n, 移出窗口的下标是(r - k) mod n
        for(int i = 0; i < n; i++){
            ans[i] = s;
            s += code[r % n] - code[(r - k) % n];
            r++;
        }
        return ans;
    }
}