package com.Lantz2024.April;

/**
 * <p>Project: Algorithm20230913 - Pra14
 * <p>Powered by Lantz On 2024-04-14 15:06:35
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra14
 * @since 1.8
 */
public class Pra14 {

}

/**
 * 705. ��ƹ�ϣ����
 * �ѽ��
 * ��
 * ��ر�ǩ
 * �����ҵ
 * ��ʹ���κ��ڽ��Ĺ�ϣ������һ����ϣ���ϣ�HashSet����
 *
 * ʵ�� MyHashSet �ࣺ
 *
 * void add(key) ���ϣ�����в���ֵ key ��
 * bool contains(key) ���ع�ϣ�������Ƿ�������ֵ key ��
 * void remove(key) ������ֵ key �ӹ�ϣ������ɾ���������ϣ������û�����ֵ��ʲôҲ������
 *
 * ʾ����
 *
 * ���룺
 * ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
 * [[], [1], [2], [1], [3], [2], [2], [2], [2]]
 * �����
 * [null, null, null, true, false, null, true, null, false]
 *
 * ���ͣ�
 * MyHashSet myHashSet = new MyHashSet();
 * myHashSet.add(1);      // set = [1]
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(1); // ���� True
 * myHashSet.contains(3); // ���� False ����δ�ҵ���
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(2); // ���� True
 * myHashSet.remove(2);   // set = [1]
 * myHashSet.contains(2); // ���� False �������Ƴ���
 */

class MyHashSet14 {
    boolean[] nodes = new boolean[1000009];
    // public MyHashSet() {
    //     MyHashSet MyHashSet = new MyHashSet();
    // }

    public void add(int key) {
        nodes[key] = true;
    }

    public void remove(int key) {
        nodes[key] = false;
    }

    public boolean contains(int key) {
        return nodes[key];
    }
}
