package com.Lantz2024.January;

/**
 * <p>Project: Algorithm20230913 - Pra02
 * <p>Powered by Lantz On 2024-01-07 09:01:30
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra02
 * @since 1.8
 */
public class Pra02 {
    public static void main(String[] args) {
        Solution02 solution02 = new Solution02();
        String r = "aa";
        String m = "aab";
        boolean result = solution02.canConstruct(r, m);
        System.out.println(result);
    }
}

class Solution02 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cnt = new int[30];
        // c - 'a' 将字符 c 转换为一个从 0 到 25 的整数
        for(char c : magazine.toCharArray()) cnt[c-'a']++;
        // 检查词出现的频次是否为负数，就是看r:"aa"出现的次数是否和m中的相等，相等就等于匹配了，如果在
        // m中出现了负数，那就说明r中的字符多了就比如eg2的情况
        for(char c : ransomNote.toCharArray()) if(--cnt[c-'a'] < 0) return false;
        return true;
    }
}
