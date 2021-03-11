package fun.luomo.test;

import fun.luomo.datastructure.TreeNode;
import fun.luomo.utils.TreeNodeUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author luomo
 * @date 2021/3/10 10:38
 */
public class BFSDemo {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeUtils.stringToTreeNode("[3,9,20,null,null,15,7]");
        if (treeNode == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            System.out.println(poll.val);
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if(poll.right!=null){
                queue.add(poll.right);
            }
        }
    }
}
