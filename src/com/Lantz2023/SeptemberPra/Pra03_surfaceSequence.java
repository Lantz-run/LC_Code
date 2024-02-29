package com.Lantz2023.SeptemberPra;

/**
 * 外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作 “one 1” (“一个一”) , 即 11。
 * 11 被读作 “two 1s” (“两个一”）, 即 21。
 * 21 被读作 “one 2”, “one 1” （“一个二” , “一个一”) , 即 1211。
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
 *
 * 注意：整数序列中的每一项将表示为一个字符串。
 *
 * 例如：某一列：3322251
 *      2 3 + 3 2 + 1 5 + 1 1
 *      下一列：23321511
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
    // 要输出n的数列，首先要拿到n-1的数列
    public String countAndSay(int n){
        if (n == 1) {
            return "1";
        }

        StringBuilder result = new StringBuilder();
        String lastSeq = countAndSay(n-1);

        char lastNum = lastSeq.charAt(0); // 数列中的数字
        int numCount = 0;
        for (int i = 0; i < lastSeq.length(); i++) {
            if (lastSeq.charAt(i) == lastNum){
                numCount++;
            }else {
                result.append(numCount);
                result.append(lastNum);
                lastNum = lastSeq.charAt(i); // 还是例子3322251，输出完33，就要更新lastNum
                numCount = 1; // 重置numCount，因为已经遍历完了前面的部分，比如:3322251，遍历完33后，就要重置numCount，开始遍历和计数222的部分
            }

            // 输出最后一位, 不管和第一位还是上一位一样还是不一样，都要直接原地输出
            if (i == lastSeq.length() - 1){
                result.append(numCount);
                result.append(lastNum);
            }
        }

        return result.toString();
    }
}