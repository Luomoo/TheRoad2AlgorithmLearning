package leetcode.editor.cn;

/**
 * @date 2023-09-08 23:09:52
 * @title [404] 左叶子之和
 **/
public class SumOfLeftLeaves {
    public static void main(String[] args) {
        Solution solution = new SumOfLeftLeaves().new Solution();
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
        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftValue = sumOfLeftLeaves(root.left);    // 左
            int rightValue = sumOfLeftLeaves(root.right);  // 右

            int midValue = 0;
            if (root.left != null && root.left.left == null && root.left.right == null) {
                midValue = root.left.val;
            }
            int sum = midValue + leftValue + rightValue;  // 中
            return sum;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}