package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @date 2023-08-29 15:42:02
 * @title [454] 四数相加 II
 **/
public class FourSumIi {
    public static void main(String[] args) {
        Solution solution = new FourSumIi().new Solution();
        System.out.println(solution.fourSumCount(
                new int[]{1, 2},
                new int[]{-2, -1},
                new int[]{-1, -2},
                new int[]{0, 2}));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            Map<Integer, Integer> map = new HashMap<>();
            int res = 0;
            for (int i = 0; i < nums1.length; i++) {
                for (int j = 0; j < nums2.length; j++) {
                    int key = nums1[i] + nums2[j];
                    map.put(key, map.getOrDefault(key, 0) + 1);
                }
            }

            for (int i = 0; i < nums3.length; i++) {
                for (int j = 0; j < nums4.length; j++) {
                    res += map.getOrDefault(0 - nums3[i] - nums4[j], 0);
                }
            }

            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}