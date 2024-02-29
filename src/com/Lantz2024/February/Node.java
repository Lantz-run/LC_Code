package com.Lantz2024.February;

import java.util.List;

/**
 * <p>Project: Algorithm20230913 - Node
 * <p>Powered by Lantz On 2024-02-17 10:04:59
 *
 * @author Lantz
 * @version 1.0
 * @Description Node
 * @since 1.8
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
