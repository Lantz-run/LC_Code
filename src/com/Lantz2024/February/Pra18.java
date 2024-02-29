package com.Lantz2024.February;

import java.util.Arrays;

/**
 * <p>Project: Algorithm20230913 - Pra18
 * <p>Powered by Lantz On 2024-02-21 09:32:27
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra18
 * @since 1.8
 */
public class Pra18 {

}

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 *
 *
 *
 * 示例 1:
 *
 *
 * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * 输出：[3,9,20,null,null,15,7]
 * 示例 2:
 *
 * 输入：inorder = [-1], postorder = [-1]
 * 输出：[-1]
 */
class Solution18 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        if(n == 0){
            return null;
        }
        //  postorder[n-1] 是二叉树的根
        int leftSize = indexOf(inorder, postorder[n-1]); // 左子树的大小
        int[] in1 = Arrays.copyOfRange(inorder, 0, leftSize);
        int[] in2 = Arrays.copyOfRange(inorder, 1 + leftSize, n);
        int[] post1 = Arrays.copyOfRange(postorder, 0, 1 + leftSize);
        int[] post2 = Arrays.copyOfRange(postorder, leftSize, n - 1);
        TreeNode left = buildTree(in1, post1);
        TreeNode right = buildTree(in2, post2);
        return new TreeNode(postorder[n-1], left, right);
    }
    // 确保 x 一定在 a 当中
    private int indexOf(int[] a, int x){
        for(int i = 0; ; i++){
            if(a[i] == x){
                return i;
            }
        }
    }
}
