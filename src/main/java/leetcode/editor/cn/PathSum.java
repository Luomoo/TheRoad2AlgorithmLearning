package leetcode.editor.cn;

/**
 * @date 2023-09-09 20:01:03
 * @title [112] 路径总和
 **/
public class PathSum {
    public static void main(String[] args) {
        Solution solution = new PathSum().new Solution();
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
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return false;
            }
            targetSum -= root.val;
            if (root.left == null && root.right == null) {
                return targetSum == 0;
            }
            if (root.left != null) {
                boolean left = hasPathSum(root.left, targetSum);
                if(left){
                    return true;
                }
            }
            if (root.right != null) {
                boolean right = hasPathSum(root.right, targetSum);
                if(right){
                    return true;
                }
            }
            return false;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}