package com.Lantz2023.OctoberPra;

/**
 * LeetCode�����⣺Ѱ�����������������λ��
 * ʹ�õ��ǵ� kС�����㷨
 *
 * ����������С�ֱ�Ϊ m �� n �����򣨴�С�������� nums1 �� nums2�������ҳ���������������������� ��λ�� ��
 *
 * �㷨��ʱ�临�Ӷ�Ӧ��Ϊ O(log (m+n)) ��
 *
 * ʾ�� 1��
 * ���룺nums1 = [1,3], nums2 = [2]
 * �����2.00000
 * ���ͣ��ϲ����� = [1,2,3] ����λ�� 2
 *
 * ʾ�� 2��
 * ���룺nums1 = [1,2], nums2 = [3,4]
 * �����2.50000
 * ���ͣ��ϲ����� = [1,2,3,4] ����λ�� (2 + 3) / 2 = 2.5
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
        // ������0��ʼ������Ҫ+1��
        int left = (m+n) / 2; // ���� (m+n+1) / 2 �����������ĺ�����������ôleft��right��ֵ��һ��
        int right = (m+n) / 2 + 1; // ���� (m+n+2) / 2 �����������ĺ���ż������ôleft��right��ֵ���1
        return (getKth(nums1, 0, m-1, nums2, 0, n-1, left) +
                getKth(nums1, 0, m-1, nums2, 0, n-1, right)) * 0.5;
    }


    private int getKth(int[] nums1, int starts1, int ends1, int[] nums2, int starts2, int ends2, int k ){
        // ��Ҫ�ó���������ĳ��ȣ����������������Ի���Ҫ+1,
        // ��ʹ��ends+1����Ϊ�ų�ǰ��С���������λ������һ����0���п�����������������
        int len1 = ends1 - starts1 + 1;
        int len2 = ends2 - starts2 + 1;

        // ���len1����len2���͵���len1��len2��ֵ
        if (len1 > len2) return getKth( nums2, starts2, ends2, nums1, starts1, ends1, k); // ���ڲ���ֻ��һ��������Ԫ�ص����
//        if (len1 < len2) return getKth( nums1, starts1, ends1, nums2, starts2, ends2, k); // Error
        if (len1 == 0) return nums2[starts2 + k - 1];

        if (k == 1) return Math.min(nums1[starts1], nums2[starts2]);

        int i = starts1 + Math.min(len1, k/2) - 1;
        int j = starts2 + Math.min(len2, k/2) - 1;

        // ˭С��ȥ˭
        if (nums1[i] > nums2[j]){
            return getKth(nums1, starts1, ends1, nums2, j+1, ends2, k - (j - starts2 + 1));
        }else {
            return getKth(nums1, i+1, ends1, nums2, starts2, ends2, k - (i - starts1 + 1));
        }

    }
}

// 2023.10.25 ����һ��
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

        // ��¼����ʵʱ����
        int i = starts1 + Math.min(len1, k/2) - 1;
        int j = starts2 + Math.min(len2, k/2) - 1;

        if (nums1[i] > nums2[j]){
            return getKth(nums1, starts1, ends1, nums2, j+1, ends2, k-(j-starts2+1));
        }else {
            return getKth(nums1, i+1, ends1, nums2, starts2, ends2, k-(i-starts1+1));
        }

    }
}
