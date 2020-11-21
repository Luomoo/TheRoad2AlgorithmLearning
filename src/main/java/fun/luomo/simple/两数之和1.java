package fun.luomo.simple;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luomo
 * @date 2020/11/21 22:54
 * 本题思路：
 * 1. 通过遍历数组先固定一个数字，之后用目标数字与其余数字相减如等于0则固定的数字和当前数字符合两数之和
 *      因为循坏两次所以 复杂度：O(n^2)
 * 2.可以通过Map将匹配target的复杂度缩小为O(1)所以优化后的复杂度为O(n)
 */
public class 两数之和1 {

    @Test
    public void fun1() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        twoSum1(nums, target);
        twoSum2(nums, target);
    }

    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
