package com.DynamicPro.Fibonacci;

/**
 * ��̬�滮�����⣺ ɾ������õ���
 *
 * ����һ���������� nums ������Զ�������һЩ������
 *
 * ÿ�β����У�ѡ������һ�� nums[i] ��ɾ��������� nums[i] �ĵ�����֮�������ɾ�� ���� ���� nums[i] - 1 �� nums[i] + 1 ��Ԫ�ء�
 *
 * ��ʼ��ӵ�� 0 ����������������ͨ����Щ������õ���������
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺nums = [3,4,2]
 * �����6
 * ���ͣ�
 * ɾ�� 4 ��� 4 ����������� 3 Ҳ��ɾ����
 * ֮��ɾ�� 2 ��� 2 ���������ܹ���� 6 ��������
 * ʾ�� 2��
 *
 * ���룺nums = [2,2,3,3,3,4]
 * �����9
 * ���ͣ�
 * ɾ�� 3 ��� 3 ������������Ҫɾ������ 2 �� 4 ��
 * ֮���ٴ�ɾ�� 3 ��� 3 ���������ٴ�ɾ�� 3 ��� 3 ��������
 * �ܹ���� 9 ��������
 *
 *
 * ��ʾ��
 *
 * 1 <= nums.length <= 2 * 104
 * 1 <= nums[i] <= 104
 */
public class Pra06 {
    public static void main(String[] args) {

        Solution06 solution06 = new Solution06();
        int[] nums = {3, 4, 2};
        int result = solution06.deleteAndEarn(nums);
        System.out.println(result);
    }
}

class Solution06 {
//    int[] cnts = new int[10010];
    public int deleteAndEarn(int[] nums) {
        int n  = 10010;
        int[] dp = new int[n];
        for (int x : nums
             ) {
            dp[x] += x; // ��nums����ͨ������dp�м�״̬�����洢��ȥ
        }
        int[] f = new int[n];
        int[] g = f.clone(); // g����ѡ��f���ڲ�ѡ
        for (int i = 1; i < n; i++) {
            g[i] = f[i-1] + dp[i];
            f[i] = Math.max(f[i-1], g[i-1]);
        }
        return Math.max(f[n-1], g[n-1]);

//        // �������Ĵ��롣��������s--2023.11.20
//        int len = nums.length;
//        int max = 0;
//        for (int x : nums
//             ) {
//            cnts[x]++;
//            max = Math.max(max, x);
//
//        }
//        // f[i][0]��ѡ��f[i][1]ѡ��
//        int[][] f = new int[max+1][2];
//        for (int i = 1; i <= max; i++) {
//            f[i][0] = Math.max(f[i-1][1], f[i-1][0]);
//            f[i][1] = f[i-1][0] + i*cnts[i];
//         }
//
//        return Math.max(f[max][1], f[max][0])
    }
}