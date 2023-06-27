package fun.luomo.util;

import fun.luomo.datastructure.TreeNode;

/**
 * @author gluomo
 * @date 2023/6/13 11:35
 */
public class PrintUtil {
    public static void printMatrix(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println(); // 换行
        }
    }
    public static void printBT(TreeNode treeNode) {
        if (treeNode != null) {
            System.out.print(treeNode.getVal() + " ");
            printBT(treeNode.getLeft());
            printBT(treeNode.getRight());
        }
    }
}
