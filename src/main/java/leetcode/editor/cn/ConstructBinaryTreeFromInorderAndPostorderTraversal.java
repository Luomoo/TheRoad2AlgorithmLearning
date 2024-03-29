package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @date 2023-09-09 20:50:13
 * @title [106] 从中序与后序遍历序列构造二叉树
 **/
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
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
        Map<Integer, Integer> map;

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            map = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }

            return findNode(inorder, 0, inorder.length, postorder, 0, postorder.length);  // 前闭后开
        }

        public TreeNode findNode(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
            if (inBegin >= inEnd || postBegin >= postEnd) {
                return null;
            }
            int rootIndex = map.get(postorder[postEnd - 1]);
            TreeNode root = new TreeNode(inorder[rootIndex]);
            int lenOfLeft = rootIndex - inBegin;
            root.left = findNode(inorder, inBegin, rootIndex,
                    postorder, postBegin, postBegin + lenOfLeft);
            root.right = findNode(inorder, rootIndex + 1, inEnd,
                    postorder, postBegin + lenOfLeft, postEnd - 1);

            return root;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}