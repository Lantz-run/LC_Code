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
        PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a); // 维护较小一半,大根堆
        PriorityQueue<Integer> right = new PriorityQueue<>(); // 维护较大一半，小根堆
        long leftSum = 0, rightSum = 0;
        for(int i = 0; i < n; i++){
            int b = nums[i] - i;
            // 前缀和其实就是数组的前n项之和
            if(i % 2 == 0){ // 前缀长度是奇数
                if(!left.isEmpty() && b < left.peek()){
                    leftSum -= left.peek() - b;
                    left.offer(b);
                    b = left.poll();
                }
                rightSum += b;
                right.offer(b);
                ans[i] = (int) ((rightSum - right.peek() - leftSum) % MOD);
            }else{ // 前缀长度是偶数
                if(b > right.peek()){
                    rightSum += b - right.peek();
                    right.offer(b);
                    b = right.poll(); // 弹出堆顶
                }
                leftSum += b;
                left.offer(b);
                ans[i] = (int) ((rightSum - leftSum) % MOD);
            }
        }
        return ans;
    }
}
