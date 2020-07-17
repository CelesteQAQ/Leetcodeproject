package leetcode0701;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * author: Celeste
 * create time: 2020/7/1 2:00
 * 103. 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 记下层数，奇数就是正常，偶数就反过来
 */
public class ZigZagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null){
            return res;
        }else {
            queue.add(root);}
        int levelCount = 0;
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
            if (levelCount % 2 == 0){
                res.add(temp);
            }else {
                LinkedList<Integer> tempReverse = new LinkedList<>();
                for (int i = 0; i < temp.size(); i++){
                    tempReverse.addFirst(temp.get(i));
                }
                res.add(tempReverse);
            }
            levelCount++;
        }
        return res;
    }
}
