package leetcode.editor.cn;

/**
 * @date 2023-09-12 22:10:51
 * @title [98] 验证二叉搜索树
 **/
public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        private long preValue = Long.MIN_VALUE;

        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (!isValidBST(root.left)) {
                return false;
            }
            if (root.val <= preValue) {
                return false;
            }
            preValue = root.val;
            return isValidBST(root.right);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}