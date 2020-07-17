package leetcode0701;

/**
 * author: Celeste
 * create time: 2020/7/1 1:07
 */
public class Test {
    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        node0.left = node1;
        node0.right = node2;
        node2.left = node3;
        node2.right = node4;
        ZigZagLevelOrder z = new ZigZagLevelOrder();
        z.zigzagLevelOrder(node0);
    }
}
