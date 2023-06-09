package fun.luomo.test;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author gluomo
 * @date 2022/7/26 11:02
 */
public class Demo1 {

    @Test
    public void fun1() {
        int[] arr = {-1};
        System.out.println(maxSubArray(arr));
    }

    public int maxSubArray(int[] nums) {
        int a = 0, b = 0;
        int Max = nums[0];
        while (a <= nums.length - 1) {
            b = a;
            int cur = 0;
            while (b <= nums.length - 1) {
                Max = Math.max(Max, cur += nums[b++]);

            }
            a++;
        }

        return Max;
    }
}
