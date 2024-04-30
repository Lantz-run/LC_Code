package com.Lantz2024.April;

/**
 * <p>Project: Algorithm20230913 - Pra06
 * <p>Powered by Lantz On 2024-04-06 16:22:02
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra06
 * @since 1.8
 */
public class Pra06 {

}

/**
 * 1483. 树节点的第 K 个祖先
 * 已解答
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 给你一棵树，树上有 n 个节点，按从 0 到 n-1 编号。树以父节点数组的形式给出，其中 parent[i] 是节点 i 的父节点。树的根节点是编号为 0 的节点。
 *
 * 树节点的第 k 个祖先节点是从该节点到根节点路径上的第 k 个节点。
 *
 * 实现 TreeAncestor 类：
 *
 * TreeAncestor（int n， int[] parent） 对树和父数组中的节点数初始化对象。
 * getKthAncestor(int node, int k) 返回节点 node 的第 k 个祖先节点。如果不存在这样的祖先节点，返回 -1 。
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：
 * ["TreeAncestor","getKthAncestor","getKthAncestor","getKthAncestor"]
 * [[7,[-1,0,0,1,1,2,2]],[3,1],[5,2],[6,3]]
 *
 * 输出：
 * [null,1,0,-1]
 *
 * 解释：
 * TreeAncestor treeAncestor = new TreeAncestor(7, [-1, 0, 0, 1, 1, 2, 2]);
 *
 * treeAncestor.getKthAncestor(3, 1);  // 返回 1 ，它是 3 的父节点
 * treeAncestor.getKthAncestor(5, 2);  // 返回 0 ，它是 5 的祖父节点
 * treeAncestor.getKthAncestor(6, 3);  // 返回 -1 因为不存在满足要求的祖先节点
 */

class TreeAncestor {
    private int[][] pa;
    public TreeAncestor(int n, int[] parent) {
        int m = 32 - Integer.numberOfLeadingZeros(n); // n 的二进制长度
        pa = new int[n][m];
        for(int i = 0; i < n; i++){
            pa[i][0] = parent[i];
        }
        for(int i = 0; i < m-1; i++){
            for(int x = 0; x < n; x++){
                int p = pa[x][i];
                pa[x][i+1] = p < 0 ? -1 : pa[p][i];
            }
        }
    }
    // numberOfLeadingZeros: 返回指定int值的二进制补码表达式中最高位（“最左侧”）一位之前的零位数
    public int getKthAncestor(int node, int k) {
        int m = 32 - Integer.numberOfLeadingZeros(k); // k 的二进制长度
        for(int i = 0; i < m; i++){
            if(((k >> i) & 1) > 0){ // k 的二进制从低到高第 i 位是 1
                node = pa[node][i];
                if(node < 0) break;
            }
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */
