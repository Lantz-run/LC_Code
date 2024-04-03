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
 * 2671. 频率跟踪器
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 请你设计并实现一个能够对其中的值进行跟踪的数据结构，并支持对频率相关查询进行应答。
 *
 * 实现 FrequencyTracker 类：
 *
 * FrequencyTracker()：使用一个空数组初始化 FrequencyTracker 对象。
 * void add(int number)：添加一个 number 到数据结构中。
 * void deleteOne(int number)：从数据结构中删除一个 number 。数据结构 可能不包含 number ，在这种情况下不删除任何内容。
 * bool hasFrequency(int frequency): 如果数据结构中存在出现 frequency 次的数字，则返回 true，否则返回 false。
 *
 *
 * 示例 1：
 *
 * 输入
 * ["FrequencyTracker", "add", "add", "hasFrequency"]
 * [[], [3], [3], [2]]
 * 输出
 * [null, null, null, true]
 *
 * 解释
 * FrequencyTracker frequencyTracker = new FrequencyTracker();
 * frequencyTracker.add(3); // 数据结构现在包含 [3]
 * frequencyTracker.add(3); // 数据结构现在包含 [3, 3]
 * frequencyTracker.hasFrequency(2); // 返回 true ，因为 3 出现 2 次
 * 示例 2：
 *
 * 输入
 * ["FrequencyTracker", "add", "deleteOne", "hasFrequency"]
 * [[], [1], [1], [1]]
 * 输出
 * [null, null, null, false]
 *
 * 解释
 * FrequencyTracker frequencyTracker = new FrequencyTracker();
 * frequencyTracker.add(1); // 数据结构现在包含 [1]
 * frequencyTracker.deleteOne(1); // 数据结构现在为空 []
 * frequencyTracker.hasFrequency(1); // 返回 false ，因为数据结构为空
 * 示例 3：
 *
 * 输入
 * ["FrequencyTracker", "hasFrequency", "add", "hasFrequency"]
 * [[], [2], [3], [1]]
 * 输出
 * [null, false, null, true]
 *
 * 解释
 * FrequencyTracker frequencyTracker = new FrequencyTracker();
 * frequencyTracker.hasFrequency(2); // 返回 false ，因为数据结构为空
 * frequencyTracker.add(3); // 数据结构现在包含 [3]
 * frequencyTracker.hasFrequency(1); // 返回 true ，因为 3 出现 1 次
 */

class FrequencyTracker {
    private final Map<Integer, Integer> cnt = new HashMap<>(); // number 的出现次数
    private final Map<Integer, Integer> freq = new HashMap<>(); // number 的出现次数对的出现次数

    public FrequencyTracker() {
    }

    public void update(int number, int delta){
        int c = cnt.merge(number, delta, Integer::sum);
        freq.merge(c - delta, -1, Integer::sum); // 去掉一个旧的cnt[number]
        freq.merge(c, 1, Integer::sum); // 添加一个新的cnt[number]
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
        return freq.getOrDefault(frequency, 0) > 0; // 至少有一个 number 出现次数恰好为 ferquency
    }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */