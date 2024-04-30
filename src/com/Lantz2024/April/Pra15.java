package com.Lantz2024.April;

import java.util.Arrays;

/**
 * <p>Project: Algorithm20230913 - Pra15
 * <p>Powered by Lantz On 2024-04-15 10:09:12
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra15
 * @since 1.8
 */
public class Pra15 {

}

/**
 * 706. ��ƹ�ϣӳ��
 * �ѽ��
 * ��
 * ��ر�ǩ
 * �����ҵ
 * ��ʹ���κ��ڽ��Ĺ�ϣ������һ����ϣӳ�䣨HashMap����
 *
 * ʵ�� MyHashMap �ࣺ
 *
 * MyHashMap() �ÿ�ӳ���ʼ������
 * void put(int key, int value) �� HashMap ����һ����ֵ�� (key, value) ����� key �Ѿ�������ӳ���У���������Ӧ��ֵ value ��
 * int get(int key) �����ض��� key ��ӳ��� value �����ӳ���в����� key ��ӳ�䣬���� -1 ��
 * void remove(key) ���ӳ���д��� key ��ӳ�䣬���Ƴ� key ��������Ӧ�� value ��
 *
 *
 * ʾ����
 *
 * ���룺
 * ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
 * [[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
 * �����
 * [null, null, null, 1, -1, null, 1, null, -1]
 *
 * ���ͣ�
 * MyHashMap myHashMap = new MyHashMap();
 * myHashMap.put(1, 1); // myHashMap ����Ϊ [[1,1]]
 * myHashMap.put(2, 2); // myHashMap ����Ϊ [[1,1], [2,2]]
 * myHashMap.get(1);    // ���� 1 ��myHashMap ����Ϊ [[1,1], [2,2]]
 * myHashMap.get(3);    // ���� -1��δ�ҵ�����myHashMap ����Ϊ [[1,1], [2,2]]
 * myHashMap.put(2, 1); // myHashMap ����Ϊ [[1,1], [2,1]]���������е�ֵ��
 * myHashMap.get(2);    // ���� 1 ��myHashMap ����Ϊ [[1,1], [2,1]]
 * myHashMap.remove(2); // ɾ����Ϊ 2 �����ݣ�myHashMap ����Ϊ [[1,1]]
 * myHashMap.get(2);    // ���� -1��δ�ҵ�����myHashMap ����Ϊ [[1,1]]
 *
 *
 * ��ʾ��
 *
 * 0 <= key, value <= 106
 * ������ 104 �� put��get �� remove ����
 */

class MyHashMap {
    int INF = Integer.MAX_VALUE;
    int N = 1000009;
    int[] map = new int[N];
    public MyHashMap() {
        Arrays.fill(map, INF);
    }

    public void put(int key, int value) {
        map[key] = value;
    }

    public int get(int key) {
        return map[key] == INF ? -1 : map[key];
    }

    public void remove(int key) {
        map[key] = INF;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
