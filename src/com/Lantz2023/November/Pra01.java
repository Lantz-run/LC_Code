package com.Lantz2023.November;

/**
 * LeetCode��ʮ�⣺ ������ʽƥ��
 *
 * ����һ���ַ��� s ��һ���ַ����� p��������ʵ��һ��֧�� '.' �� '*' ��������ʽƥ�䡣
 *
 * '.' ƥ�����ⵥ���ַ�
 * '*' ƥ���������ǰ�����һ��Ԫ��
 * ��νƥ�䣬��Ҫ���� ���� �ַ��� s�ģ������ǲ����ַ�����
 *
 * ʾ�� 1��
 * ���룺s = "aa", p = "a"
 * �����false
 * ���ͣ�"a" �޷�ƥ�� "aa" �����ַ�����
 *
 * ʾ�� 2:
 * ���룺s = "aa", p = "a*"
 * �����true
 * ���ͣ���Ϊ '*' �������ƥ���������ǰ�����һ��Ԫ��, ������ǰ���Ԫ�ؾ��� 'a'����ˣ��ַ��� "aa" �ɱ���Ϊ 'a' �ظ���һ�Ρ�
 *
 * ʾ�� 3��
 * ���룺s = "ab", p = ".*"
 * �����true
 * ���ͣ�".*" ��ʾ��ƥ�����������'*'�������ַ���'.'����
 *
 *
 * ��ʾ��
 * 1 <= s.length <= 20
 * 1 <= p.length <= 20
 * s ֻ������ a-z ��Сд��ĸ��
 * p ֻ������ a-z ��Сд��ĸ���Լ��ַ� . �� *��
 * ��֤ÿ�γ����ַ� * ʱ��ǰ�涼ƥ�䵽��Ч���ַ�
 *
 */
public class Pra01 {
    public static void main(String[] args) {

        Solution01 solution01 = new Solution01();
        String s = "";
        String p = "a*";
        boolean result = solution01.isMatch(s, p);
        System.out.println(result);
    }
}

class Solution01 {
    public boolean isMatch(String s, String p) {
        // ת��Ϊһ���ַ������ܸ��õػ�ȡ�±�
        char[] charArray1 = s.toCharArray();
        char[] charArray2 = p.toCharArray();

        // ʹ�ö�ά�����s��p�����ַ����Ƿ��ܹ�ƥ��
        boolean[][] dp = new boolean[charArray1.length + 1][charArray2.length + 1];

        /**
         * base case: ����pȥƥ��s
         *  case1��s, p ��Ϊ�� -> �϶��ܹ�ƥ��
         *  case2��sΪ�գ�p��Ϊ�� -> ���Ҫ�� p�Ƿ����'.' or '*'
         *  case3��s��Ϊ�գ�pΪ�� -> �����ƥ�䣬��Ϊ�������⣬ƥ��ĳ�������� p������
         */
        dp[0][0] = true; // �����ַ������ǿգ��ܹ�ƥ����

        // case2
        for (int j = 1; j <= charArray2.length; j++) {
            if (charArray2[j-1] == '*') {
                dp[0][j] = dp[0][j-2];
            }
        }

        /**
         * !!!: '*' ƥ���������ǰ�����һ��Ԫ��, ��һ��Ԫ��ָ�ľ�������Ǻ����ڵ���һ���ַ�����Ԫ�أ�����������һ���ַ�����s����Ԫ��
         */
        for (int i = 1; i <= charArray1.length; i++) {
            for (int j = 1; j <= charArray2.length; j++) {
                if (charArray1[i-1] == charArray2[j-1] || charArray2[j-1] =='.'){
                    dp[i][j] = dp[i-1][j-1]; // a1-���ӣ�s="aab", p="aabb*"

                } else if (charArray2[j-1] == '*') { // a2-���ӣ�s="aab",p="aab*"
                    if (charArray1[i-1] == charArray2[j-2] || charArray2[j-2] == '.'){
                        dp[i][j] = dp[i][j-2] || dp[i-1][j]; // '*'ƥ��һ�λ��߶�ε����

                    }else {
                        dp[i][j] = dp[i][j-2]; // a3-����: s="aabb"����s="aabbb"���У�,p="aab*"
                    }

                }
            }
        }

        return dp[charArray1.length][charArray2.length];
    }
}

class Solution01_1{
    public boolean isMatch(String s, String p){
        char[] cs = s.toCharArray();
        char[] cp = p.toCharArray();
        /**
         * base case: ����pȥƥ��s
         *  case1��s, p ��Ϊ�� -> �϶��ܹ�ƥ��
         *  case2��sΪ�գ�p��Ϊ�� -> ���Ҫ�� p�Ƿ����'.' or '*'
         *  case3��s��Ϊ�գ�pΪ�� -> �����ƥ�䣬��Ϊ�������⣬ƥ��ĳ�������� p������
         */
        boolean dp[][] = new boolean[cs.length+1][cp.length+1];
        dp[0][0] = true;
        // case2: s="", p="ab*c"
        for (int i = 1; i <= cp.length; i++) {
            if (cp[i-1] == '*'){
                dp[0][i] = dp[0][i-2];
            }
        }

        for (int i = 1; i <= cs.length; i++) {
            for (int j = 0; j <= cp.length; j++) {

            }
        }
        

        return false;
    }
}
