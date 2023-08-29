package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;

/**
*  @date 2023-08-28 23:54:43
*  @title [1] 两数之和
**/
public class TwoSum{
    public static void main(String[] args) {
       Solution solution = new TwoSum().new Solution();
        System.out.println(Arrays.toString(solution.twoSum(new int[]{-3,4,3,90}, 0)));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[2];
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(target - nums[i]), i};
            }else {
                hashMap.put(nums[i], i);
            }
        }
        return new int[2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}