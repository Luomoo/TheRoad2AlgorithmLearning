package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2023-09-05 21:40:27
 * @title [94] 二叉树的中序遍历
 **/
public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();
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
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();

            inorder(root, res);
            return res;
        }

        public void inorder(TreeNode root, List<Integer> result) {
            if (root == null) {
                return;
            }
            inorder(root.left, result);
            result.add(root.val);
            inorder(root.right, result);

        }
    }
}
// leetcode submit region end(Prohibit modification and deletion)