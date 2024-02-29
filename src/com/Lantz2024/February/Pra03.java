package com.Lantz2024.February;

import java.util.PriorityQueue;

/**
 * <p>Project: Algorithm20230913 - Pra03
 * <p>Powered by Lantz On 2024-02-06 18:03:34
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra03
 * @since 1.8
 */
public class Pra03 {
    public static void main(String[] args) {

    }

}
class Solution03 {
    public int magicTower(int[] nums) {
        long sum = 0;
        for(int x : nums){
            sum += x;
        }
        if(sum < 0){
            return -1;
        }
        long hp = 1; // ��ʼ��Ѫ��
        int ans = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i : nums){
            if(i < 0){
                q.offer(i);
            }
            hp += i;
            if(hp < 1){
                // ��Ϊ��ǰ����С��0��nums[i]���µģ����ԶѲ�Ϊ�գ�
                // ����poll()�����ᱨ��ָ���쳣
                hp -= q.poll();
                ans++;
            }
        }
        return ans;
    }
}