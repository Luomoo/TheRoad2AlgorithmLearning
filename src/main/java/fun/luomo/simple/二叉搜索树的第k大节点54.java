package fun.luomo.simple;


import fun.luomo.datastructure.TreeNode;
import fun.luomo.utils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luomo
 * @date 2021/3/8 18:07
 */
public class 二叉搜索树的第k大节点54 {
    List<Integer> list = new ArrayList<>();
    public int kthLargest(TreeNode root, int k) {
        dfs(root);
        return list.get(k-1);
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeUtils.stringToTreeNode("[3,1,4,null,2]");

        int i = new 二叉搜索树的第k大节点54().kthLargest(treeNode, 1);
        System.out.println(i);
    }
    public void dfs(TreeNode root) {
        if(root == null){
            return;
        }
        dfs(root.right);
        list.add(root.val);
        dfs(root.left);
    }
}
/*
 *     int res, k;
 *     public int kthLargest(TreeNode root, int k) {
 *         this.k = k;
 *         dfs(root);
 *         return res;
 *     }
 *     public void dfs(TreeNode root) {
 *         if(root == null){
 *             return;
 *         }
 *         dfs(root.right);
 *         if(--k == 0){
 *             res = root.val;
 *         }
 *         dfs(root.left);
 *     }
 */