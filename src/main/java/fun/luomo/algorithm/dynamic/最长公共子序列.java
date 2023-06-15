package fun.luomo.algorithm.dynamic;

import fun.luomo.util.PrintUtil;
import org.junit.Test;

/**
 * @author gluomo
 * @date 2023/6/15 10:44
 */
public class 最长公共子序列 {
    @Test
    public void fun1() {
        int[] arr1 = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] arr2 = {4, 2, 8, 5, 10, 21, 3, 7, 6};
        String text1 = "abcde", text2 = "ace";
        // System.out.println(longestCommonSubsequence1(arr1, arr2));
        System.out.println(longestCommonSubsequence2(text1, text2));
    }

    // arr1[i] ==  arr2[j] -> dp[i-1][j-1] + 1
    //
    public int longestCommonSubsequence1(int[] arr1, int[] arr2) {
        int[][] dp = new int[arr1.length + 1][arr2.length + 1];
        for (int i = 1; i < arr1.length; i++) {
            for (int j = 1; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        PrintUtil.printMatrix(dp);
        return dp[arr1.length][arr2.length];
    }

    public int longestCommonSubsequence2(String text1, String text2) {
        char[] arr1 = text1.toCharArray();
        char[] arr2 = text2.toCharArray();

        int[][] dp = new int[arr1.length + 1][arr2.length + 1];
        for (int i = 1; i <= arr1.length; i++) {
            for (int j = 1; j <= arr2.length; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        PrintUtil.printMatrix(dp);
        return dp[arr1.length][arr2.length];
    }
}
