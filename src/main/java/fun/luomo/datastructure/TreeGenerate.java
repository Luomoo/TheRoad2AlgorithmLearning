package fun.luomo.datastructure;

import com.sun.source.tree.Tree;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author gluomo
 * @date 2023/6/25 14:45
 */
public class TreeGenerate {
    public TreeNode generateBinaryTreeByArray(int[] arr) {
        List<TreeNode> list = new ArrayList<>();
        TreeNode root = null;
        for (int i = 0; i < arr.length; i++) {
            TreeNode node = null;
            if (arr[i] != -1) {
                node = new TreeNode(arr[i]);
            }
            list.add(node);
            if (i == 0) {
                root = node;
            }
        }
        for (int i = 0; i * 2 + 2 < arr.length; i++) {
            TreeNode treeNode = list.get(i);
            if (treeNode != null) {
                treeNode.left = list.get(i * 2 + 1);
                treeNode.right = list.get(i * 2 + 2);
            }
        }
        return root;
    }

    public void printBT(TreeNode treeNode) {
        if (treeNode != null) {
            System.out.print(treeNode.val + " ");
            printBT(treeNode.left);
            printBT(treeNode.right);
        }
    }

    public List<Integer> levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<Integer> resList = new ArrayList<>();
        queue.push(root);
        while (queue.size() > 0) {
            TreeNode pop = queue.remove();
            resList.add(pop.val);
            if (pop.left != null) {
                queue.add(pop.left);
            }
            if (pop.right != null) {
                queue.add(pop.right);
            }
        }
        return resList;
    }

    @Test
    public void fun1() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode treeNode = generateBinaryTreeByArray(arr);
        printBT(treeNode);
        System.out.println(levelOrder(treeNode));
    }
}
