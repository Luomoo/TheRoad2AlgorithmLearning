package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
*  @date 2023-09-08 23:01:44
*  @title [257] 二叉树的所有路径
**/
public class BinaryTreePaths{
    public static void main(String[] args) {
       Solution solution = new BinaryTreePaths().new Solution();
    }
    public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left = left; this.right = right; } }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<String> result = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        process(root, "");
        return result;
    }

    private void process(TreeNode node, String s) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            result.add(new StringBuilder(s).append(node.val).toString());
            return;
        }
        String temp = new StringBuilder(s).append(node.val).append("->").toString();
        process(node.left, temp);
        process(node.right, temp);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}