package com.Lantz2024.April;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

/**
 * <p>Project: Algorithm20230913 - Pra08
 * <p>Powered by Lantz On 2024-04-08 15:17:44
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra08
 * @since 1.8
 */
public class Pra08 {
    public static void main(String[] args) {
        Solution08_1 solution08_1 = new Solution08_1();
        int[] nums = {1,1,2};
        int re = solution08_1.removeDuplicates(nums);
        System.out.println(re);
    }

}

/**
 * 2009. ʹ�������������ٲ�����
 * �ѽ��
 * ����
 * ��ر�ǩ
 * �����ҵ
 * ��ʾ
 * ����һ���������� nums ��ÿһ�β����У�����Խ� nums �� ���� һ��Ԫ���滻�� ���� ������
 *
 * ��� nums ����������������ô���� ������ ��
 *
 * nums ������Ԫ�ض��� ������ͬ �ġ�
 * nums �� ��� Ԫ���� ��С Ԫ�صĲ���� nums.length - 1 ��
 * �ȷ�˵��nums = [4, 2, 5, 3] �� ������ ������ nums = [1, 2, 3, 5, 6] ���������� ��
 *
 * ���㷵��ʹ nums ���� �� ���� ����������
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺nums = [4,2,5,3]
 * �����0
 * ���ͣ�nums �Ѿ����������ˡ�
 * ʾ�� 2��
 *
 * ���룺nums = [1,2,3,5,6]
 * �����1
 * ���ͣ�һ�����ܵĽ��ǽ����һ��Ԫ�ر�Ϊ 4 ��
 * �������Ϊ [1,2,3,5,4] �����������顣
 * ʾ�� 3��
 *
 * ���룺nums = [1,10,100,1000]
 * �����3
 * ���ͣ�һ�����ܵĽ��ǣ�
 * - ���ڶ���Ԫ�ر�Ϊ 2 ��
 * - ��������Ԫ�ر�Ϊ 3 ��
 * - �����ĸ�Ԫ�ر�Ϊ 4 ��
 * �������Ϊ [1,2,3,4] �����������顣
 */

class Solution08 {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int m = 1; // ��¼�µ����ظ�Ԫ�ص�����
        for(int i = 1; i < n; i++){
            if(nums[i] != nums[i-1]){
                nums[m++] = nums[i]; // ԭ��ȥ��
            }
        }

        int ans = 0;
        int left = 0; // ����߽�
        for(int i = 0; i < m; i++){
            while (nums[left] < nums[i] - n + 1){ // nums[left] ���ڴ�����
                left++;
            }
            ans = Math.max(ans, i - left + 1); // ��ౣ�������Ԫ�ظ���
        }
        return n - ans;
    }
}

class Solution08_1 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int m = 1;
        for(int i = 1; i < n; i++){
            if(nums[i] != nums[i-1]){
                nums[m++] = nums[i];
            }
        }
//        for (int i = 0; i < 2; i++) {
//            System.out.println(nums[i] );
//        }
        return m;
    }
}