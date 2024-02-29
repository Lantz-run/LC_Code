package com.Lantz2023.November;

/**
 * LeetCode��13�⣺����ת����
 *
 * �������ְ������������ַ�: I�� V�� X�� L��C��D �� M��
 *
 * �ַ�          ��ֵ
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * ���磬 �������� 2 д�� II ����Ϊ�������е� 1 ��12 д�� XII ����Ϊ X + II �� 27 д��  XXVII, ��Ϊ XX + V + II ��
 *
 * ͨ������£�����������С�������ڴ�����ֵ��ұߡ���Ҳ�������������� 4 ��д�� IIII������ IV������ 1 ������ 5 ����ߣ�����ʾ�������ڴ��� 5 ��С�� 1 �õ�����ֵ 4 ��ͬ���أ����� 9 ��ʾΪ IX���������Ĺ���ֻ�������������������
 *
 * I ���Է��� V (5) �� X (10) ����ߣ�����ʾ 4 �� 9��
 * X ���Է��� L (50) �� C (100) ����ߣ�����ʾ 40 �� 90��
 * C ���Է��� D (500) �� M (1000) ����ߣ�����ʾ 400 �� 900��
 * ����һ���������֣�����ת����������
 *
 *
 *
 * ʾ�� 1:
 *
 * ����: s = "III"
 * ���: 3
 * ʾ�� 2:
 *
 * ����: s = "IV"
 * ���: 4
 * ʾ�� 3:
 *
 * ����: s = "IX"
 * ���: 9
 * ʾ�� 4:
 *
 * ����: s = "LVIII"
 * ���: 58
 * ����: L = 50, V= 5, III = 3.
 * ʾ�� 5:
 *
 * ����: s = "MCMXCIV"
 * ���: 1994
 * ����: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 *
 * ��ʾ��
 *
 * 1 <= s.length <= 15
 * s �����ַ� ('I', 'V', 'X', 'L', 'C', 'D', 'M')
 * ��Ŀ���ݱ�֤ s ��һ����Ч���������֣��ұ�ʾ�����ڷ�Χ [1, 3999] ��
 * ��Ŀ�������������Է�������������д���򣬲�����ֿ�λ�������
 * IL �� IM ���������Ӳ���������ĿҪ��49 Ӧ��д�� XLIX��999 Ӧ��д�� CMXCIX
 */
public class Pra04 {
    public static void main(String[] args) {

        Solution04 solution04 = new Solution04();
        String s = "MCMXCIV";
        int result = solution04.romanToInt(s);
        System.out.println(result);
      }
}

class Solution04 {
    /**
     * Example:
     * VIII:��߼��ұߣ���߱��ұߴ�V > III��
     * IV : �ұ�-��ߣ���߱��ұ�С��I < V��
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) { // MCMXCIV��i=0���ִ��һ���׸�M
            int num = getValue(s.charAt(i));
            if (preNum < num){
                sum -= preNum;
            }else {
                sum += preNum;
            }
            preNum = num; // 1��һ��ʼpreNumҪ��num����ֵ
        }
        sum += preNum;

        return sum;
    }
    private int getValue(char ch){
        switch (ch){
            case 'I': return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default: return 0;
        }

    }
}