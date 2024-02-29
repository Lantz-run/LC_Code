package com.Lantz2023.OctoberPra;

import java.util.ArrayList;
import java.util.List;

/**
 * 2023.10.17 LeetCode第六题
 *
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：string convert(string s, int numRows);
 *
 * 示例 1：
 *
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 *
 * 输入：s = "A", numRows = 1
 * 输出："A"
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
        List<StringBuilder> rows = new ArrayList<>(); // 使用列表存储字符
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int i = 0; // 用于记录更新的行索引
        int flag = -1;

        for (char c : s.toCharArray()
             ) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows-1) flag = -flag; // 到Z的转折点就反序
            i += flag; // 更新行索引

        }

        StringBuilder res = new StringBuilder(); // StringBuilder: 用于动态地构建字符串
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
            i += flag; // 更新行
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows
             ) {
            res.append(row);
        }

        return res.toString();
    }
}