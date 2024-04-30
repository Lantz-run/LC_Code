package com.Lantz2024.April;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Project: Algorithm20230913 - Pra24
 * <p>Powered by Lantz On 2024-04-24 12:08:21
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra24
 * @since 1.8
 */
public class Pra24 {

}

/**
 * 2385. ��Ⱦ��������Ҫ����ʱ��
 * �ѽ��
 * �е�
 * ��ر�ǩ
 * �����ҵ
 * ��ʾ
 * ����һ�ö������ĸ��ڵ� root ���������нڵ��ֵ ������ͬ �������һ������ start ���ڵ� 0 ���ӣ���Ⱦ �����ֵΪ start �Ľڵ㿪ʼ������
 *
 * ÿ���ӣ�����ڵ���������ȫ���������ͻᱻ��Ⱦ��
 *
 * �ڵ��ǰ��û�и�Ⱦ��
 * �ڵ���һ���Ѹ�Ⱦ�ڵ����ڡ�
 * ���ظ�Ⱦ��������Ҫ�ķ�������
 *
 *
 *
 * ʾ�� 1��
 *
 *
 * ���룺root = [1,5,3,null,4,10,6,9,2], start = 3
 * �����4
 * ���ͣ��ڵ㰴���¹��̱���Ⱦ��
 * - �� 0 ���ӣ��ڵ� 3
 * - �� 1 ���ӣ��ڵ� 1��10��6
 * - �� 2 ���ӣ��ڵ�5
 * - �� 3 ���ӣ��ڵ� 4
 * - �� 4 ���ӣ��ڵ� 9 �� 2
 * ��Ⱦ��������Ҫ 4 ���ӣ����Է��� 4 ��
 * ʾ�� 2��
 *
 *
 * ���룺root = [1], start = 1
 * �����0
 * ���ͣ��� 0 ���ӣ�����Ψһһ���ڵ㴦�ڸ�Ⱦ״̬������ 0 ��
 *
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution24 {
    private TreeNode startNode;
    private final Map<TreeNode, TreeNode> fa = new HashMap<>();
    public int amountOfTime(TreeNode root, int start) {
        dfs(root, null, start);
        return maxDepth(startNode, startNode);
    }

    private void dfs(TreeNode node, TreeNode from, int start){
        if(node == null){
            return;
        }
        fa.put(node, from); // ��¼���ڵ�
        // �ҵ� start
        if(node.val == start){
            startNode = node;
        }
        dfs(node.left, node, start);
        dfs(node.right, node, start);
    }

    private int maxDepth(TreeNode node, TreeNode from){
        if(node == null){
            return -1; // ������ -1����Ϊ start ������� 0
        }
        int res = -1;
        if(node.left != from){
            res = Math.max(maxDepth(node.left, node), res);
        }
        if(node.right != from){
            res = Math.max(maxDepth(node.right, node), res);
        }
        if(fa.get(node) != from){
            res = Math.max(maxDepth(fa.get(node), node), res);
        }
        return res + 1;
    }
}
