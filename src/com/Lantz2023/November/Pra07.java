package com.Lantz2023.November;

import java.util.Arrays;

/**
 * <p>Project: Algorithm20230913 - Pra07
 * <p>Powered by Lantz On 2023-11-29 08:20:08
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra07
 * @since 1.8
 *
 * LeetCode��ʮ���⣺��ӽ�������֮��
 *
 * ����һ������Ϊ n ���������� nums �� һ��Ŀ��ֵ target������� nums ��ѡ������������ʹ���ǵĺ��� target ��ӽ���
 *
 * �������������ĺ͡�
 *
 * �ٶ�ÿ������ֻ����ǡ��һ���⡣
 *
 * ʾ�� 1��
 *
 * ���룺nums = [-1,2,1,-4], target = 1
 * �����2
 * ���ͣ��� target ��ӽ��ĺ��� 2 (-1 + 2 + 1 = 2)
 *
 * ʾ�� 2��
 *
 * ���룺nums = [0,0,0], target = 1
 * �����0
 *
 *
 * ��ʾ��
 *
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -104 <= target <= 104
 */
public class Pra07 {
    public static void main(String[] args) {
        Solution07 solution07 = new Solution07();
        int[] nums = {-1,3,2,-4};
        int target = 1;
        int result = solution07.threeSumClosest(nums, target);
        System.out.println(result);
    }
}
class Solution07 {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        // i�ڴ˴��ǹ̶��ģ�ֻ����s��eָ���غϵ�ʱ��������ƶ�������s���Ǵ�i+1��ʼ
        for (int i = 0; i < len; i++) {
            int start = i+1, end = len-1;
            while (start < end){
                int sum = nums[i] + nums[start] + nums[end]; // Ҫ����while���棬�������Ϊÿ��ִ��forѭ��������һ�ε����������
                // �ж�sum-target��ֵ��С������ӽ�target����
                if (Math.abs(sum-target) < Math.abs(ans-target)){
                    ans = sum;
                }
                // sum����target˵������֮��endָ����ָ�����Ƚϴ��ˣ�Ҫ���ƣ�
                // �Ӷ���ָ����һ�����ǵ�����֮�Ϳ��Ը��ӽ�target; sumС��target�����Ҳ��һ���ĵ���
                if (sum > target){
                    end--;
                } else if (sum < target) {
                    start++;
                }else{
                    return ans;
                }
//                if (start == end) continue;
            }
        }

        return ans;
    }
}
