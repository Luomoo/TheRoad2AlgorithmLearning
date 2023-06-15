package fun.luomo.algorithm.dynamic;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author gluomo
 * @date 2023/6/8 8:33
 */
public class 信封问题 {
    int[][] arr;

    @Before
    public void init() {
        arr = new int[][]{{2, 9}, {1, 4}, {1, 1}, {4, 2}, {4, 0}, {9, 4}, {9, 100}, {7, 3}};
    }

    @Test
    public void fun1() {

        List<int[]> collect = Arrays.stream(arr).sorted((o1, o2) -> {
            if (o1[0] - o2[0] == 0) {
                return o2[1] - o1[1];
            } else {
                return o1[0] - o2[0];
            }
        }).collect(Collectors.toList());
        int[] LISArray = new int[arr.length];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            LISArray[index++] = collect.get(i)[1];
        }
        System.out.println("---");
        System.out.println(Arrays.toString(LISArray));

        最长递增子序列 lis = new 最长递增子序列();
        System.out.println(Arrays.toString(lis.list1(LISArray)));
    }

    @Test
    public void fun2() {
        List<int[]> collect = Arrays.stream(arr).sorted((o1, o2) -> {
            if (o1[0] - o2[0] == 0) {
                return o2[1] - o1[1];
            } else {
                return o1[0] - o2[0];
            }
        }).collect(Collectors.toList());
        int[] LISArray = new int[arr.length];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            LISArray[index++] = collect.get(i)[1];
        }

        System.out.println(Arrays.toString(LISArray));

        int[] dp = new int[LISArray.length];
        int[] ends = new int[LISArray.length];
        dp[0] = 1;
        ends[0] = LISArray[0];
        int right = 0;
        int l = 0;
        int r = 0;
        int m = 0;

        for (int i = 1; i < LISArray.length; i++) {
            l = 0;
            r = right;
            while (l <= r) {
                m = (l + r) / 2;
                if (LISArray[i] > ends[m]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            right = Math.max(right, l);
            ends[l] = LISArray[i];
            dp[i] = l + 1;
        }

        System.out.println(dp[LISArray.length-1]);

    }
}
