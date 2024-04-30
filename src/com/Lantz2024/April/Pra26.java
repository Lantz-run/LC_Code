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
 * 1146. 快照数组
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 实现支持下列接口的「快照数组」- SnapshotArray：
 *
 * SnapshotArray(int length) - 初始化一个与指定长度相等的 类数组 的数据结构。初始时，每个元素都等于 0。
 * void set(index, val) - 会将指定索引 index 处的元素设置为 val。
 * int snap() - 获取该数组的快照，并返回快照的编号 snap_id（快照号是调用 snap() 的总次数减去 1）。
 * int get(index, snap_id) - 根据指定的 snap_id 选择快照，并返回该快照指定索引 index 的值。
 *
 *
 * 示例：
 *
 * 输入：["SnapshotArray","set","snap","set","get"]
 *      [[3],[0,5],[],[0,6],[0,0]]
 * 输出：[null,null,0,null,5]
 * 解释：
 * SnapshotArray snapshotArr = new SnapshotArray(3); // 初始化一个长度为 3 的快照数组
 * snapshotArr.set(0,5);  // 令 array[0] = 5
 * snapshotArr.snap();  // 获取快照，返回 snap_id = 0
 * snapshotArr.set(0,6);
 * snapshotArr.get(0,0);  // 获取 snap_id = 0 的快照中 array[0] 的值，返回 5
 */

class SnapshotArray {
    private int curSnapId; // 当前快照编号，初始值为 0

    // 每个 index 的历史修改记录
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
                left = mid; // 区间缩小为 (mid, right)
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
