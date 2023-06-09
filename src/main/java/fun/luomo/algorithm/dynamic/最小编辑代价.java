package fun.luomo.algorithm.dynamic;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author gluomo
 * @date 2022/9/26 13:55
 */
public class 最小编辑代价 {
    @Test
    public void fun1() {
        System.out.println(minDistance("asdcf", "hasdfc"));
    }

    /**
     * 1. (i-1)和(j-1)位置可以搞定
     * 1. (i-1)和(j-1)相同            dp[i-1][j-1]
     * 2. (i-1)和(j-1)不同            dp[i-1][j-1]+replace
     * 2. (i-1)和(j-1)位置无法搞定
     * 1. (i-1)比(j-1)多一个           dp[i-1][j]+delete
     * 2. (i-1)比(j-1)少一个           dp[i][j-1]+add
     *
     * @return
     */
    public int minDistance(String word1, String word2) {
        int row = word2.length() + 1;
        int list = word1.length() + 1;
        System.out.println("row" + row);
        System.out.println("list" + list);
        int[][] dp = new int[row][list];

        for (int i = 1; i < list; i++) {
            dp[0][i] = i;
        }
        for (int j = 1; j < row; j++) {
            dp[j][0] = j;
        }
        printArray(row, dp);

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < list; j++) {
                if (word2.charAt(i - 1) == word1.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }

            }
        }

        printArray(row, dp);

        return dp[row-1][list-1];
    }

    private static void printArray(int len, int[][] dp) {
        System.out.println("-------------------");
        for (int i = 0; i < len; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println("-------------------");
    }
}
