package fun.luomo.algorithm.dynamic;

import org.junit.Test;

/**
 * @author gluomo
 * @date 2023/5/24 14:43
 */
public class 牛牛背包问题 {
    @Test
    public void fun1() {
        int[] arr = {3, 2, 5, 7, 2};
        System.out.println(way1(arr, 10));
        System.out.println(way1Dp(arr, 10));

        System.out.println(way2Dp(arr, 10));
    }
    public int way1(int[] arr, int w) {
        return processWay1(arr, 0, w);
    }

    private int processWay1(int[] arr, int index, int rest) {
        if (rest < 0) {
            return -1;
        }
        if (arr.length == index) {
            return 1;
        }
        int next1 = processWay1(arr, index + 1, rest);
        int next2 = processWay1(arr, index + 1, rest - arr[index]);
        return next1 + (next2 == -1 ? 0 : next2);

    }

    int way1Dp(int[] arr, int w) {
        int[][] dp = new int[arr.length + 1][w + 1];
        for (int i = 0; i < dp[1].length; i++) {
            dp[arr.length][i] = 1;
        }
        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = 0; j < w + 1; j++) {
                // dp[i][j] = dp[i + 1][j] + ((j - arr[i] < 0 ? 0 : dp[i][j - arr[i]]));
                dp[i][j] = dp[i + 1][j] + ((j - arr[i]) < 0 ? 0 : dp[i + 1][j - arr[i]]);
            }
        }

        // print(dp);

        return dp[0][w];
    }

    private static void print(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println(); // 换行
        }
    }

    private int way2Dp(int[] arr, int w) {
        int[][] dp = new int[arr.length][w + 1];
        int total = 0;
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        if (arr[0] < w) {
            dp[0][arr[0]] = 1;
        } else {
            return 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < w + 1; j++) {
                dp[i][j] = dp[i - 1][j] + (j >= arr[i] ? dp[i - 1][(j - arr[i])] : 0);
            }
        }


        for (int i = 0; i < dp[0].length; i++) {
            total += dp[arr.length - 1][i];
        }

        // print(dp);
        return total;
    }

}
