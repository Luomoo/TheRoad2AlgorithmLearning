package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @date 2023-08-24 21:14:42
 * @title [209] 长度最小的子数组
 **/
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        Solution solution = new MinimumSizeSubarraySum().new Solution();
        System.out.println(solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int size = Integer.MAX_VALUE;
            int total = 0;
            int start = 0, end = 0;
            for (int i = 0; i < nums.length; i++) {
                total += nums[i];
                while (total >= target) {
                    size = Math.min(size, end - start + 1);
                    total -= nums[start];
                    start++;
                }
                end++;
            }
            return Integer.MAX_VALUE == size ? 0 : size;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}