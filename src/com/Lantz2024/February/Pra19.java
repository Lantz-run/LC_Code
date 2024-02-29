package com.Lantz2024.February;

import java.util.Arrays;

/**
 * <p>Project: Algorithm20230913 - Pra19
 * <p>Powered by Lantz On 2024-02-21 10:16:46
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra19
 * @since 1.8
 */
public class Pra19 {

}

/**
 * 889. 根据前序和后序遍历构造二叉树
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给定两个整数数组，preorder 和 postorder ，其中 preorder 是一个具有 无重复 值的二叉树的前序遍历，postorder 是同一棵树的后序遍历，重构并返回二叉树。
 *
 * 如果存在多个答案，您可以返回其中 任何 一个。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
 * 输出：[1,2,3,4,5,6,7]
 * 示例 2:
 *
 * 输入: preorder = [1], postorder = [1]
 * 输出: [1]
 */
class Solution19 {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        if(n == 0){
            return null;
        }
        int leftSize = indexOf(postorder, preorder[0]);
        int[] pre1 = Arrays.copyOfRange(preorder, 1, 1 + leftSize);
        int[] pre2 = Arrays.copyOfRange(preorder, 1 + leftSize, n);
        int[] post1 = Arrays.copyOfRange(postorder, 0, leftSize);
        int[] post2 = Arrays.copyOfRange(postorder, leftSize, n-1);
        TreeNode left = constructFromPrePost(pre1, post1);
        TreeNode right = constructFromPrePost(pre2, post2);
        return new TreeNode(preorder[0], left, right);
    }
    // 确保 x 一定在 a 里面
    private int indexOf(int[] a, int x){
        for(int i = 0; ; i++){
            if(a[i] == x){
                return i;
            }
        }
    }
}
