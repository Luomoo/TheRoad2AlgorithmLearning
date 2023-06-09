package fun.luomo.algorithm.dynamic;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author gluomo
 * @date 2023/6/8 8:33
 */
public class 信封问题 {
    @Test
    public void fun1() {
        int[][] arr = {{2, 9}, {1, 4}, {1, 1}, {4, 2}, {4, 0}, {9, 4}, {9, 100}, {7, 3}};
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
        for (int[] ints : collect) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("---");
        System.out.println(Arrays.toString(LISArray));

        最长递增子序列 lis = new 最长递增子序列();
        System.out.println(Arrays.toString(lis.generateLIS(LISArray, lis.list1(LISArray))));
    }
}
