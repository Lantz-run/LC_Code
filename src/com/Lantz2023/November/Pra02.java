package com.Lantz2023.November;

/**
 * 2023.11.03
 * LeetCode��ʮһ�⣺ʢ���ˮ������
 * ����һ������Ϊ n ���������� height ���� n �����ߣ��� i ���ߵ������˵��� (i, 0) �� (i, height[i]) ��
 *
 * �ҳ����е������ߣ�ʹ�������� x �Ṳͬ���ɵ�����������������ˮ��
 *
 * �����������Դ�������ˮ����
 *
 * ˵�����㲻����б������
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺[1,8,6,2,5,4,8,3,7]
 * �����49
 * ���ͣ�ͼ�д�ֱ�ߴ����������� [1,8,6,2,5,4,8,3,7]���ڴ�����£������ܹ�����ˮ����ʾΪ��ɫ���֣������ֵΪ 49��
 *
 * ʾ�� 2��
 *
 * ���룺height = [1,1]
 * �����1
 *
 *
 * ��ʾ��
 *
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 */
public class Pra02 {
    public static void main(String[] args) {

        Solution02_1 solution02 = new Solution02_1();
        int[] height = {1,8,6,2,5,4,8,3,7};
        int result = solution02.maxArea(height);
        System.out.println(result);
    }
}

class Solution02 {
    public int maxArea(int[] height) {

        int i = 0, j = height.length - 1, res = 0;
        while (i<j){
            res = height[i] < height[j] ?
                    Math.max(res, (j-i) * height[i++]) :
                    Math.max(res, (j-i) * height[j--]);
        }

        return res;
    }
}

// ʹ��˫ָ��
class Solution02_1{
    public int maxArea(int[] height){
        int i = 0, j = height.length-1, area = 0;
        while (i<j){
            // ���ε������ʽ
            area = height[i] < height[j] ?
            Math.max(area, (j-i)*height[i++]):
            Math.max(area, (j-i)*height[j--]);
        }

        return area;
    }
}