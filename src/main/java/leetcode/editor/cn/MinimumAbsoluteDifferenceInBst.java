package leetcode.editor.cn;

/**
 * @date 2023-09-20 18:23:08
 * @title [530] 二叉搜索树的最小绝对差
 **/
public class MinimumAbsoluteDifferenceInBst {
    public static void main(String[] args) {
        Solution solution = new MinimumAbsoluteDifferenceInBst().new Solution();
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
        int res = Integer.MAX_VALUE;
        TreeNode pre = null;
        public int getMinimumDifference(TreeNode root) {
            traverse(root);
            return res;
        }

        private void traverse(TreeNode root) {
            if (root == null) {
                return;
            }
            traverse(root.left);
            if (pre != null) {
                res = Math.min(res, root.val - pre.val);
            }
            pre = root;
            traverse(root.right);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}