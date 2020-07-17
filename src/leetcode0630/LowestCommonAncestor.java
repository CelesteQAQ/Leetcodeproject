package leetcode0630;

/**
 * author: Celeste
 * create time: 2020/6/30 2:00
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
 * 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大
 * （一个节点也可以是它自己的祖先）。”
 * 最近公共祖先使用DFS，从root开始遍历
 */
public class LowestCommonAncestor {
    TreeNode RES;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q){
            return root;
        }
        helper(root, p, q);
        return RES;
    }

    private boolean helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return false;
        }
        boolean lson = helper(root.left, p, q);
        boolean rson = helper(root.right, p, q);

        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))){
            RES = root;
        }

        return lson || rson || (root.val == p.val || root.val == q.val);
    }
}
