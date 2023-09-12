package leetcode.editor.cn;

/**
 * @date 2023-09-12 20:51:31
 * @title [654] 最大二叉树
 **/
public class MaximumBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumBinaryTree().new Solution();
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
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return traversal(nums, 0, nums.length);
        }

        private TreeNode traversal(int[] nums, int leftIndex, int rightIndex) {

            if (rightIndex - leftIndex < 1) {
                return null;
            }
            if (rightIndex - leftIndex == 1) {
                return new TreeNode(nums[leftIndex]);
            }
            int maxIndex = leftIndex;
            int maxValue = nums[maxIndex];
            for (int i = leftIndex + 1; i < rightIndex; i++) {
                if (nums[i] > maxValue) {
                    maxValue = nums[i];
                    maxIndex = i;
                }
            }

            TreeNode root = new TreeNode(maxValue);
            root.left = traversal(nums, leftIndex, maxIndex);
            root.right = traversal(nums, maxIndex + 1, rightIndex);
            return root;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}