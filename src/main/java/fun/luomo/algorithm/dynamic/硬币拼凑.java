package fun.luomo.algorithm.dynamic;

import fun.luomo.util.PrintUtil;
import org.junit.Test;

/**
 * @author gluomo
 * @date 2023/6/13 11:20
 */
public class 硬币拼凑 {

    @Test
    public void fun1() {
        int[] coinsArr = {2, 3, 5, 10};
        int[] ticketArr = {2, 8, 12};

        System.out.println(moneyWays(coinsArr, ticketArr, 10));

    }

    public int moneyWays(int[] coinsArr, int[] ticketArr, int money) {
        int[][] cdp = coinsDp(coinsArr, money);
        int[][] tdp = ticketDp(ticketArr, money);
        if (coinsArr.length == 0) {
            return tdp[tdp.length - 1][money - 1];
        }
        if (coinsArr.length == 0) {
            return cdp[cdp.length - 1][money - 1];
        }
        int res = 0;
        for (int i = 0; i < money; i++) {
            res += (cdp[cdp.length - 1][i] * tdp[tdp.length - 1][money - i]);
        }

        return res;
    }

    public int[][] coinsDp(int[] coinsArr, int money) {
        int[][] dp = new int[coinsArr.length][money + 1];
        for (int i = 0; i < coinsArr.length; i++) {
            dp[i][0] = 1;
        }
        if (coinsArr[0] < money) {
            dp[0][coinsArr[0]] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < money; j++) {
                dp[i][j] = dp[i - 1][j] + (j - coinsArr[i] > 0 ? dp[i - 1][j - coinsArr[i]] : 0);
            }
        }
        return dp;
    }

    public int[][] ticketDp(int[] ticketArr, int money) {
        int[][] dp = new int[ticketArr.length][money + 1];
        for (int i = 0; i < ticketArr.length; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; ticketArr[0] * j <= money; j++) {
            dp[0][j * ticketArr[0]] = 1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <= money; j++) {
                dp[i][j] = dp[i - 1][j] + (j - ticketArr[i] >= 0 ? dp[i][j - ticketArr[i]] : 0);
            }
        }
        // PrintUtil.printMatrix(dp);
        return dp;
    }
}
