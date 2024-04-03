package com.Lantz2024.April;

/**
 * <p>Project: Algorithm20230913 - Pra01
 * <p>Powered by Lantz On 2024-04-01 09:54:40
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra01
 * @since 1.8
 */
public class Pra01 {

}


class Solution01 {
    public String finalString(String s) {
        StringBuilder ans = new StringBuilder();
        char str[] = s.toCharArray();
        for(char c : str){
            if (c == 'i')
                ans.reverse();
            else
                ans.append(c);
        }
        return ans.toString();
    }
}