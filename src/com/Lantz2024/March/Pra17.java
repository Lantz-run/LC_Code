package com.Lantz2024.March;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Project: Algorithm20230913 - Pra17
 * <p>Powered by Lantz On 2024-03-21 08:18:25
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra17
 * @since 1.8
 */
public class Pra17 {

}
/**
 * 2671. Ƶ�ʸ�����
 * �ѽ��
 * �е�
 * ��ر�ǩ
 * �����ҵ
 * ��ʾ
 * ������Ʋ�ʵ��һ���ܹ������е�ֵ���и��ٵ����ݽṹ����֧�ֶ�Ƶ����ز�ѯ����Ӧ��
 *
 * ʵ�� FrequencyTracker �ࣺ
 *
 * FrequencyTracker()��ʹ��һ���������ʼ�� FrequencyTracker ����
 * void add(int number)�����һ�� number �����ݽṹ�С�
 * void deleteOne(int number)�������ݽṹ��ɾ��һ�� number �����ݽṹ ���ܲ����� number ������������²�ɾ���κ����ݡ�
 * bool hasFrequency(int frequency): ������ݽṹ�д��ڳ��� frequency �ε����֣��򷵻� true�����򷵻� false��
 *
 *
 * ʾ�� 1��
 *
 * ����
 * ["FrequencyTracker", "add", "add", "hasFrequency"]
 * [[], [3], [3], [2]]
 * ���
 * [null, null, null, true]
 *
 * ����
 * FrequencyTracker frequencyTracker = new FrequencyTracker();
 * frequencyTracker.add(3); // ���ݽṹ���ڰ��� [3]
 * frequencyTracker.add(3); // ���ݽṹ���ڰ��� [3, 3]
 * frequencyTracker.hasFrequency(2); // ���� true ����Ϊ 3 ���� 2 ��
 * ʾ�� 2��
 *
 * ����
 * ["FrequencyTracker", "add", "deleteOne", "hasFrequency"]
 * [[], [1], [1], [1]]
 * ���
 * [null, null, null, false]
 *
 * ����
 * FrequencyTracker frequencyTracker = new FrequencyTracker();
 * frequencyTracker.add(1); // ���ݽṹ���ڰ��� [1]
 * frequencyTracker.deleteOne(1); // ���ݽṹ����Ϊ�� []
 * frequencyTracker.hasFrequency(1); // ���� false ����Ϊ���ݽṹΪ��
 * ʾ�� 3��
 *
 * ����
 * ["FrequencyTracker", "hasFrequency", "add", "hasFrequency"]
 * [[], [2], [3], [1]]
 * ���
 * [null, false, null, true]
 *
 * ����
 * FrequencyTracker frequencyTracker = new FrequencyTracker();
 * frequencyTracker.hasFrequency(2); // ���� false ����Ϊ���ݽṹΪ��
 * frequencyTracker.add(3); // ���ݽṹ���ڰ��� [3]
 * frequencyTracker.hasFrequency(1); // ���� true ����Ϊ 3 ���� 1 ��
 */

class FrequencyTracker {
    private final Map<Integer, Integer> cnt = new HashMap<>(); // number �ĳ��ִ���
    private final Map<Integer, Integer> freq = new HashMap<>(); // number �ĳ��ִ����Եĳ��ִ���

    public FrequencyTracker() {
    }

    public void update(int number, int delta){
        int c = cnt.merge(number, delta, Integer::sum);
        freq.merge(c - delta, -1, Integer::sum); // ȥ��һ���ɵ�cnt[number]
        freq.merge(c, 1, Integer::sum); // ���һ���µ�cnt[number]
    }

    public void add(int number) {
        update(number, 1);
    }

    public void deleteOne(int number) {
        if(cnt.getOrDefault(number, 0) > 0){
            update(number, -1);
        }
    }

    public boolean hasFrequency(int frequency) {
        return freq.getOrDefault(frequency, 0) > 0; // ������һ�� number ���ִ���ǡ��Ϊ ferquency
    }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */