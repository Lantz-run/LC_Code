package com.Lantz2024.February;

/**
 * <p>Project: Algorithm20230913 - Pra26
 * <p>Powered by Lantz On 2024-02-26 15:49:29
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra26
 * @since 1.8
 */
public class Pra26 {

}
class Solution26 {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int lDepth = maxDepth(root.left);
        int rDepth = maxDepth(root.right);
        return Math.max(lDepth, rDepth) + 1; // 在当前的节点 + 1
    }
}
