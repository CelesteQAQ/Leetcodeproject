package leetcode0625;

/**
 * author: Celeste
 * create time: 2020/6/25 1:37
 */
public class Test {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.LeftTreeNode = new TreeNode(2);
        node.RightTreeNode = new TreeNode(3);
        InorderTraversal inorder = new InorderTraversal();
        inorder.inorderTraversal(node);
    }
}
