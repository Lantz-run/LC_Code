package com.Lantz2024.February;

/**
 * <p>Project: Algorithm20230913 - Pra23
 * <p>Powered by Lantz On 2024-02-25 17:05:38
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra23
 * @since 1.8
 */
public class Pra23 {

}
class Solution23 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /**
         若它的左子树不为空，则左子树上所有节点的值都小于根节点的值
         若它的右子树不为空，则右子树上所有节点的值都大于根节点的值
         它的左右子树也分别为二叉搜索树
         */
        int x = root.val;
        if(p.val < x && q.val < x){ // p, q 都在左子树
            return lowestCommonAncestor(root.left, p, q);
        }
        if(p.val > x && q.val > x){ // p, q 都在右子树
            return lowestCommonAncestor(root.right, p, q);
        }
        return root; // 其它

    }
}
