package com.Lantz2024.May;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Project: Algorithm20230913 - Pra23
 * <p>Powered by Lantz On 2024-05-23 15:10:27
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra23
 * @since 1.8
 */
public class Pra23 {
}

/**
 * 2831. �ҳ����ֵ������
 * �ѽ��
 * �е�
 * ��ر�ǩ
 * �����ҵ
 * ��ʾ
 * ����һ���±�� 0 ��ʼ���������� nums ��һ������ k ��
 *
 * ���������������Ԫ�ض���ȣ�����Ϊ��������һ�� ��ֵ������ ��ע�⣬�������� ��ֵ������ ��
 *
 * �� nums ��ɾ����� k ��Ԫ�غ󣬷��ؿ��ܵ����ֵ������ĳ��ȡ�
 *
 * ������ ��������һ�������ҿ���Ϊ�յ�Ԫ�����С�
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺nums = [1,3,2,3,1,3], k = 3
 * �����3
 * ���ͣ����ŵķ�����ɾ���±� 2 ���±� 4 ��Ԫ�ء�
 * ɾ����nums ���� [1, 3, 3, 3] ��
 * ���ֵ������� i = 1 ��ʼ�� j = 3 ���������ȵ��� 3 ��
 * ����֤���޷����������ĵ�ֵ�����顣
 * ʾ�� 2��
 *
 * ���룺nums = [1,1,2,2,1,1], k = 2
 * �����4
 * ���ͣ����ŵķ�����ɾ���±� 2 ���±� 3 ��Ԫ�ء�
 * ɾ����nums ���� [1, 1, 1, 1] ��
 * ����������ǵ�ֵ�����飬���ȵ��� 4 ��
 * ����֤���޷����������ĵ�ֵ�����顣
 */

class Solution23 {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        int n = nums.size();
        List<Integer>[] posLists = new ArrayList[n + 1];
        Arrays.setAll(posLists, i -> new ArrayList<>());
        for(int i = 0; i < n; i++){
            int x = nums.get(i);
            posLists[x].add(i - posLists[x].size());
        }

        int ans = 0;
        for(List<Integer> pos : posLists){
            if(pos.size() <= ans){
                continue;
            }

            int left = 0;
            for(int right = 0; right < pos.size(); right++){
                while(pos.get(right) - pos.get(left) > k){ // Ҫɾ���ĸ���̫����
                    left++;
                }
                ans = Math.max(ans, right - left + 1);
            }
        }
        return ans;
    }
}
