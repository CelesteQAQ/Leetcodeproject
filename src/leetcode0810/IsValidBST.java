package leetcode0810;

import java.util.*;

/**
 * @author: celeste
 * @create: 2020-08-10 20:12
 * @description:
 * 题目：98. 验证二叉搜索树
 * 描述：给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 **/
public class IsValidBST {
    /**
     * 判断是否是二叉搜索树：一、前序遍历是有序并且是从小到大排列
     * 二、一个一个节点判断是否符合左《 根 《 右
     * 前序遍历完后判断：
     * 这是前序！搞错了，根是第二位访问
     */
    public boolean isValidBST(TreeNode root){
        List<Integer> pre = new LinkedList<>();
        preOrder(root, pre);
        for (int i = 0; i < pre.size(); i++){

            if (i < pre.size() - 1 && pre.get(i) > pre.get(i + 1)){
                return false;
            }
        }
        return true;
    }

    private void preOrder(TreeNode root, List<Integer> pre) {
        if (root == null){
            return;
        }
        if (root.left != null){
            preOrder(root.left, pre);
        }
        pre.add(root.val);
        if (root.right != null){
            preOrder(root.right, pre);
        }
    }
    /**
     * 简化版本的中序遍历
     * 因为不需要将数字记下比较，而是在原本记下的位置直接比较
     */
    public boolean isValidBST_1(TreeNode root){
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, Boolean> map = new HashMap<>();
        Integer pre = null;
        stack.push(root);
        map.put(root, false);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if (map.get(cur)){//第二次弹出就是读取比较的时候
                if (pre != null && cur.val <= pre){
                    return false;
                }else {
                    pre = cur.val;
                }
            }else {
                if (cur.right != null){
                    stack.push(cur.right);
                    map.put(cur.right, false);
                }
                stack.push(cur);
                map.put(cur, true);
                if (cur.left != null) {
                    stack.push(cur.left);
                    map.put(cur.left, false);
                }
            }

        }
        return true;
    }

    /**
     * 更加简洁的 LeetCode 答案
     */
    public boolean isValidBST_3(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        double inorder = -Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inorder) return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

    /**
     * 直接判断是否为二叉搜索树,使用队列记下
     * 需要的是完全小于，而不是局部小于,所以是使用递归的传递参数将每个最大最小值都带上
     */
    public boolean isValidBST_2(TreeNode root){
        if (root == null){
            return true;
        }
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer lower, Integer upper) {
        if (root == null){
            return true;
        }
        int val = root.val;

        if (!helper(root.left, lower, upper)) return false;
        if (!helper(root.right, val, upper)) return false;
        if (lower != null && val <= lower) return false;//这个位置没有关系，是因为是从往下传递，不是从下往上传递
        if (upper != null && val >= upper) return false;
        return true;
    }
}
