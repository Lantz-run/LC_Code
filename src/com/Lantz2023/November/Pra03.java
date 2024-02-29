package com.Lantz2023.November;

/**
 * LeetCode��ʮ���⣺ ����ת��������
 *
 * �������ְ������������ַ��� I�� V�� X�� L��C��D �� M��
 *
 * �ַ�          ��ֵ
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * ���磬 �������� 2 д�� II ����Ϊ�������е� 1��12 д�� XII ����Ϊ X + II �� 27 д��  XXVII, ��Ϊ XX + V + II ��
 *
 * ͨ������£�����������С�������ڴ�����ֵ��ұߡ���Ҳ�������������� 4 ��д�� IIII������ IV������ 1 ������ 5 ����ߣ�
 * ����ʾ�������ڴ��� 5 ��С�� 1 �õ�����ֵ 4 ��ͬ���أ����� 9 ��ʾΪ IX���������Ĺ���ֻ�������������������
 *
 *  I ���Է��� V (5) �� X (10) ����ߣ�����ʾ 4 �� 9��
 *  X ���Է��� L (50) �� C (100) ����ߣ�����ʾ 40 �� 90��
 *  C ���Է��� D (500) �� M (1000) ����ߣ�����ʾ 400 �� 900��
 * ����һ������������תΪ�������֡�
 *
 *
 *
 * ʾ�� 1:
 * ����: num = 3
 * ���: "III"
 *
 * ʾ�� 2:
 * ����: num = 4
 * ���: "IV"
 * ʾ�� 3:
 *
 * ����: num = 9
 * ���: "IX"
 * ʾ�� 4:
 *
 * ����: num = 58
 * ���: "LVIII"
 * ����: L = 50, V = 5, III = 3.
 * ʾ�� 5:
 *
 * ����: num = 1994
 * ���: "MCMXCIV"
 * ����: M = 1000, CM = 900, XC = 90, IV = 4.
 */
public class Pra03 {
    public static void main(String[] args) {
        Solution03 solution03 = new Solution03();
        int num = 1994;
        String result = solution03.intToRoman(num);
        System.out.println(result);

    }
}

class Solution03 {
    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        while (index < 13){
            // ���num���ڻ��ߵ���nums��������֣��ͽ���Ӧ���ַ�׷��
            while (num >= nums[index]){
                stringBuilder.append(romans[index]);
                num -= nums[index]; // Ҫ��ȥ�Ѿ�����˵�����
            }
            index++;
        }

        return stringBuilder.toString();
    }
}
