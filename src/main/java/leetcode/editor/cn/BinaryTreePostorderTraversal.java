package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2023-09-05 21:35:40
 * @title [145] 二叉树的后序遍历
 **/
public class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal().new Solution();
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
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();

            postorder(root, res);
            return res;
        }

        public void postorder(TreeNode root, List<Integer> result) {
            if (root == null) {
                return;
            }
            postorder(root.left, result);
            postorder(root.right, result);
            result.add(root.val);

        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}