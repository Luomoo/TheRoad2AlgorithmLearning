package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @date 2023-08-24 11:42:19
 * @title [977] 有序数组的平方
 **/
public class SquaresOfASortedArray {
    public static void main(String[] args) {
        Solution solution = new SquaresOfASortedArray().new Solution();
        int[] nums = {-7,-3,2,3,11};
        int[] ints = solution.sortedSquares(nums);
        System.out.println(Arrays.toString(ints));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortedSquares2(int[] nums) {
            int l = 0;
            int r = nums.length - 1;
            for (int i = 0; i < nums.length; i++) {
                nums[i] = nums[i] * nums[i];
            }

            quickSort(nums, 0, r);
            return nums;
        }

        private void quickSort(int[] nums, int strat, int end) {

            if (strat > end) {
                return;
            }
            int midIndex = pointSwap(nums, strat, end);

            quickSort(nums, strat, midIndex - 1);
            quickSort(nums, midIndex + 1, end);

        }

        private int pointSwap(int[] nums, int start, int end) {
            int pivot = nums[start];
            int leftPoint = start;
            int rightPoint = end;

            while (leftPoint < rightPoint) {
                while (leftPoint < rightPoint
                        && nums[rightPoint] > pivot) {
                    rightPoint--;
                }
                while (leftPoint < rightPoint
                        && nums[leftPoint] <= pivot) {
                    leftPoint++;
                }
                if (leftPoint < rightPoint) {
                    int temp = nums[leftPoint];
                    nums[leftPoint] = nums[rightPoint];
                    nums[rightPoint] = temp;
                }
            }
            nums[start] = nums[rightPoint];
            nums[rightPoint] = pivot;

            return rightPoint;
        }

        // 双指针

        public int[] sortedSquares(int[] nums) {
            int n = nums.length - 1;
            int l = 0;
            int r = n;
            int[] res = new int[nums.length];
            while (l <= r) {
                if (Math.abs(nums[l]) > Math.abs(nums[r])) {
                    res[n] = nums[l] * nums[l];
                    l++;
                } else {
                    res[n] = nums[r] * nums[r];
                    r--;
                }
                n--;
            }

            return res;
        }

    }
// leetcode submit region end(Prohibit modification and deletion)

}