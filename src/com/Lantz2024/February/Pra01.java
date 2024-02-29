package com.Lantz2024.February;

import java.util.PriorityQueue;

/**
 * <p>Project: Algorithm20230913 - Pra01
 * <p>Powered by Lantz On 2024-02-01 22:51:46
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra01
 * @since 1.8
 */
public class Pra01 {
    public static void main(String[] args) {

    }
}
class Solution01 {
    public int[] numsGame(int[] nums) {
        int n = nums.length;
        final int MOD = 1_000_000_007;
        int[] ans = new int[n];
        PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a); // ά����Сһ��,�����
        PriorityQueue<Integer> right = new PriorityQueue<>(); // ά���ϴ�һ�룬С����
        long leftSum = 0, rightSum = 0;
        for(int i = 0; i < n; i++){
            int b = nums[i] - i;
            // ǰ׺����ʵ���������ǰn��֮��
            if(i % 2 == 0){ // ǰ׺����������
                if(!left.isEmpty() && b < left.peek()){
                    leftSum -= left.peek() - b;
                    left.offer(b);
                    b = left.poll();
                }
                rightSum += b;
                right.offer(b);
                ans[i] = (int) ((rightSum - right.peek() - leftSum) % MOD);
            }else{ // ǰ׺������ż��
                if(b > right.peek()){
                    rightSum += b - right.peek();
                    right.offer(b);
                    b = right.poll(); // �����Ѷ�
                }
                leftSum += b;
                left.offer(b);
                ans[i] = (int) ((rightSum - leftSum) % MOD);
            }
        }
        return ans;
    }
}
