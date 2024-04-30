package com.Lantz2024.April;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * <p>Project: Algorithm20230913 - Pra18
 * <p>Powered by Lantz On 2024-04-18 08:54:28
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra18
 * @since 1.8
 */
public class Pra18 {

}

/**
 * 2007. 从双倍数组中还原原数组
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 一个整数数组 original 可以转变成一个 双倍 数组 changed ，转变方式为将 original 中每个元素 值乘以 2 加入数组中，然后将所有元素 随机打乱 。
 *
 * 给你一个数组 changed ，如果 change 是 双倍 数组，那么请你返回 original数组，否则请返回空数组。original 的元素可以以 任意 顺序返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：changed = [1,3,4,2,6,8]
 * 输出：[1,3,4]
 * 解释：一个可能的 original 数组为 [1,3,4] :
 * - 将 1 乘以 2 ，得到 1 * 2 = 2 。
 * - 将 3 乘以 2 ，得到 3 * 2 = 6 。
 * - 将 4 乘以 2 ，得到 4 * 2 = 8 。
 * 其他可能的原数组方案为 [4,3,1] 或者 [3,1,4] 。
 * 示例 2：
 *
 * 输入：changed = [6,3,0,1]
 * 输出：[]
 * 解释：changed 不是一个双倍数组。
 * 示例 3：
 *
 * 输入：changed = [1]
 * 输出：[]
 * 解释：changed 不是一个双倍数组。
 *
 */

class Solution18 {
    public int[] findOriginalArray(int[] changed) {
        Arrays.sort(changed);
        int n = changed.length;
        int[] ans = new int[n / 2];
        int ansIdx = 0;
        Queue<Integer> q = new ArrayDeque<>();
        for(int x : changed){
            if(!q.isEmpty()){
                if(q.peek() < x){
                    return new int[0]; // 无法匹对
                }
                if(q.peek() == x){ // 匹对成功
                    q.poll(); // 清除标记
                    continue;
                }
            }
            if(ansIdx == ans.length){
                return new int[0];
            }
            ans[ansIdx++] = x;
            q.offer(x * 2); // 添加双倍标记
        }
        return ans;
    }
}
