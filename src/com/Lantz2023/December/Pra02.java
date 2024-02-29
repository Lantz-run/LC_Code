package com.Lantz2023.December;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Project: Algorithm20230913 - Pra02
 * <p>Powered by Lantz On 2023-12-21 22:51:00
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra02
 * @since 1.8
 *
 * LeetCode18. 四数之和
 *
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
 * 请你找出并返回满足下述全部条件且不重复的四元组
 * [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 *
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 *
 * 示例 2：
 *
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 *
 */
public class Pra02 {
    public static void main(String[] args) {
        Solution02 solution02 = new Solution02();
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        List<List<Integer>> result = solution02.fourSum(nums,target);
        System.out.println(result);
    }
}

class Solution02 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < len - 3; i++) {
            long x = nums[i];
            if (i > 0 && x == nums[i - 1]) continue; // 因为nums[j]是在左边的，如果nums[j]都大于0，那后面肯定都大于0，结果也就大于0了,i<0就溢出了
            if (x + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break; // 最左边的加起来都大于0，那遍历到右边也是大于0的，毕竟数组已经排序好了
            if (x + nums[len - 1] + nums[len - 2] + nums[len - 3] < target)
                continue; // 小于target还有希望，在外层循环往右的时候有可能达到target
            for (int j = i + 1; j < len - 2; j++) {
                long y = nums[j];
                if (j > i + 1 && y == nums[j - 1]) continue;
                if (y + x + nums[j + 1] + nums[j + 2] > target) break;
                if (y + x + nums[len - 1] + nums[len - 2] < target) continue;
                int k = j + 1, l = len - 1;
                while (k < l) {
                    long sum = x + y + nums[k] + nums[l];
                    if (sum < target) k++;
                    else if (sum > target) {
                        l--;
                    } else {
                        //                        res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], nums[l])));
                        //                        while (k<l && nums[k] == nums[++k]);
                        //                        while (k<l && nums[l] == nums[--l]);
                        res.add(List.of((int) x, (int) y, nums[k], nums[l]));
                        // 跳过重复数字
                        for (k++; k < l && nums[k] == nums[k - 1]; k++) ;
                        for (l--; l > k && nums[l] == nums[l + 1]; l--) ;

                    }
                }
            }

        }
        return res;
    }
}


//        for (int i = 0; i < len-2; i++) {
//            int l = len-1, k = len-2;
//            for (int j = 0; j < len-3; j++) {
//                long sum = nums[i]+nums[j]+nums[k]+nums[l];
//                if (nums[j] > 0) break; // 因为nums[j]是在左边的，如果nums[j]都大于0，那后面肯定都大于0，结果也就大于0了
////                if (sum > target) break; // sum都已经大于0了，那么接下来遍历的肯定也是大于0
//                if (sum < target && sum > target) continue; // 小于0的还有得看
//                if (sum == target){
//                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], nums[l])));
//                }
//                while (j < K)
//
//            }
//        }

