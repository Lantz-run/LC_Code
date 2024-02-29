package com.Lantz2023.OctoberPra;

/**
 * 2023.10.22
 * LeetCode第八题： 字符串转换整数 (atoi)
 *
 *请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 *
 * 函数 myAtoi(string s) 的算法如下：
 *
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [?2^31,  2^31 ? 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，
 * 小于 ?2^31 的整数应该被固定为 ?2^31 ，大于 2^31 ? 1 的整数应该被固定为 2^31 ? 1 。
 * 返回整数作为最终结果。
 * 注意：
 *
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符
 *
 * 示例 1：
 * 输入：s = "42"
 * 输出：42
 * 解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
 * 第 1 步："42"（当前没有读入字符，因为没有前导空格）
 *          ^
 * 第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
 *          ^
 * 第 3 步："42"（读入 "42"）
 *            ^
 * 解析得到整数 42 。
 * 由于 "42" 在范围 [-231, 231 - 1] 内，最终结果为 42 。
 *
 * 示例 2：
 *
 * 输入：s = "   -42"
 * 输出：-42
 * 解释：
 * 第 1 步："   -42"（读入前导空格，但忽视掉）
 *             ^
 * 第 2 步："   -42"（读入 '-' 字符，所以结果应该是负数）
 *              ^
 * 第 3 步："   -42"（读入 "42"）
 *                ^
 * 解析得到整数 -42 。
 * 由于 "-42" 在范围 [-231, 231 - 1] 内，最终结果为 -42 。
 *
 * 示例 3：
 *
 * 输入：s = "4193 with words"
 * 输出：4193
 * 解释：
 * 第 1 步："4193 with words"（当前没有读入字符，因为没有前导空格）
 *          ^
 * 第 2 步："4193 with words"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
 *          ^
 * 第 3 步："4193 with words"（读入 "4193"；由于下一个字符不是一个数字，所以读入停止）
 *              ^
 * 解析得到整数 4193 。
 * 由于 "4193" 在范围 [-231, 231 - 1] 内，最终结果为 4193 。
 *
 */
public class Pra08 {
    public static void main(String[] args) {
        Solution08 solution08 = new Solution08();
        String s = "-2147483649";
        int result = solution08.myAtoi(s);
        System.out.println(result);

//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);

    }
}

class Solution08 {
    public int myAtoi(String s) {

        int len = s.length();
        char[] charArray = s.toCharArray();

        // 1、去掉前导空格
        int index = 0;
        while (index < len && charArray[index] == ' '){
            index++;
        }
       // 2、极端情况，字符串是"      ";
        if (index == len) return 0;

       // 3、第一个字符是'-'和'+'的情况
        int sign = 1;
        char firstChar = charArray[index];
        if (firstChar == '+'){
            index++;
        } else if (firstChar == '-') {
            index++;
            sign = -1;
        }

        // 4、将后续的数字字符串进行转换
        int res = 0; // 存储字符串转后的数字
        while (index < len){
            char currChar = charArray[index]; // 每一次读取到字符都存储到currChar
            // 判断是否为数字
            if (currChar > '9' || currChar < '0'){
                break;
            }

            // 需要首先判断是否合法
            if (res > Integer.MAX_VALUE / 10 ||
                    (res == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10)){
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 ||
                    (res == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))){
                return Integer.MIN_VALUE;
            }

            /**
             * res*10是为了每一次读取到一个数字就增加一个进位
             *
             *当你执行 currChar - '0' 时，实际上是执行了字符的ASCII码值相减操作。
             *由于 '0' 的ASCII码值是最小的，减去 '0' 会得到一个整数值，这个整数值对应于 currChar 表示的数字字符
             * 例如:'0'的ASCII码是48，'1'的ASCII码是49，它们相减就会得到一个整数 1
             */
            res = res * 10 + sign * (currChar - '0');
            index++;
        }

        return res;
    }
}
