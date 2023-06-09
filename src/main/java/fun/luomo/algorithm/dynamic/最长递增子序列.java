package fun.luomo.algorithm.dynamic;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author gluomo
 * @date 2023/6/6 10:40
 */
public class 最长递增子序列 {

    @Test
    public void fun1() {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(Arrays.toString(list1(arr)));

    }

    public int[] list1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int[] dp = getdp1(arr);
        return generateLIS(arr, dp);
    }
    public int[] getdp1(int[] arr){
        int[] dp = new int[arr.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp;
    }

    public int[] list2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int[] dp = getdp2(arr);
        return generateLIS(arr, dp);
    }

    public int[] getdp2(int[] arr){
        return list2(arr);
    }

    public int[] generateLIS(int[] arr, int[] dp) {
        int len = 0;
        int index = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > len) {
                len = dp[i];
                index = i;
            }
        }

        int[] list = new int[len];
        list[--len] = arr[index];
        for (int i = index; i >= 0; i--) {
            if (arr[i] < arr[index] && dp[i] == dp[index] - 1) {
                list[--len] = arr[i];
                index = i;
            }
        }

        return list;
    }
}
