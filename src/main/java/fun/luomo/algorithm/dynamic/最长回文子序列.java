package fun.luomo.algorithm.dynamic;

import fun.luomo.util.PrintUtil;
import org.junit.Test;

/**
 * @author gluomo
 * @date 2023/6/15 11:33
 */
public class 最长回文子序列 {
    @Test
    public void fun1(){
        String s = "bbbab";
        System.out.println(longestPalindromeSubseq(s));
    }
    public int longestPalindromeSubseq(String s){
        StringBuilder reversedString = new StringBuilder(s);
        String text2 = reversedString.reverse().toString();

        char[] arr1 = s.toCharArray();
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
