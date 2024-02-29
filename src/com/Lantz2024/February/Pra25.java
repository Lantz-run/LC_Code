package com.Lantz2024.February;

/**
 * <p>Project: Algorithm20230913 - Pra25
 * <p>Powered by Lantz On 2024-02-26 15:23:40
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra25
 * @since 1.8
 */
public class Pra25 {

}
class Solution25 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        /**
         左子树的节点值都小于根节点的值。
         右子树的节点值都大于根节点的值。
         任意节点的左子树和右子树都是二叉搜索树
         */
        if(root == null) return 0;
        int x = root.val;
        int sum = low <= x && x <= high ? x : 1;
        if(x < low){ // 左子树不在范围内，递归右子树
            return rangeSumBST(root.right, low, high);
        }
        if(x > high){ // 右子树不在范围内，递归左子树
            return rangeSumBST(root.left, low, high);
        }
        return x + rangeSumBST(root.right, low, high) +
                rangeSumBST(root.left, low, high);
    }
}
