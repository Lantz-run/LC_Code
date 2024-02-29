package com.Lantz2023;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Test01 {


        public static void main(String[] args) {
            Solution solution = new Solution();
            String str = "-2147483649";
            int res = solution.myAtoi(str);
            System.out.println(res);

            System.out.println(Integer.MAX_VALUE);
            System.out.println(Integer.MIN_VALUE);
        }

        @Test
        public void test(){
            List<String> stooges = Arrays.asList("Larry", "Moe", "Curly");
            for (String s : stooges
                 ) {
                System.out.println(s);
                
            }
        }
    }
class Solution {

    public int myAtoi(String str) {
        int len = str.length();
        // str.charAt(i) ������ȥ����±�ĺϷ��ԣ�һ����ת�����ַ�����
        char[] charArray = str.toCharArray();

        // 1��ȥ��ǰ���ո�
        int index = 0;
        while (index < len && charArray[index] == ' ') {
            index++;
        }

        // 2������Ѿ�������ɣ���Լ������� "      "��
        if (index == len) {
            return 0;
        }

        // 3��������ַ����ַ������� 1 ����Ч������¼����
        int sign = 1;
        char firstChar = charArray[index];
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-') {
            index++;
            sign = -1;
        }

        // 4�����������ֵ������ַ�����ת��
        // ����ʹ�� long ���ͣ�������Ŀ˵��
        int res = 0;
        while (index < len) {
            char currChar = charArray[index];
            // 4.1 ���жϲ��Ϸ������
            if (currChar > '9' || currChar < '0') {
                break;
            }

            // ��Ŀ��˵������ֻ�ܴ洢 32 λ��С���з�����������ˣ���Ҫ��ǰ�У��ϳ��� 10 �Ժ��Ƿ�Խ��
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            // 4.2 �Ϸ�������£��ſ���ת����ÿһ�����ѷ���λ�˽�ȥ
            res = res * 10 + sign * (currChar - '0');
            index++;
        }
        return res;
    }
}

