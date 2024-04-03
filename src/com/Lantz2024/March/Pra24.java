package com.Lantz2024.March;

import java.util.Arrays;

/**
 * <p>Project: Algorithm20230913 - Pra24
 * <p>Powered by Lantz On 2024-03-30 16:14:05
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra24
 * @since 1.8
 */
public class Pra24 {

}

/**
 * 2952. 需要添加的硬币的最小数量
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 coins，表示可用的硬币的面值，以及一个整数 target 。
 *
 * 如果存在某个 coins 的子序列总和为 x，那么整数 x 就是一个 可取得的金额 。
 *
 * 返回需要添加到数组中的 任意面值 硬币的 最小数量 ，使范围 [1, target] 内的每个整数都属于 可取得的金额 。
 *
 * 数组的 子序列 是通过删除原始数组的一些（可能不删除）元素而形成的新的 非空 数组，删除过程不会改变剩余元素的相对位置。
 *
 *
 *
 * 示例 1：
 *
 * 输入：coins = [1,4,10], target = 19
 * 输出：2
 * 解释：需要添加面值为 2 和 8 的硬币各一枚，得到硬币数组 [1,2,4,8,10] 。
 * 可以证明从 1 到 19 的所有整数都可由数组中的硬币组合得到，且需要添加到数组中的硬币数目最小为 2 。
 * 示例 2：
 *
 * 输入：coins = [1,4,10,5,7,19], target = 19
 * 输出：1
 * 解释：只需要添加一枚面值为 2 的硬币，得到硬币数组 [1,2,4,5,7,10,19] 。
 * 可以证明从 1 到 19 的所有整数都可由数组中的硬币组合得到，且需要添加到数组中的硬币数目最小为 1 。
 * 示例 3：
 *
 * 输入：coins = [1,1,1], target = 20
 * 输出：3
 * 解释：
 * 需要添加面值为 4 、8 和 16 的硬币各一枚，得到硬币数组 [1,1,1,4,8,16] 。
 * 可以证明从 1 到 20 的所有整数都可由数组中的硬币组合得到，且需要添加到数组中的硬币数目最小为 3 。
 */

class Solution24 {
    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        int ans = 0, i = 0, s = 1;
        while(s <= target){
            if(i < coins.length && coins[i] <= s){
                s += coins[i];
                i++;
            } else {
                s *= 2;
                ans++;
            }
        }
        return ans;
    }
}
