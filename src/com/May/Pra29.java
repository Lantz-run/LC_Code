package com.Lantz2024.May;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <p>Project: Algorithm20230913 - Pra29
 * <p>Powered by Lantz On 2024-05-29 10:27:29
 *
 * @author Lantz
 * @version 1.0
 * @Description Pra29
 * @since 1.8
 */
public class Pra29 {
}

/**
 * 2981. 找出出现至少三次的最长特殊子字符串 I
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个仅由小写英文字母组成的字符串 s 。
 *
 * 如果一个字符串仅由单一字符组成，那么它被称为 特殊 字符串。例如，字符串 "abc" 不是特殊字符串，而字符串 "ddd"、"zz" 和 "f" 是特殊字符串。
 *
 * 返回在 s 中出现 至少三次 的 最长特殊子字符串 的长度，如果不存在出现至少三次的特殊子字符串，则返回 -1 。
 *
 * 子字符串 是字符串中的一个连续 非空 字符序列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "aaaa"
 * 输出：2
 * 解释：出现三次的最长特殊子字符串是 "aa" ：子字符串 "aaaa"、"aaaa" 和 "aaaa"。
 * 可以证明最大长度是 2 。
 * 示例 2：
 *
 * 输入：s = "abcdef"
 * 输出：-1
 * 解释：不存在出现至少三次的特殊子字符串。因此返回 -1 。
 * 示例 3：
 *
 * 输入：s = "abcaba"
 * 输出：1
 * 解释：出现三次的最长特殊子字符串是 "a" ：子字符串 "abcaba"、"abcaba" 和 "abcaba"。
 * 可以证明最大长度是 1
 */


class Solution29 {
    public int maximumLength(String S) {
        char[] s = S.toCharArray();
        List<Integer>[] groups = new ArrayList[26];
        Arrays.setAll(groups, i -> new ArrayList<>());
        int cnt = 0;
        for(int i = 0; i < s.length; i++){
            cnt++;
            if(i + 1 == s.length || s[i] != s[i + 1]){
                groups[s[i] - 'a'].add(cnt); // 统计连续字符长度
                cnt = 0;
            }
        }

        int ans = 0;
        for(List<Integer> a : groups){
            if(a.isEmpty()) continue;
            a.sort(Collections.reverseOrder());
            a.add(0);
            a.add(0); // 假设还有两位空串 )
            ans = Math.max(ans, Math.max(a.get(0) - 2, Math.max(Math.min(a.get(0) - 1, a.get(1)), a.get(2))));

        }
        return ans > 0 ? ans : -1;

    }
}
