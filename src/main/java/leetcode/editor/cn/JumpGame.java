package leetcode.editor.cn;

/**
 * @date 2023-06-23 10:40:48
 * @title [55] 跳跃游戏
 **/
public class JumpGame {
    public static void main(String[] args) {
        Solution solution = new JumpGame().new Solution();
        System.out.println(solution.canJump(new int[]{2,3,1,1,4}));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canJump(int[] nums) {
            int maxCoverage =  nums[0];
            int max = nums.length - 1;
            for (int i = 0; i <= maxCoverage; i++) {
                maxCoverage = Math.max(maxCoverage, i + nums[i]);
                if (maxCoverage >= max) {
                    return true;
                }
            }
            return false;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}