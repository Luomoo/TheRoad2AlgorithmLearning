package fun.luomo.simple;

import fun.luomo.datastructure.TreeNode;
import fun.luomo.utils.ListNodeUtils;
import fun.luomo.utils.TreeNodeUtils;

import java.util.*;

/**
 * @author luomo
 * @date 2021/3/10 10:56
 */
public class 从上到下打印二叉树32 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        List<List<Integer>> res = new ArrayList();

        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode poll = queue.poll();
                temp.add(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if(poll.right!=null){
                    queue.add(poll.right);
                }
            }
            res.add(temp);
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeUtils.stringToTreeNode("[3,9,20,null,null,15,7]");
        List<List<Integer>> lists = new 从上到下打印二叉树32().levelOrder(treeNode);
        System.out.println(lists);

    }
}
