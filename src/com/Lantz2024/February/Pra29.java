package com.Lantz2024.February;

import java.util.*;

/**
 * <p>Project: Algorithm20230913 - Pra29
 * <p>Powered by Lantz On 2024-02-29 09:23:56
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra29
 * @since 1.8
 */
public class Pra29 {

}

/**
 * 2581. 统计可能的树根数目
 * 已解答
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * Alice 有一棵 n 个节点的树，节点编号为 0 到 n - 1 。树用一个长度为 n - 1 的二维整数数组 edges 表示，其中 edges[i] = [ai, bi] ，表示树中节点 ai 和 bi 之间有一条边。
 *
 * Alice 想要 Bob 找到这棵树的根。她允许 Bob 对这棵树进行若干次 猜测 。每一次猜测，Bob 做如下事情：
 *
 * 选择两个 不相等 的整数 u 和 v ，且树中必须存在边 [u, v] 。
 * Bob 猜测树中 u 是 v 的 父节点 。
 * Bob 的猜测用二维整数数组 guesses 表示，其中 guesses[j] = [uj, vj] 表示 Bob 猜 uj 是 vj 的父节点。
 *
 * Alice 非常懒，她不想逐个回答 Bob 的猜测，只告诉 Bob 这些猜测里面 至少 有 k 个猜测的结果为 true 。
 *
 * 给你二维整数数组 edges ，Bob 的所有猜测和整数 k ，请你返回可能成为树根的 节点数目 。如果没有这样的树，则返回 0。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：edges = [[0,1],[1,2],[1,3],[4,2]], guesses = [[1,3],[0,1],[1,0],[2,4]], k = 3
 * 输出：3
 * 解释：
 * 根为节点 0 ，正确的猜测为 [1,3], [0,1], [2,4]
 * 根为节点 1 ，正确的猜测为 [1,3], [1,0], [2,4]
 * 根为节点 2 ，正确的猜测为 [1,3], [1,0], [2,4]
 * 根为节点 3 ，正确的猜测为 [1,0], [2,4]
 * 根为节点 4 ，正确的猜测为 [1,3], [1,0]
 * 节点 0 ，1 或 2 为根时，可以得到 3 个正确的猜测。
 * 示例 2：
 *
 *
 *
 * 输入：edges = [[0,1],[1,2],[2,3],[3,4]], guesses = [[1,0],[3,4],[2,1],[3,2]], k = 1
 * 输出：5
 * 解释：
 * 根为节点 0 ，正确的猜测为 [3,4]
 * 根为节点 1 ，正确的猜测为 [1,0], [3,4]
 * 根为节点 2 ，正确的猜测为 [1,0], [2,1], [3,4]
 * 根为节点 3 ，正确的猜测为 [1,0], [2,1], [3,2], [3,4]
 * 根为节点 4 ，正确的猜测为 [1,0], [2,1], [3,2]
 * 任何节点为根，都至少有 1 个正确的猜测。
 *
 *
 * 提示：
 *
 * edges.length == n - 1
 * 2 <= n <= 105
 * 1 <= guesses.length <= 105
 * 0 <= ai, bi, uj, vj <= n - 1
 * ai != bi
 * uj != vj
 * edges 表示一棵有效的树。
 * guesses[j] 是树中的一条边。
 * guesses 是唯一的。
 * 0 <= k <= guesses.length
 */
class Solution29 {
    private List<Integer>[] g;
    private Set<Long> s = new HashSet<>();
    private int k, ans, cnt0;

    public int rootCount(int[][] edges, int[][] guesses, int k) {
        this.k = k;
        g = new ArrayList[edges.length + 1];
        Arrays.setAll(g, i -> new ArrayList<>());
        for(int[] e : edges){
            int x = e[0];
            int y = e[1];
            g[x].add(y);
            g[y].add(x); // 建图
        }
        // guesses 转换为哈希表
        for(int[] e : guesses){
            s.add((long) e[0] << 32 | e[1]); // 两个 4 字节 int 压缩成一个 8 字节的
        }

        dfs(0, -1);
        reroot(0, -1, cnt0);
        return ans;
    }
    // 递归
    private void dfs(int x, int fa){
        for(int y : g[x]){
            if(y != fa){
                if(s.contains((long) x << 32 | y)){ // 以0的位置为树根，猜对了
                    cnt0++;
                }
                dfs(y, x);
            }
        }
    }

    private void reroot(int x, int fa, int cnt){
        if(cnt >= k){ // 此时 cnt 是以 x 为根时猜对的次数
            ans++;
        }
        for(int y : g[x]){
            if(y != fa){
                int c = cnt;
                if(s.contains((long) x << 32 | y)) c--; // 原来对的，现在错了
                if(s.contains((long) y << 32 | x)) c++; // 原来错的，现在对了
                reroot(y, x, c);
            }
        }
    }
}