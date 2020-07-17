package leetcode0702;

/**
 * author: Celeste
 * create time: 2020/7/2 0:10
 */
public class Test {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        node.left = node1;
        node.right = node2;
        IsValidBST isValid = new IsValidBST();
    }
}
