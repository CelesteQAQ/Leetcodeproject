package leetcode0630;

/**
 * author: Celeste
 * create time: 2020/6/30 0:09
 * 124. 二叉树中的最大路径和
 * 给定一个非空二叉树，返回其最大路径和。
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。
 * 该路径至少包含一个节点，且不一定经过根节点。
 *
 * 怎么处理
 * 一个节点的最大路径和是什么
 * 左子树的最大路径和，右子树的最大路径和，左子树最大单边和以及右子树最大单边和+根
 */
public class MaxPathSum {
    public int maxPathSum(TreeNode root){
        if (root == null){
            return Integer.MIN_VALUE;
        }
        int leftMaxPathSum = maxPathSum(root.left);
        int rightMaxPathSum = maxPathSum(root.right);
        int leftSingleMaxPathSum = singleMaxPathSum(root.left);
        int rightSingleMaxPathSum = singleMaxPathSum(root.right);
        int singMaxSum = singleMaxPathSum(root);
        int max = Math.max(Math.max(leftMaxPathSum, rightMaxPathSum),
                Math.max(leftSingleMaxPathSum + root.val + rightSingleMaxPathSum, singMaxSum));
        return Math.max(max, root.val);
    }

    private int singleMaxPathSum(TreeNode node) {
        if(node == null){
            return 0;
        }
        int leftSingleMaxPathSum = (node.left == null) ? 0 : singleMaxPathSum(node.left);
        int rightSingleMaxPathSum = (node.right == null) ? 0 : singleMaxPathSum(node.right);

        return Math.max(Math.max(leftSingleMaxPathSum + node.val, rightSingleMaxPathSum + node.val), node.val);
    }

    int MAX = Integer.MIN_VALUE;

    public int maxPathSumWithDFS(TreeNode root){
        int rootGain = dfs(root);
        return MAX;
    }

    private int dfs(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftGain = Math.max(dfs(root.left), 0);
        int rightGain = Math.max(dfs(root.right), 0);
        MAX = Math.max(MAX, root.val + leftGain + rightGain);
        return root.val + Math.max(leftGain, rightGain);
    }
}
