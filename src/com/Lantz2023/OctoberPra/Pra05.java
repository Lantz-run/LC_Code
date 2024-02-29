package com.Lantz2023.OctoberPra;

/**
 * LeetCode第五题：最长回文数
 * 2023.10.12
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 输入：s = "cbbd"
 * 输出："bb"
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
                // j-i+1: 假设回文数：babac，回文子串(并不一定要是回文的)为aba，此时的下标i=2，下标j=4，
                // 由于索引从0开始所以+1
                if (j - i + 1 > maxLen && validPalindromic(charArray, i, j)){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        // cbbd substring:beginIndex - 起始索引，包括在内。
        //                endIndex - 结束索引，不包括
        return s.substring(begin, begin+maxLen);
    }

    /**
     * 验证子串是否回文数
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
        int maxLen = 1; // 用处还是来记录子串的长度，把遍历的数据放在另一个变量存储着，可以防止数据丢失
        int begin = 0;

        for (int i = 0; i < len - 1; i++) {
            // 遍历子串（也是在找子串）
            for (int j = i+1; j < len; j++) {
                /**
                 * 这里不用 len-i-1的原因: 1、是因为它就是错的；2、那样岂不是有可能小于 j
                 * 此时是找到了某个位置和另外某个位置（前者一定要比后者小，否则错误）
                 * j - i + 1 —— j + 1 - i   前面是子串的长度，后面是判断子串
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
     * 验证是否为回文数
     *
     * @param charArray
     * @param left 数组左边的索引，相当于开始的下标
     * @param right 数组右边的索引，相当于数组最后面的索引
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
