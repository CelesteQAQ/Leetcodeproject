package leetcode0716;

/**
 * @author: celeste
 * @create: 2020-07-16 02:18
 * @description:
 **/
public class Test {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node.right = node2;
        node2.left = node3;
        InOrderTraversal i = new InOrderTraversal();
        i.InorderTraversalWithoutRecursive(node);
    }
}
