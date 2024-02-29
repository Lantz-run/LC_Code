package com.Lantz2023.OctoberPra;

/**
 * LeetCode第四题：寻找两个正序数组的中位数
 * 使用的是第 k小的数算法
 *
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 *
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 *
 * 2023.10.10
 */
public class Pra04 {
    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        double results = solution4.findMedianSortedArrays(nums1, nums2);
        System.out.println(results);
//        System.out.println(Arrays.toString(nums1));
    }
}

class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // 索引从0开始，所以要+1；
        int left = (m+n) / 2; // 等于 (m+n+1) / 2 如果两个数组的和是奇数，那么left和right的值都一样
        int right = (m+n) / 2 + 1; // 等于 (m+n+2) / 2 如果两个数组的和是偶数，那么left和right的值相差1
        return (getKth(nums1, 0, m-1, nums2, 0, n-1, left) +
                getKth(nums1, 0, m-1, nums2, 0, n-1, right)) * 0.5;
    }


    private int getKth(int[] nums1, int starts1, int ends1, int[] nums2, int starts2, int ends2, int k ){
        // 需要得出两个数组的长度；根据索引计算所以还需要+1,
        // 不使用ends+1是因为排除前面小的数后的首位索引不一定是0，有可能是其他的正整数
        int len1 = ends1 - starts1 + 1;
        int len2 = ends2 - starts2 + 1;

        // 如果len1大于len2，就调换len1和len2的值
        if (len1 > len2) return getKth( nums2, starts2, ends2, nums1, starts1, ends1, k); // 用于测试只有一个数组有元素的情况
//        if (len1 < len2) return getKth( nums1, starts1, ends1, nums2, starts2, ends2, k); // Error
        if (len1 == 0) return nums2[starts2 + k - 1];

        if (k == 1) return Math.min(nums1[starts1], nums2[starts2]);

        int i = starts1 + Math.min(len1, k/2) - 1;
        int j = starts2 + Math.min(len2, k/2) - 1;

        // 谁小减去谁
        if (nums1[i] > nums2[j]){
            return getKth(nums1, starts1, ends1, nums2, j+1, ends2, k - (j - starts2 + 1));
        }else {
            return getKth(nums1, i+1, ends1, nums2, starts2, ends2, k - (i - starts1 + 1));
        }

    }
}

// 2023.10.25 复盘一次
class Solution4_1{
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        int m = nums1.length;
        int n = nums2.length;

        int left = (m+n+1) / 2;
        int right = (m+n+2) / 2;

        return (getKth(nums1, 0, m-1, nums2, 0, n-1, left)+
                getKth(nums1, 0, m-1, nums2, 0, n-1, right)) / 2.0;
    }

    private int getKth(int[] nums1, int starts1, int ends1, int[] nums2, int starts2, int ends2, int k){
        int len1 = ends1 - starts1 + 1;
        int len2 = ends2 - starts2 + 1;

        if (len1 > len2) return getKth(nums2, starts2, ends2, nums1, starts1, ends1, k);
        if (len1 == 0) return nums2[starts2 - k + 1];

        if (k == 1) return Math.min(nums1[starts1], nums2[starts2]);

        // 记录数组实时长度
        int i = starts1 + Math.min(len1, k/2) - 1;
        int j = starts2 + Math.min(len2, k/2) - 1;

        if (nums1[i] > nums2[j]){
            return getKth(nums1, starts1, ends1, nums2, j+1, ends2, k-(j-starts2+1));
        }else {
            return getKth(nums1, i+1, ends1, nums2, starts2, ends2, k-(i-starts1+1));
        }

    }
}
