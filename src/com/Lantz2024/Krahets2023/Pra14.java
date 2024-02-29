package com.Lantz2024.Krahets2023;

/**
 * <p>Project: Algorithm20230913 - Pra14
 * <p>Powered by Lantz On 2024-02-18 23:18:47
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra14
 * @since 1.8
 */
public class Pra14 {
    public static void main(String[] args) {

    }
}
class Solution14 {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true;
        for(int i = 0, j = 0; j < t.length(); j++){
            if(s.charAt(i) == t.charAt(j)){
                if(++i == s.length()){
                    return true;
                }
                /* µÈ¼ÛÓÚ
                i++;
                if(i == s.length()){
                    return true;
                }
                * */
            }
        }
        return false;
    }
}
