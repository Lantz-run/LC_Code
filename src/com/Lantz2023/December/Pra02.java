package com.Lantz2023.December;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Project: Algorithm20230913 - Pra02
 * <p>Powered by Lantz On 2023-12-21 22:51:00
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra02
 * @since 1.8
 *
 * LeetCode18. ����֮��
 *
 * ����һ���� n ��������ɵ����� nums ����һ��Ŀ��ֵ target ��
 * �����ҳ���������������ȫ�������Ҳ��ظ�����Ԫ��
 * [nums[a], nums[b], nums[c], nums[d]] ����������Ԫ��Ԫ��һһ��Ӧ������Ϊ������Ԫ���ظ�����
 *
 * 0 <= a, b, c, d < n
 * a��b��c �� d ������ͬ
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * ����԰� ����˳�� ���ش� ��
 *
 *
 * ʾ�� 1��
 *
 * ���룺nums = [1,0,-1,0,-2,2], target = 0
 * �����[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 *
 * ʾ�� 2��
 *
 * ���룺nums = [2,2,2,2,2], target = 8
 * �����[[2,2,2,2]]
 *
 */
public class Pra02 {
    public static void main(String[] args) {
        Solution02 solution02 = new Solution02();
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        List<List<Integer>> result = solution02.fourSum(nums,target);
        System.out.println(result);
    }
}

class Solution02 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < len - 3; i++) {
            long x = nums[i];
            if (i > 0 && x == nums[i - 1]) continue; // ��Ϊnums[j]������ߵģ����nums[j]������0���Ǻ���϶�������0�����Ҳ�ʹ���0��,i<0�������
            if (x + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break; // ����ߵļ�����������0���Ǳ������ұ�Ҳ�Ǵ���0�ģ��Ͼ������Ѿ��������
            if (x + nums[len - 1] + nums[len - 2] + nums[len - 3] < target)
                continue; // С��target����ϣ���������ѭ�����ҵ�ʱ���п��ܴﵽtarget
            for (int j = i + 1; j < len - 2; j++) {
                long y = nums[j];
                if (j > i + 1 && y == nums[j - 1]) continue;
                if (y + x + nums[j + 1] + nums[j + 2] > target) break;
                if (y + x + nums[len - 1] + nums[len - 2] < target) continue;
                int k = j + 1, l = len - 1;
                while (k < l) {
                    long sum = x + y + nums[k] + nums[l];
                    if (sum < target) k++;
                    else if (sum > target) {
                        l--;
                    } else {
                        //                        res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], nums[l])));
                        //                        while (k<l && nums[k] == nums[++k]);
                        //                        while (k<l && nums[l] == nums[--l]);
                        res.add(List.of((int) x, (int) y, nums[k], nums[l]));
                        // �����ظ�����
                        for (k++; k < l && nums[k] == nums[k - 1]; k++) ;
                        for (l--; l > k && nums[l] == nums[l + 1]; l--) ;

                    }
                }
            }

        }
        return res;
    }
}


//        for (int i = 0; i < len-2; i++) {
//            int l = len-1, k = len-2;
//            for (int j = 0; j < len-3; j++) {
//                long sum = nums[i]+nums[j]+nums[k]+nums[l];
//                if (nums[j] > 0) break; // ��Ϊnums[j]������ߵģ����nums[j]������0���Ǻ���϶�������0�����Ҳ�ʹ���0��
////                if (sum > target) break; // sum���Ѿ�����0�ˣ���ô�����������Ŀ϶�Ҳ�Ǵ���0
//                if (sum < target && sum > target) continue; // С��0�Ļ��еÿ�
//                if (sum == target){
//                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], nums[l])));
//                }
//                while (j < K)
//
//            }
//        }

