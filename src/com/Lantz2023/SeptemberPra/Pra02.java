package com.Lantz2023.SeptemberPra;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 题目描述：给定大小为n的整数序列A. 现在会有q次询问，询问子区间的不同整数的数量
 *
 * 输入描述：第一行输入整数n，q.(1<=n,q<=1000)
 *         第二行输入n个整数.(1<=a<=100000)
 *         以下q行每行两个整数l,r。(1<=l,r<=100000)
 *
 * 输出描述：输出区间内的整数数量。
 */

public class Pra02 {

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);

            String str_0 = scan.nextLine();
            String[] line_list_0 = str_0.trim().split(" ");
            ArrayList<Integer> arr_temp = new ArrayList<>();
            for(int i = 0; i < line_list_0.length; i++){
                arr_temp.add(Integer.parseInt(line_list_0[i]));
            }

            int n = arr_temp.get(0);
            int q = arr_temp.get(1);

            String str_2 = scan.nextLine();
            String[] line_list_2 = str_2.trim().split(" ");
            ArrayList<Integer> nums = new ArrayList<>();
            for(int i = 0; i < line_list_2.length; i++){
                nums.add(Integer.parseInt(line_list_2[i]));
            }


            ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
            for(int i = 0; i < q; i++){
                String str_3 = scan.nextLine();
                String[] line_list_3 = str_3.trim().split(" ");
                ArrayList<Integer> temp_3 = new ArrayList<>();
                for(int j = 0; j < line_list_3.length; j++){
                    temp_3.add(Integer.parseInt(line_list_3[j]));
                }
                arr.add(temp_3);
            }


            scan.close();

            ArrayList<Integer> result = solution(n, q, nums, arr);


            for (int i = 0; i < result.size(); i++){
                System.out.println(result.get(i));
            }


        }

        public static ArrayList<Integer> solution(int n, int q, ArrayList<Integer> nums, ArrayList<ArrayList<Integer>> arr){
            ArrayList<Integer> result = new ArrayList<>();

            // TODO: 请在此编写代码
            for (ArrayList<Integer> a : arr
                 ) {
                // 定义左边界和右边界
                int left = a.get(0);
                int right = a.get(1);
                // 创建集合，存储子区间内不同整数
                Set<Integer> numbers = new HashSet<>();

                // 遍历子区间
                for (int i = left - 1; i < right; i++) {
                    numbers.add(nums.get(i));
                }
                result.add(numbers.size());
            }

            return result;
        }
    }

