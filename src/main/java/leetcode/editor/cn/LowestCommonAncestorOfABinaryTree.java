package leetcode.editor.cn;

/**
 * @date 2023-09-26 17:45:13
 * @title [236] 二叉树的最近公共祖先
 **/
public class LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinaryTree().new Solution();
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q) {
                return root;
            }
            TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
            TreeNode rightNode = lowestCommonAncestor(root.right, p, q);

            if (leftNode == null && rightNode == null) {
                return null;
            } else if (leftNode != null && rightNode == null) {
                return leftNode;
            } else if (leftNode == null && rightNode != null) {
                return rightNode;
            } else{
                return root;
            }

        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}