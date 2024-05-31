package com.Lantz2024.May;

import java.util.*;

/**
 * <p>Project: Algorithm20230913 - Pra22
 * <p>Powered by Lantz On 2024-05-22 14:56:42
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra22
 * @since 1.8
 */
public class Pra22 {
}

/**
 * 2225. 找出输掉零场或一场比赛的玩家
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 matches 其中 matches[i] = [winneri, loseri] 表示在一场比赛中 winneri 击败了 loseri 。
 *
 * 返回一个长度为 2 的列表 answer ：
 *
 * answer[0] 是所有 没有 输掉任何比赛的玩家列表。
 * answer[1] 是所有恰好输掉 一场 比赛的玩家列表。
 * 两个列表中的值都应该按 递增 顺序返回。
 *
 * 注意：
 *
 * 只考虑那些参与 至少一场 比赛的玩家。
 * 生成的测试用例保证 不存在 两场比赛结果 相同 。
 *
 *
 * 示例 1：
 *
 * 输入：matches = [[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]
 * 输出：[[1,2,10],[4,5,7,8]]
 * 解释：
 * 玩家 1、2 和 10 都没有输掉任何比赛。
 * 玩家 4、5、7 和 8 每个都输掉一场比赛。
 * 玩家 3、6 和 9 每个都输掉两场比赛。
 * 因此，answer[0] = [1,2,10] 和 answer[1] = [4,5,7,8] 。
 * 示例 2：
 *
 * 输入：matches = [[2,3],[1,3],[5,4],[6,4]]
 * 输出：[[1,2,5,6],[]]
 * 解释：
 * 玩家 1、2、5 和 6 都没有输掉任何比赛。
 * 玩家 3 和 4 每个都输掉两场比赛。
 * 因此，answer[0] = [1,2,5,6] 和 answer[1] = [] 。
 */

class Solution22 {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> lossCount = new HashMap<>();
        for(int[] m : matches){
            if(!lossCount.containsKey(m[0])){
                lossCount.put(m[0], 0);
            }
            lossCount.merge(m[1], 1, Integer::sum);
        }

        List<List<Integer>> ans = List.of(new ArrayList<>(), new ArrayList<>());
        for(Map.Entry<Integer, Integer> e : lossCount.entrySet()){
            int cnt = e.getValue();
            if(cnt < 2){
                ans.get(cnt).add(e.getKey());
            }
        }
        Collections.sort(ans.get(0));
        Collections.sort(ans.get(1));
        return ans;
    }
}