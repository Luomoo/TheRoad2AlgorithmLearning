package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
*  @date 2023-09-26 15:04:33
*  @title [501] 二叉搜索树中的众数
**/
public class FindModeInBinarySearchTree{
    public static void main(String[] args) {
       Solution solution = new FindModeInBinarySearchTree().new Solution();
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
        List<Integer> resList;
        int maxCount;
        int count;
        TreeNode preNode;
        public int[] findMode(TreeNode root) {
            resList = new ArrayList<>();
            maxCount = 0;
            count = 0;
            preNode = null;
            find(root);
            int[] res = new int[resList.size()];
            for (int i = 0; i < resList.size(); i++) {
                res[i] = resList.get(i);
            }
            return res;
        }

        private void find(TreeNode root) {
            if(root == null){
                return;
            }
            find(root.left);

            if (preNode == null || root.val != preNode.val) {
                count = 1;
            }else {
                count++;
            }
            if(count>maxCount){
                resList.clear();
                resList.add(root.val);
                maxCount = count;
            } else if (count == maxCount) {
                resList.add(root.val);
            }
            preNode = root;
            find(root.right);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}