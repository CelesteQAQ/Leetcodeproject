package leetcode0716;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: celeste
 * @create: 2020-07-16 18:38
 * @description:
 **/
public class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
