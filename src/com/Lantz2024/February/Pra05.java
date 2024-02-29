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
 * 993. 二叉树的堂兄弟节点
 * 已解答
 * 简单
 * 相关标签
 * 相关企业
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 *
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 *
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 *
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 * 示例 2：
 *
 *
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 * 示例 3：
 *
 *
 *
 * 输入：root = [1,2,3,null,4], x = 2, y = 3
 * 输出：false
 */
class Solution05 {
    private boolean ans;
    private int depth;
    private TreeNode father;

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, father, depth, x, y);
        return ans;
    }
    // node 深度 d
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
            father = fa; // 不同父节点，就是堂兄弟节点
        }
        return dfs(node.left, node, d + 1, x, y) || dfs(node.right, node , d + 1, x, y);
    }
}
