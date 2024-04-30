package com.Lantz2024.April;

/**
 * <p>Project: Algorithm20230913 - Pra05
 * <p>Powered by Lantz On 2024-04-05 19:15:25
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra05
 * @since 1.8
 */
public class Pra05 {

}

/**
 * 1026. �ڵ���������֮�������ֵ
 * �ѽ��
 * �е�
 * ��ر�ǩ
 * �����ҵ
 * ��ʾ
 * �����������ĸ��ڵ� root���ҳ������� ��ͬ �ڵ� A �� B ֮������ֵ V������ V = |A.val - B.val|���� A �� B �����ȡ�
 *
 * ����� A ���κ��ӽڵ�֮һΪ B������ A ���κ��ӽڵ��� B �����ȣ���ô������Ϊ A �� B �����ȣ�
 *
 *
 *
 * ʾ�� 1��
 *
 *
 *
 * ���룺root = [8,3,10,1,6,null,14,null,null,4,7,13]
 * �����7
 * ���ͣ�
 * �����д����Ľڵ��������ȵĲ�ֵ������һЩ���£�
 * |8 - 3| = 5
 * |3 - 7| = 4
 * |8 - 1| = 7
 * |10 - 13| = 3
 * �����п��ܵĲ�ֵ�У����ֵ 7 �� |8 - 1| = 7 �ó���
 * ʾ�� 2��
 *
 *
 * ���룺root = [1,null,2,null,0,3]
 * �����3
 */

class Solution05 {
    private int ans = 0;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return ans;
    }
    private void dfs(TreeNode node, int mn, int mx){
        if(node == null){
            ans = Math.max(ans, mx - mn);
            return;
        }
        mn = Math.min(mn, node.val);
        mx = Math.max(mx, node.val);
        dfs(node.left, mn, mx);
        dfs(node.right, mn, mx);
    }
}