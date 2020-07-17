package leetcode0703;

/**
 * author: Celeste
 * create time: 2020/7/3 1:16
 * 题目：701. 二叉搜索树中的插入操作
 * 描述：给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。
 * 返回插入后二叉搜索树的根节点。 保证原始二叉搜索树中不存在新值。
 *
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。
 * 你可以返回任意有效的结果。
 *
 */
public class InsertIntoBST {

    /**
     * 方法：如果大于当前节点向右边前进
     * 如果小于当前节点，向左边前进
     */
    public TreeNode insertIntoBSTWithDown(TreeNode root, int val){
        TreeNode insertNode = new TreeNode(val);
        if (root == null){
            root = insertNode;
        }
        if (root.val > val){
            root.left = insertIntoBSTWithDown(root.left, val);
        }
        if (root.val < val){
            root.right = insertIntoBSTWithDown(root.right, val);
        }
        return root;
    }

}
