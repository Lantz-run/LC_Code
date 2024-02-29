package com.Lantz2024.February;

/**
 * <p>Project: Algorithm20230913 - Pra05
 * <p>Powered by Lantz On 2024-02-08 23:24:45
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra05
 * @since 1.8
 */
public class Pra05 {

}

/**
 * 993. �����������ֵܽڵ�
 * �ѽ��
 * ��
 * ��ر�ǩ
 * �����ҵ
 * �ڶ������У����ڵ�λ����� 0 ����ÿ�����Ϊ k �Ľڵ���ӽڵ�λ����� k+1 ����
 *
 * ����������������ڵ������ͬ���� ���ڵ㲻ͬ ����������һ�����ֵܽڵ㡣
 *
 * ���Ǹ����˾���Ψһֵ�Ķ������ĸ��ڵ� root ���Լ�����������ͬ�ڵ��ֵ x �� y ��
 *
 * ֻ����ֵ x �� y ��Ӧ�Ľڵ������ֵܽڵ�ʱ���ŷ��� true �����򣬷��� false��
 *
 *
 *
 * ʾ�� 1��
 *
 *
 * ���룺root = [1,2,3,4], x = 4, y = 3
 * �����false
 * ʾ�� 2��
 *
 *
 * ���룺root = [1,2,3,null,4,null,5], x = 5, y = 4
 * �����true
 * ʾ�� 3��
 *
 *
 *
 * ���룺root = [1,2,3,null,4], x = 2, y = 3
 * �����false
 */
class Solution05 {
    private boolean ans;
    private int depth;
    private TreeNode father;

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, father, depth, x, y);
        return ans;
    }
    // node ��� d
    private boolean dfs(TreeNode node, TreeNode fa, int d, int x, int y){
        if(node == null || depth > 0 && d > depth){
            return false;
        }
        if(node.val == x || node.val == y){
            if(depth > 0){
                ans = depth == d && father != fa;
                return true;
            }
            depth = d;
            father = fa; // ��ͬ���ڵ㣬�������ֵܽڵ�
        }
        return dfs(node.left, node, d + 1, x, y) || dfs(node.right, node , d + 1, x, y);
    }
}
