package leetcode0808;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: celeste
 * @create: 2020-08-08 15:58
 * @description:
 * 题目：95. 不同的二叉搜索树 II
 * 描述：给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 * 二叉搜索树左小于根，根小于右
 **/
public class GenerateTrees {
    /**
     * 如何选择跟节点以及左子树以及右子树
     * 遍历一遍将每个数字都当成根节点，然后左右子树再递归处理
     */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return null;
        }
        return generate(1, n);
    }

    private List<TreeNode> generate(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end){
            result.add(null);
        }
        for (int i = start; i <= end; i++){
            //返回的只有一个，但是每个子树应该都不一样

            List<TreeNode> left = generate(start, i - 1);
            List<TreeNode> right = generate(i + 1, end);
            for (int j = 0; j < left.size(); j++){//但是当left和right有可能是null，null没有size
                for (int k = 0; k < right.size(); k++){
                    TreeNode newNode = new TreeNode(i);//注意需要在for循环里面建新的节点，要不然返回的都是前面建过的
                    newNode.left = left.get(j);
                    newNode.right = right.get(k);
                    result.add(newNode);
                }
            }
        }
        return result;
    }
}
