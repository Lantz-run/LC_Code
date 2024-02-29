package com.Lantz2023.OctoberPra;

import java.util.Scanner;

/**
 * 2023.10.25 LeetCode�ھ��⣺������
 *
 * ����һ������ x ����� x ��һ���������������� true �����򣬷��� false ��
 *
 * ��������ָ���򣨴������ң��͵��򣨴������󣩶�����һ����������
 *
 * ���磬121 �ǻ��ģ��� 123 ���ǡ�
 *
 *
 * ʾ�� 1��
 *
 * ���룺x = 121
 * �����true
 *
 * ʾ�� 2��
 *
 * ���룺x = -121
 * �����false
 * ���ͣ��������Ҷ�, Ϊ -121 �� ���������, Ϊ 121- �����������һ����������
 *
 * ʾ�� 3��
 *
 * ���룺x = 10
 * �����false
 * ���ͣ����������, Ϊ 01 �����������һ����������
 */
public class Pra09 {
    public static void main(String[] args) {

        Solution09 solution09 = new Solution09();
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        boolean result = solution09.isPalindrome(x);
        System.out.println(result);
    }
}

class Solution09 {
    public boolean isPalindrome(int x) {
/*        �ⷨһ�����ַ����������
        String reserveStr = (new StringBuilder(x+"")).reverse().toString();

        return (x+"").equals(reserveStr);*/


        if (x < 0 || x % 10 == 0 && x != 0) return false; // û����0��Ϊ��ͷ������
        int reserveNumber = 0;
        while (x > reserveNumber){
            reserveNumber = reserveNumber * 10 + x % 10;
            x  /= 10;
        }

        return x == reserveNumber || x == reserveNumber / 10; // ���˾���"121"���ӵ���һ��


    }
}

// 2023.10.26 ���̵�һ��
class Solution09_1{
    public boolean isPalindrome(int x){
        if (x < 0 || x % 10 == 0 && x != 0) return false;
        int num = 0;
        while (x > num){
            num = num * 10 + x % 10;
            x /= 10;
        }

        return x == num || x == num / 10;
    }
}
