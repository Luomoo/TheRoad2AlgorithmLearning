package leetcode.editor.cn;

import java.util.ArrayDeque;

/**
 * @date 2023-09-04 15:00:05
 * @title [239] 滑动窗口最大值
 **/
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            int n = nums.length;
            int[] res = new int[n - k + 1];
            int index = 0;
            for (int i = 0; i < n; i++) {
                while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                    deque.poll();
                }
                while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                    deque.pollLast();
                }
                deque.offer(i);

                if (i >= k - 1) {
                    res[index++] = nums[deque.peek()];
                }
            }

            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}