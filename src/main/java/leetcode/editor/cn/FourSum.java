package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @date 2023-08-29 20:04:39
 * @title [18] 四数之和
 **/
public class FourSum {
    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {

                if (nums[i] > 0 && nums[i] > target) {
                    return res;
                }
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                for (int j = i + 1; j < nums.length; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }

                    int left = j + 1;
                    int right = nums.length - 1;
                    while (left < right) {
                        int sum = nums[i] + nums[j] + nums[left] + nums[right];
                        if (sum < target) {
                            left++;
                        } else if (sum > target) {
                            right--;
                        } else {
                            res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            while (left < right && nums[right] == nums[right - 1]) {
                                right--;
                            }
                            while (right > left && nums[left] == nums[left + 1]) {
                                left++;
                            }

                            left++;
                            right--;
                        }
                    }

                }
            }

            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}