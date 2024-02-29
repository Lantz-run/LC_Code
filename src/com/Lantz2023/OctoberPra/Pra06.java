package com.Lantz2023.OctoberPra;

import java.util.ArrayList;
import java.util.List;

/**
 * 2023.10.17 LeetCode������
 *
 * ��һ�������ַ��� s ���ݸ��������� numRows ���Դ������¡������ҽ��� Z �������С�
 * ���������ַ���Ϊ "PAYPALISHIRING" ����Ϊ 3 ʱ���������£�
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * ֮����������Ҫ�����������ж�ȡ��������һ���µ��ַ��������磺"PAHNAPLSIIGYIR"��
 *
 * ����ʵ��������ַ�������ָ�������任�ĺ�����string convert(string s, int numRows);
 *
 * ʾ�� 1��
 *
 * ���룺s = "PAYPALISHIRING", numRows = 3
 * �����"PAHNAPLSIIGYIR"
 * ʾ�� 2��
 * ���룺s = "PAYPALISHIRING", numRows = 4
 * �����"PINALSIGYAHRPI"
 * ���ͣ�
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * ʾ�� 3��
 *
 * ���룺s = "A", numRows = 1
 * �����"A"
 */
public class Pra06 {
    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        String s = "PAYPALISHIRING";
        String result = solution6.convert(s, 3);
        System.out.println(result);

    }
}

class Solution6 {
    public String convert(String s, int numRows) {
        if (numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<>(); // ʹ���б�洢�ַ�
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int i = 0; // ���ڼ�¼���µ�������
        int flag = -1;

        for (char c : s.toCharArray()
             ) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows-1) flag = -flag; // ��Z��ת�۵�ͷ���
            i += flag; // ����������

        }

        StringBuilder res = new StringBuilder(); // StringBuilder: ���ڶ�̬�ع����ַ���
        for (StringBuilder row : rows
             ) {
            res.append(row);
        }
        return res.toString();
    }
}

class Solution6_1{
    public String convert(String s, int numRows){
        if (numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int i = 0;
        int flag = -1;

        for (char c : s.toCharArray()
             ) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows-1) flag = -flag;
            i += flag; // ������
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows
             ) {
            res.append(row);
        }

        return res.toString();
    }
}