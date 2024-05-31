package com.Lantz2024.May;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Project: Algorithm20230913 - Pra13
 * <p>Powered by Lantz On 2024-05-13 15:15:54
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra13
 * @since 1.8
 */
public class Pra13 {
}

/**
 * 994. ���õ�����
 * �ѽ��
 * �е�
 * ��ر�ǩ
 * �����ҵ
 * �ڸ����� m x n ���� grid �У�ÿ����Ԫ���������������ֵ֮һ��
 *
 * ֵ 0 ����յ�Ԫ��
 * ֵ 1 �����������ӣ�
 * ֵ 2 �����õ����ӡ�
 * ÿ���ӣ����õ����� ��Χ 4 ������������ ���������Ӷ��ḯ�á�
 *
 * ���� ֱ����Ԫ����û����������Ϊֹ�����뾭������С����������������ܣ����� -1 ��
 *
 *
 *
 * ʾ�� 1��
 *
 *
 *
 * ���룺grid = [[2,1,1],[1,1,0],[0,1,1]]
 * �����4
 * ʾ�� 2��
 *
 * ���룺grid = [[2,1,1],[0,1,1],[1,0,1]]
 * �����-1
 * ���ͣ����½ǵ����ӣ��� 2 �У� �� 0 �У���Զ���ḯ�ã���Ϊ����ֻ�ᷢ���� 4 �������ϡ�
 * ʾ�� 3��
 *
 * ���룺grid = [[0,2]]
 * �����0
 * ���ͣ���Ϊ 0 ����ʱ�Ѿ�û�����������ˣ����Դ𰸾��� 0
 */

class Solution13 {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        List<int[]> q = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    fresh++; // ͳ���������ӵĸ���
                } else if(grid[i][j] == 2){
                    q.add(new int[]{i, j}); // һ��ʼ�͸��õ����ӵĸ���
                }
            }
        }

        int ans = -1;
        while(!q.isEmpty()){
            ans++; // ����һ����
            List<int[]> tmp = q;
            q = new ArrayList<>();
            for(int[] pos : tmp){ // �Ѿ����õ�����
                for(int[] d : DIRECTIONS){
                    // ��ʼ��λ��
                    int i = pos[0] + d[0];
                    int j = pos[1] + d[1];
                    if(0 <= i && i < m && 0 <= j && j < n && grid[i][j] == 1){
                        fresh--;
                        grid[i][j] = 2; // ��ɸ��õ�����
                        q.add(new int[]{i, j});
                    }
                }
            }
        }
        return fresh > 0 ? -1 : Math.max(ans, 0);
    }
}
