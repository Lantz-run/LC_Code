package com.Lantz2024.March;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>Project: Algorithm20230913 - Pra15
 * <p>Powered by Lantz On 2024-03-19 15:48:59
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra15
 * @since 1.8
 */
public class Pra15 {

}

/**
 * 1793. ���������������
 * �ѽ��
 * ����
 * ��ر�ǩ
 * �����ҵ
 * ��ʾ
 * ����һ���������� nums ���±�� 0 ��ʼ����һ������ k ��
 *
 * һ�������� (i, j) �� ���� ����Ϊ min(nums[i], nums[i+1], ..., nums[j]) * (j - i + 1) ��
 * һ�� �� ������������˵��±���Ҫ���� i <= k <= j ��
 *
 * ���㷵�� �� ������������� ���� ��
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺nums = [1,4,3,7,4,5], k = 3
 * �����15
 * ���ͣ���������������Ҷ˵��±��� (1, 5) ������Ϊ min(4,3,7,4,5) * (5-1+1) = 3 * 5 = 15 ��
 * ʾ�� 2��
 *
 * ���룺nums = [5,5,4,5,4,1,1,1], k = 0
 * �����20
 * ���ͣ���������������Ҷ˵��±��� (0, 4) ������Ϊ min(5,5,4,5,4) * (4-0+1) = 4 * 5 = 20 ��
 */
class Solution15 {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int[] left = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            int x = nums[i];
            while(!st.isEmpty() && x <= nums[st.peek()]){
                st.pop();
            }
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        int[] right = new int[n];
        st.clear();
        for(int i = n-1; i >= 0; i--){
            int x = nums[i];
            while(!st.isEmpty() && x <= nums[st.peek()]){
                st.pop();
            }
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            int h = nums[i];
            int l = left[i];
            int r = right[i];
            if(l < k && k < r){
                ans = Math.max(ans, h * (r - l - 1));
            }
        }
        return ans;
    }
}
