package com.Lantz2024.February;

import java.util.*;

/**
 * <p>Project: Algorithm20230913 - Pra20
 * <p>Powered by Lantz On 2024-02-23 11:06:15
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra20
 * @since 1.8
 */
public class Pra20 {

}

/**
 * 2583. �������еĵ� K ����
 * �ѽ��
 * �е�
 * ��ر�ǩ
 * �����ҵ
 * ��ʾ
 * ����һ�ö������ĸ��ڵ� root ��һ�������� k ��
 *
 * ���е� ��� ��ָ ͬһ�� �Ͻڵ�ֵ���ܺ͡�
 *
 * �������е� k ��Ĳ�ͣ���һ����ͬ������������� k �㣬�򷵻� -1 ��
 *
 * ע�⣬��������ڵ�����ڵ�ľ�����ͬ������Ϊ������ͬһ�㡣
 *
 *
 *
 * ʾ�� 1��
 *
 *
 *
 * ���룺root = [5,8,9,2,1,3,7,4,6], k = 2
 * �����13
 * ���ͣ�����ÿһ��Ĳ�ͷֱ��ǣ�
 * - Level 1: 5
 * - Level 2: 8 + 9 = 17
 * - Level 3: 2 + 1 + 3 + 7 = 13
 * - Level 4: 4 + 6 = 10
 * �� 2 ��Ĳ�͵��� 13 ��
 * ʾ�� 2��
 *
 *
 *
 * ���룺root = [1,2,null,3], k = 1
 * �����3
 * ���ͣ����Ĳ���� 3 ��
 */
class Solution20 {
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> res = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            long sum = 0;
            while(n-- > 0){
                TreeNode node = q.poll();
                sum += node.val;
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);

            }
            res.add(sum);
        }
        int m = res.size();
        if(k > m){
            return -1;
        }
        Collections.sort(res);
        return res.get(m - k);
    }
}
