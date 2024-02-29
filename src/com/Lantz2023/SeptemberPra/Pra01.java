package com.Lantz2023.SeptemberPra;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 给一个无序数组，求最长递增的区间长度。
 * 如：[5,2,3,8,1,9] 最长区间 2,3,8 长度为 3 （注意：测试用例仅做参考，我们会根据代码质量进行评分）
 * 输入描述：
 * 第一行输入整数n。(1<=n<=10000)表示数组的大小 第二行给出n个整数a.(-1e9<=a<=1e9)
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
         * 算法思想：
         * 遍历这个区间，对于每一个元素，检查它是否大于前一个元素，如果是的话，那就说明还在递增区间内，继续遍历；如果不是，就重置currentLength为1
         * 因为currentLength是用来记录递增区间的长度的，所以在遍历到一个新的递增区间，就要重置currentLength, 从而开始统计新的递增区间
         * 在遍历的过程中，不断更新maxLength，确保它是的是已知的最长递增区间
         */
        // TODO: 请在此编写代码

        int maxLength = 1; // 用来记录最大的递增区间
        int currentLength = 1; // 用来记录当前的递增区间

        if (arr.size() <= 1){
            return arr.size();
        }

        arr.add(Integer.MIN_VALUE);
        // 遍历区间，找最大的递增区间
        for (int i = 1; i < n; i++) {
            // 判断元素的大小
            if (arr.get(i).compareTo(arr.get(i-1))>0 ){
                currentLength++;

            }else {
                maxLength = Math.max(maxLength, currentLength); // 重新确认新的最大递增区间
                currentLength = 1; // 重置为1
            }

        }
        result = Math.max(result, maxLength); // 确定最大递增区间

        return result;
    }
}
