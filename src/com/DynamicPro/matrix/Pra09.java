package com.DynamicPro.matrix;

/**
 * <p>Project: Algorithm20230913 - Pra09
 * <p>Powered by Lantz On 2024-01-02 22:11:02
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra09
 * @since 1.8
 */
public class Pra09 {
    public static void main(String[] args) {

    }
}
class Solution09 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] f = new int[m][n];
        f[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(obstacleGrid[i][j] != 1){
                    if(i>0 && j>0){
                        f[i][j] = f[i][j-1] + f[i-1][j]; // 自由方向
                    }else if(i>0){
                        f[i][j] = f[i-1][j]; // 向右方向
                    }else if(j>0){
                        f[i][j] = f[i][j-1]; // 向下方向
                    }
                }
            }
        }
        return f[m-1][n-1];
    }
}