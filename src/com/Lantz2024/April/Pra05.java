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
 * 1026. 节点与其祖先之间的最大差值
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给定二叉树的根节点 root，找出存在于 不同 节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。
 *
 * （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [8,3,10,1,6,null,14,null,null,4,7,13]
 * 输出：7
 * 解释：
 * 我们有大量的节点与其祖先的差值，其中一些如下：
 * |8 - 3| = 5
 * |3 - 7| = 4
 * |8 - 1| = 7
 * |10 - 13| = 3
 * 在所有可能的差值中，最大值 7 由 |8 - 1| = 7 得出。
 * 示例 2：
 *
 *
 * 输入：root = [1,null,2,null,0,3]
 * 输出：3
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