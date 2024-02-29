package com.Lantz2024.Krahets2023;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <p>Project: Algorithm20230913 - Pra09
 * <p>Powered by Lantz On 2024-02-05 17:00:11
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra09
 * @since 1.8
 */
public class Pra09 {

}

/**
 * 295. ����������λ��
 * �ѽ��
 * ����
 * ��ر�ǩ
 * �����ҵ
 * ��λ�������������б��е��м�ֵ������б�Ĵ�С��ż������û���м�ֵ����λ���������м�ֵ��ƽ��ֵ��
 *
 * ���� arr = [2,3,4] ����λ���� 3 ��
 * ���� arr = [2,3] ����λ���� (2 + 3) / 2 = 2.5 ��
 * ʵ�� MedianFinder ��:
 *
 * MedianFinder() ��ʼ�� MedianFinder ����
 *
 * void addNum(int num) ���������е����� num ��ӵ����ݽṹ�С�
 *
 * double findMedian() ���ص�ĿǰΪֹ����Ԫ�ص���λ������ʵ�ʴ���� 10-5 ���ڵĴ𰸽������ܡ�
 *
 * ʾ�� 1��
 *
 * ����
 * ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
 * [[], [1], [2], [], [3], []]
 * ���
 * [null, null, null, 1.5, null, 2.0]
 *
 * ����
 * MedianFinder medianFinder = new MedianFinder();
 * medianFinder.addNum(1);    // arr = [1]
 * medianFinder.addNum(2);    // arr = [1, 2]
 * medianFinder.findMedian(); // ���� 1.5 ((1 + 2) / 2)
 * medianFinder.addNum(3);    // arr[1, 2, 3]
 * medianFinder.findMedian(); // return 2.0
 */
class MedianFinder {
    Queue<Integer> A, B;
    public MedianFinder() {
        A = new PriorityQueue<>(); // С���ѣ��洢�ϴ��һ��
        B = new PriorityQueue<>((x, y) -> (y - x)); // �󶥶ѣ��洢��С��һ��
    }

    public void addNum(int num) {
        if(A.size() != B.size()){
            A.add(num);
            B.add(A.poll());
        }else{
            B.add(num);
            A.add(B.poll());
        }
    }

    public double findMedian() {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }
}