package com.Lantz2024.April;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Project: Algorithm20230913 - Pra26
 * <p>Powered by Lantz On 2024-04-26 11:54:35
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra26
 * @since 1.8
 */
public class Pra26 {
}

/**
 * 1146. ��������
 * �ѽ��
 * �е�
 * ��ر�ǩ
 * �����ҵ
 * ��ʾ
 * ʵ��֧�����нӿڵġ��������项- SnapshotArray��
 *
 * SnapshotArray(int length) - ��ʼ��һ����ָ��������ȵ� ������ �����ݽṹ����ʼʱ��ÿ��Ԫ�ض����� 0��
 * void set(index, val) - �Ὣָ������ index ����Ԫ������Ϊ val��
 * int snap() - ��ȡ������Ŀ��գ������ؿ��յı�� snap_id�����պ��ǵ��� snap() ���ܴ�����ȥ 1����
 * int get(index, snap_id) - ����ָ���� snap_id ѡ����գ������ظÿ���ָ������ index ��ֵ��
 *
 *
 * ʾ����
 *
 * ���룺["SnapshotArray","set","snap","set","get"]
 *      [[3],[0,5],[],[0,6],[0,0]]
 * �����[null,null,0,null,5]
 * ���ͣ�
 * SnapshotArray snapshotArr = new SnapshotArray(3); // ��ʼ��һ������Ϊ 3 �Ŀ�������
 * snapshotArr.set(0,5);  // �� array[0] = 5
 * snapshotArr.snap();  // ��ȡ���գ����� snap_id = 0
 * snapshotArr.set(0,6);
 * snapshotArr.get(0,0);  // ��ȡ snap_id = 0 �Ŀ����� array[0] ��ֵ������ 5
 */

class SnapshotArray {
    private int curSnapId; // ��ǰ���ձ�ţ���ʼֵΪ 0

    // ÿ�� index ����ʷ�޸ļ�¼
    private final Map<Integer, List<int[]>> history = new HashMap<>();

    public SnapshotArray(int length) {

    }

    public void set(int index, int val) {
        history.computeIfAbsent(index, k -> new ArrayList<>()).add(new int[]{curSnapId, val});
    }

    public int snap() {
        return curSnapId++;
    }

    public int get(int index, int snap_id) {
        if(!history.containsKey(index)){
            return 0;
        }
        List<int[]> h = history.get(index);
        int j = search(h, snap_id);
        return j < 0 ? 0 : h.get(j)[1];
    }

    private int search(List<int[]> h, int x){
        int left = -1;
        int right = h.size();
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(h.get(mid)[0] <= x){
                left = mid; // ������СΪ (mid, right)
            } else{
                right = mid;
            }
        }
        return left;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
