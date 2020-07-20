package leetcode0720;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: celeste
 * @create: 2020-07-20 11:47
 * @description:
 * 题目：102. 二叉树的层序遍历
 * 描述：给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 **/
public class LevelOrder {
    /**
     * 建立一个队列保存左右子树，以及循环是看队列大小
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root){
        //建立结果以及队列
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null){
            return result;
        }else {
            queue.add(root);
        }
        while (!queue.isEmpty()){
            int level = queue.size();
            List<Integer> temp = new LinkedList<>();
            while (level != 0){
                TreeNode curr = queue.poll();
                temp.add(curr.val);
                if (curr.left != null){
                    queue.add(curr.left);
                }
                if (curr.right != null){
                    queue.add(curr.right);
                }
            }
            result.add(temp);
        }
        return result;
    }
}
