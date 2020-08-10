package leetcode0810;

/**
 * @author: celeste
 * @create: 2020-08-10 16:05
 * @description:
 **/
public class Test {
    public static void main(String[] args) {
//        FindAnagrams fi = new FindAnagrams();
//        fi.findAnagrams("cbaebabacd", "abc");
//        LengthOfLongestSubstring le = new LengthOfLongestSubstring();
//        le.lengthOfLongestSubstring("au");

        TreeNode node = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        node.left = node1;
        node.right = node2;
        IsValidBST is = new IsValidBST();
        is.isValidBST(node);

    }
}
