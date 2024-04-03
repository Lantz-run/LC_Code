package com.Lantz2024.April;

/**
 * <p>Project: Algorithm20230913 - node
 * <p>Powered by Lantz On 2024-02-07 23:23:07
 *
 * @author Lantz
 * @version 1.0
 * @Description node
 * @since 1.8
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }


    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
