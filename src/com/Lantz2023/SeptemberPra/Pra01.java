package com.Lantz2023.SeptemberPra;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * ��һ���������飬������������䳤�ȡ�
 * �磺[5,2,3,8,1,9] ����� 2,3,8 ����Ϊ 3 ��ע�⣺�������������ο������ǻ���ݴ��������������֣�
 * ����������
 * ��һ����������n��(1<=n<=10000)��ʾ����Ĵ�С �ڶ��и���n������a.(-1e9<=a<=1e9)
 */
public class Pra01 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str_0 = scan.nextLine().trim();
        int n = Integer.parseInt(str_0);


        String str_1 = scan.nextLine();
        String[] line_list_1 = str_1.trim().split(" ");
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < line_list_1.length; i++) {
            arr.add(Integer.parseInt(line_list_1[i]));
        }


        scan.close();

        int result = solution(n, arr);

        System.out.println(result);

    }

    public static int solution(int n, ArrayList<Integer> arr) {
        int result = 0;

        /**
         * �㷨˼�룺
         * ����������䣬����ÿһ��Ԫ�أ�������Ƿ����ǰһ��Ԫ�أ�����ǵĻ����Ǿ�˵�����ڵ��������ڣ�����������������ǣ�������currentLengthΪ1
         * ��ΪcurrentLength��������¼��������ĳ��ȵģ������ڱ�����һ���µĵ������䣬��Ҫ����currentLength, �Ӷ���ʼͳ���µĵ�������
         * �ڱ����Ĺ����У����ϸ���maxLength��ȷ�����ǵ�����֪�����������
         */
        // TODO: ���ڴ˱�д����

        int maxLength = 1; // ������¼���ĵ�������
        int currentLength = 1; // ������¼��ǰ�ĵ�������

        if (arr.size() <= 1){
            return arr.size();
        }

        arr.add(Integer.MIN_VALUE);
        // �������䣬�����ĵ�������
        for (int i = 1; i < n; i++) {
            // �ж�Ԫ�صĴ�С
            if (arr.get(i).compareTo(arr.get(i-1))>0 ){
                currentLength++;

            }else {
                maxLength = Math.max(maxLength, currentLength); // ����ȷ���µ�����������
                currentLength = 1; // ����Ϊ1
            }

        }
        result = Math.max(result, maxLength); // ȷ������������

        return result;
    }
}
