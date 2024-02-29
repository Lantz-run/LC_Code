package com.Lantz2023.OctoberPra;

/**
 * LeetCode�����⣺�������
 * 2023.10.12
 *
 * ���룺s = "babad"
 * �����"bab"
 * ���ͣ�"aba" ͬ���Ƿ�������Ĵ𰸡�
 *
 * ���룺s = "cbbd"
 * �����"bb"
 */
public class Pra05 {
    public static void main(String[] args) {

        Solution5_1 solution5 = new Solution5_1();
        String s = "cbbd";
        String result = solution5.longestPalindrome(s);
        System.out.println(result);

    }
}

class Solution5 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2){
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        char[] charArray = s.toCharArray();

        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
                // j-i+1: �����������babac�������Ӵ�(����һ��Ҫ�ǻ��ĵ�)Ϊaba����ʱ���±�i=2���±�j=4��
                // ����������0��ʼ����+1
                if (j - i + 1 > maxLen && validPalindromic(charArray, i, j)){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        // cbbd substring:beginIndex - ��ʼ�������������ڡ�
        //                endIndex - ����������������
        return s.substring(begin, begin+maxLen);
    }

    /**
     * ��֤�Ӵ��Ƿ������
     */
    private boolean validPalindromic(char[] charArray, int left, int right){
        while (left < right){
            if (charArray[left] != charArray[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

class Solution5_1{
    public String longestPalindrome(String s){
        int len = s.length();
        if (len < 2) return s;

        char[] charArray = s.toCharArray();
        int maxLen = 1; // �ô���������¼�Ӵ��ĳ��ȣ��ѱ��������ݷ�����һ�������洢�ţ����Է�ֹ���ݶ�ʧ
        int begin = 0;

        for (int i = 0; i < len - 1; i++) {
            // �����Ӵ���Ҳ�������Ӵ���
            for (int j = i+1; j < len; j++) {
                /**
                 * ���ﲻ�� len-i-1��ԭ��: 1������Ϊ�����Ǵ�ģ�2�����������п���С�� j
                 * ��ʱ���ҵ���ĳ��λ�ú�����ĳ��λ�ã�ǰ��һ��Ҫ�Ⱥ���С���������
                 * j - i + 1 ���� j + 1 - i   ǰ�����Ӵ��ĳ��ȣ��������ж��Ӵ�
                 */
                if (j - i + 1 > maxLen && validPalindromic(charArray, i, j)){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, maxLen + begin);
    }

    /**
     * ��֤�Ƿ�Ϊ������
     *
     * @param charArray
     * @param left ������ߵ��������൱�ڿ�ʼ���±�
     * @param right �����ұߵ��������൱����������������
     * @return
     */
    private boolean validPalindromic(char[] charArray, int left, int right){
        while (left < right){
            if (charArray[left] != charArray[right]) return false;

            left++;
            right--;
        }

        return true;
    }
}
