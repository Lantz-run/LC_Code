package com.Lantz2023.SeptemberPra;

/**
 * ������С���һ���������У������� 1 ��ʼ�������е�ÿһ��Ƕ�ǰһ���������ǰ�������£�
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 ������ ��one 1�� (��һ��һ��) , �� 11��
 * 11 ������ ��two 1s�� (������һ����, �� 21��
 * 21 ������ ��one 2��, ��one 1�� ����һ������ , ��һ��һ��) , �� 1211��
 * ����һ�������� n��1 �� n �� 30�������������еĵ� n �
 *
 * ע�⣺���������е�ÿһ���ʾΪһ���ַ�����
 *
 * ���磺ĳһ�У�3322251
 *      2 3 + 3 2 + 1 5 + 1 1
 *      ��һ�У�23321511
 */
public class Pra03_surfaceSequence {
    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 1; i <= 5; i++) {
            String result = solution.countAndSay(i);
            System.out.println(result);
        }

    }
}

class Solution{
    // Ҫ���n�����У�����Ҫ�õ�n-1������
    public String countAndSay(int n){
        if (n == 1) {
            return "1";
        }

        StringBuilder result = new StringBuilder();
        String lastSeq = countAndSay(n-1);

        char lastNum = lastSeq.charAt(0); // �����е�����
        int numCount = 0;
        for (int i = 0; i < lastSeq.length(); i++) {
            if (lastSeq.charAt(i) == lastNum){
                numCount++;
            }else {
                result.append(numCount);
                result.append(lastNum);
                lastNum = lastSeq.charAt(i); // ��������3322251�������33����Ҫ����lastNum
                numCount = 1; // ����numCount����Ϊ�Ѿ���������ǰ��Ĳ��֣�����:3322251��������33�󣬾�Ҫ����numCount����ʼ�����ͼ���222�Ĳ���
            }

            // ������һλ, ���ܺ͵�һλ������һλһ�����ǲ�һ������Ҫֱ��ԭ�����
            if (i == lastSeq.length() - 1){
                result.append(numCount);
                result.append(lastNum);
            }
        }

        return result.toString();
    }
}