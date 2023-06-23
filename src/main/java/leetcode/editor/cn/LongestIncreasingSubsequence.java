package leetcode.editor.cn;

/**
 * @date 2023-06-09 19:51:05
 * @title [300] 最长递增子序列
 **/
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence().new Solution();
        int[] arr = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println(solution.lengthOfLIS(arr));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[] dp = getdp1(nums);
            return generateLIS(nums, dp).length;
        }

        public int[] getdp1(int[] arr) {
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
// leetcode submit region end(Prohibit modification and deletion)

}