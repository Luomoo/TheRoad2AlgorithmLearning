package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2023-09-06 22:08:48
 * @title [102] 二叉树的层序遍历
 **/
public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
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
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> levelOrder(TreeNode root) {
            checkFun01(root,0);
            return res;
        }
        public void checkFun01(TreeNode node, Integer deep) {
            if (node == null) return;
            deep++;

            if (res.size() < deep) {
                //当层级增加时，list的Item也增加，利用list的索引值进行层级界定
                List<Integer> item = new ArrayList<Integer>();
                res.add(item);
            }
            res.get(deep - 1).add(node.val);

            checkFun01(node.left, deep);
            checkFun01(node.right, deep);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}