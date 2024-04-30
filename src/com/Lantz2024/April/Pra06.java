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
 * 1483. ���ڵ�ĵ� K ������
 * �ѽ��
 * ����
 * ��ر�ǩ
 * �����ҵ
 * ��ʾ
 * ����һ������������ n ���ڵ㣬���� 0 �� n-1 ��š����Ը��ڵ��������ʽ���������� parent[i] �ǽڵ� i �ĸ��ڵ㡣���ĸ��ڵ��Ǳ��Ϊ 0 �Ľڵ㡣
 *
 * ���ڵ�ĵ� k �����Ƚڵ��ǴӸýڵ㵽���ڵ�·���ϵĵ� k ���ڵ㡣
 *
 * ʵ�� TreeAncestor �ࣺ
 *
 * TreeAncestor��int n�� int[] parent�� �����͸������еĽڵ�����ʼ������
 * getKthAncestor(int node, int k) ���ؽڵ� node �ĵ� k �����Ƚڵ㡣������������������Ƚڵ㣬���� -1 ��
 *
 *
 * ʾ�� 1��
 *
 *
 *
 * ���룺
 * ["TreeAncestor","getKthAncestor","getKthAncestor","getKthAncestor"]
 * [[7,[-1,0,0,1,1,2,2]],[3,1],[5,2],[6,3]]
 *
 * �����
 * [null,1,0,-1]
 *
 * ���ͣ�
 * TreeAncestor treeAncestor = new TreeAncestor(7, [-1, 0, 0, 1, 1, 2, 2]);
 *
 * treeAncestor.getKthAncestor(3, 1);  // ���� 1 ������ 3 �ĸ��ڵ�
 * treeAncestor.getKthAncestor(5, 2);  // ���� 0 ������ 5 ���游�ڵ�
 * treeAncestor.getKthAncestor(6, 3);  // ���� -1 ��Ϊ����������Ҫ������Ƚڵ�
 */

class TreeAncestor {
    private int[][] pa;
    public TreeAncestor(int n, int[] parent) {
        int m = 32 - Integer.numberOfLeadingZeros(n); // n �Ķ����Ƴ���
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
    // numberOfLeadingZeros: ����ָ��intֵ�Ķ����Ʋ�����ʽ�����λ��������ࡱ��һλ֮ǰ����λ��
    public int getKthAncestor(int node, int k) {
        int m = 32 - Integer.numberOfLeadingZeros(k); // k �Ķ����Ƴ���
        for(int i = 0; i < m; i++){
            if(((k >> i) & 1) > 0){ // k �Ķ����ƴӵ͵��ߵ� i λ�� 1
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
