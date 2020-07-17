package leetcode0701;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * author: Celeste
 * create time: 2020/7/1 0:52
 * 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。
 * （即逐层地，从左到右访问所有节点）。
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();//注意这个建立二维列表
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> sonNode = new LinkedList<>();
        if (root == null) {
            return res;
        }
        queue.add(root);
        List<Integer> temp = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            temp.add(cur.val);
            if (cur.left != null){
                sonNode.add(cur.left);
            }
            if (cur.right != null){
                sonNode.add(cur.right);
            }
            if (queue.isEmpty()){
                res.add(temp);
                temp = new ArrayList<>();
                queue.addAll(sonNode);
                sonNode = new LinkedList<>();
            }

        }
        return res;

    }

    public List<List<Integer>> levelOrderWithCount(TreeNode root){
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null){
            return res;
        }else {
        queue.add(root);}
        while (!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> temp = new LinkedList<>();
            for (int i = 0; i < levelNum; i++){
                TreeNode curNode = queue.poll();
                temp.add(curNode.val);
                if (curNode.left != null){
                    queue.add(curNode.left);
                }
                if (curNode.right != null){
                    queue.add(curNode.right);
                }
            }
            res.add(temp);
        }
        return res;
    }
}
