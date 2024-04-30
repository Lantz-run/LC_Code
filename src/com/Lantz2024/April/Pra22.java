package com.Lantz2024.April;

import java.util.Arrays;

/**
 * <p>Project: Algorithm20230913 - Pra22
 * <p>Powered by Lantz On 2024-04-22 12:54:40
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra22
 * @since 1.8
 */
public class Pra22 {

}

/**
 * 377. ����ܺ� ��
 * �ѽ��
 * �е�
 * ��ر�ǩ
 * �����ҵ
 * ����һ���� ��ͬ ������ɵ����� nums ����һ��Ŀ������ target ������� nums ���ҳ��������ܺ�Ϊ target ��Ԫ����ϵĸ�����
 *
 * ��Ŀ���ݱ�֤�𰸷��� 32 λ������Χ��
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺nums = [1,2,3], target = 4
 * �����7
 * ���ͣ�
 * ���п��ܵ����Ϊ��
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * ��ע�⣬˳��ͬ�����б�������ͬ����ϡ�
 * ʾ�� 2��
 *
 * ���룺nums = [9], target = 3
 * �����0
 */

class Solution22 {
    public int combinationSum4(int[] nums, int target) {
        int[] memo = new int[target + 1];
        Arrays.fill(memo, -1); // -1 ����û�б������
        return dfs(target, nums, memo);
    }

    private int dfs(int i, int[] nums, int[] memo){
        if(i == 0){ // ������
            return 1;
        }

        if(memo[i] != -1){
            return memo[i];
        }

        int res = 0;
        for(int x : nums){
            if(x <= i){
                res += dfs(i - x, nums, memo);
            }
        }
        return memo[i] = res;
    }
}