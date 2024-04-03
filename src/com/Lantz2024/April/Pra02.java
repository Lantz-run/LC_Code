package com.Lantz2024.April;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Project: Algorithm20230913 - Pra02
 * <p>Powered by Lantz On 2024-04-02 15:25:59
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra02
 * @since 1.8
 */
public class Pra02 {

}

/**
 * 894. 所有可能的真二叉树
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个整数 n ，请你找出所有可能含 n 个节点的 真二叉树 ，并以列表形式返回。答案中每棵树的每个节点都必须符合 Node.val == 0 。
 *
 * 答案的每个元素都是一棵真二叉树的根节点。你可以按 任意顺序 返回最终的真二叉树列表。
 *
 * 真二叉树 是一类二叉树，树中每个节点恰好有 0 或 2 个子节点。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：n = 7
 * 输出：[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],
 * [0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
 * 示例 2：
 *
 * 输入：n = 3
 * 输出：[[0,0,0]]
 *
 *
 * 提示：
 *
 * 1 <= n <= 20
 */
class Solution02 {
    private static final List<TreeNode>[] f = new ArrayList[11];
    static {
        Arrays.setAll(f, i -> new ArrayList<>());
        f[1].add(new TreeNode());
        for (int i = 2; i < f.length; i++) { // 计算f[i]
            for (int j = 1; j < i; j++) { // 枚举左子树叶子数
                for (TreeNode left : f[j]) { // 枚举左子树
                    for (TreeNode right : f[i - j]) { // 枚举右子树
                        f[i].add(new TreeNode(0, left, right));
                    }
                }
            }
        }

    }

    public List<TreeNode> allPossibleFBT(int n) {
        return f[n % 2 > 0 ? (n + 1) / 2 : 0];
    }
}
