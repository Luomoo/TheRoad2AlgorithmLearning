package leetcode.editor.cn;

/**
 * @date 2023-09-07 00:04:43
 * @title [101] 对称二叉树
 **/
public class SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();
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
        public boolean isSymmetric(TreeNode root) {
            return compare(root.left, root.right);
        }

        private boolean compare(TreeNode left, TreeNode right) {

            if (left == null && right != null) {
                return false;
            }
            if (left != null && right == null) {
                return false;
            }
            if (left == null && right == null) {
                return true;
            }
            if (left.val != right.val) {
                return false;
            }
            boolean compareOut = compare(left.left, right.right);
            boolean compareIn = compare(left.right, right.left);

            return compareOut && compareIn;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}