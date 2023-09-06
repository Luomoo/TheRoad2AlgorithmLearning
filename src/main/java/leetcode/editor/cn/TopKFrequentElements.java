package leetcode.editor.cn;

import java.util.*;

/**
 * @date 2023-09-05 22:20:20
 * @title [347] 前 K 个高频元素
 **/
public class TopKFrequentElements {
    public static void main(String[] args) {
        Solution solution = new TopKFrequentElements().new Solution();
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                queue.add(new int[]{entry.getKey(), entry.getValue()});
            }
            int[] res = new int[k];

            for (int i = 0; i < k; i++) {
                res[i] = queue.poll()[0];
            }
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}