package leetcode0702;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * author: Celeste
 * create time: 2020/7/2 0:03
 *
 * 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsValidBST {
    /**
     * 使用当前节点作为判断标准，左边要在（NULL，根）之间，右边要在（根，NULL)之间
     * @param root
     * @return
     */
    public boolean isValidBSTWithRecursive(TreeNode root){
        if (root == null) return true;
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer low, Integer upper) {
        if (root == null) return true;

        int val = root.val;

        if (low != null && val <= low) return false;
        if (upper != null && val >= upper) return false;

        if (!helper(root.left, low, val)) return false;
        if (!helper(root.right, val, upper)) return false;
        return true;
    }

    /**
     * 中序遍历顺序的结果是递增的
     */

    public boolean isValidBSTWithInOrder(TreeNode root){
        if (root == null) return true;
        List<Integer> result = new LinkedList<>();
        inOrder(root, result);
        for (int i = 0; i < result.size() - 1; i++){
            if (result.get(i) >= result.get(i + 1)) return false;
        }
        return true;

    }
    public void inOrder(TreeNode root, List<Integer> result){
        if (root == null) return;
        if (root.left != null){
            inOrder(root.left, result);
        }
        result.add(root.val);
        if (root.right != null){
            inOrder(root.right, result);
        }
    }

    public boolean isValidBSTWithColorMap(TreeNode root){
        HashMap<TreeNode, Boolean> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null){
            stack.push(root);
            map.put(root, false);
        }
        int previous = 0;
        while (!stack.isEmpty()){
            TreeNode curNode = stack.pop();
            if (!map.get(curNode)){
                if (curNode.right != null){
                    stack.push(curNode.right);
                    map.put(curNode.right, false);}
                stack.push(curNode);
                map.put(curNode, true);
                if (curNode.left != null){
                    stack.push(curNode.left);
                    map.put(curNode.left, false);}
            }else {
                if (previous >= curNode.val) return false;
                else {
                    previous = curNode.val;
                }
            }
        }
        return true;
    }

    public boolean isValidBSTWithStack(TreeNode root){
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        Integer previous = null;
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (previous != null && cur.val <= previous) return false;
            else previous = cur.val;
            cur = cur.right;
        }
        return true;

    }

}
