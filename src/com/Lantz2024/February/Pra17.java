package com.Lantz2024.February;

import java.util.Arrays;

/**
 * <p>Project: Algorithm20230913 - Pra17
 * <p>Powered by Lantz On 2024-02-20 10:14:43
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra17
 * @since 1.8
 */
public class Pra17 {

}

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 *
 *
 *
 * 示例 1:
 *
 *
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * 示例 2:
 *
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 */
class Solution17 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if(n == 0){
            return null;
        }
        int leftSize = indexOf(inorder, preorder[0]); //左子树的大小
        int[] pre1 = Arrays.copyOfRange(preorder, 1, 1 + leftSize); // copyOfRange() 拷贝一个范围，左闭右开区间
        int[] pre2 = Arrays.copyOfRange(preorder, 1 + leftSize, n);
        int[] in1 = Arrays.copyOfRange(inorder, 0, leftSize);
        int[] in2 = Arrays.copyOfRange(inorder, 1 + leftSize, n);
        TreeNode left = buildTree(pre1, in1);
        TreeNode right = buildTree(pre2, in2);
        return new TreeNode(preorder[0], left, right);
    }
    // 返回x 在 a 中的下标，确保 x 一定在 a 中
    private int indexOf(int[] a, int x){
        for(int i = 0; ; i++){
            if(a[i] == x){
                return i;
            }
        }
    }
}
