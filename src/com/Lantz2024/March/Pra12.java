package com.Lantz2024.March;

/**
 * <p>Project: Algorithm20230913 - Pra12
 * <p>Powered by Lantz On 2024-03-16 16:15:34
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra12
 * @since 1.8
 */
public class Pra12 {

}

/**
 * 2684. �������ƶ���������
 * �ѽ��
 * �е�
 * ��ر�ǩ
 * �����ҵ
 * ��ʾ
 * ����һ���±�� 0 ��ʼ����СΪ m x n �ľ��� grid ������������ �� ������ɡ�
 *
 * ����ԴӾ����һ���е� ��һ ��Ԫ������������·�ʽ���� grid ��
 *
 * �ӵ�Ԫ�� (row, col) �����ƶ��� (row - 1, col + 1)��(row, col + 1) �� (row + 1, col + 1) ������Ԫ������һ����ֵ �ϸ� ���ڵ�ǰ��Ԫ��ĵ�Ԫ��
 * �������ھ������ܹ� �ƶ� �� ��� ������
 *
 *
 *
 * ʾ�� 1��
 *
 *
 * ���룺grid = [[2,4,3,5],[5,4,9,3],[3,4,2,11],[10,9,13,15]]
 * �����3
 * ���ͣ����Դӵ�Ԫ�� (0, 0) ��ʼ���Ұ������·���ƶ���
 * - (0, 0) -> (0, 1).
 * - (0, 1) -> (1, 2).
 * - (1, 2) -> (2, 3).
 * ����֤�������ܹ��ƶ�����������
 * ʾ�� 2��
 *
 *
 * ���룺grid = [[3,2,4],[2,1,9],[1,1,7]]
 * �����0
 * ���ͣ��ӵ�һ�е���һ��Ԫ��ʼ���޷��ƶ���
 *
 */
class Solution12 {
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int[] row : grid){
            row[0] *= -1; // ��ӱ��
        }
        for(int j = 0; j < n-1; j++){
            boolean ok = false;
            for(int i = 0; i < m; i++){
                if(grid[i][j] > 0){
                    continue; // ���ڶ���
                }
                for(int k = Math.max(i-1, 0); k < Math.min(i+2, m); k++){
                    if(grid[k][j + 1] > -grid[i][j] ){
                        grid[k][j+1] *= -1; // ��ӱ��
                        ok = true;
                    }
                }
            }
            if(!ok){ // �޷�������
                return j;
            }
        }
        return n-1;
    }
}
