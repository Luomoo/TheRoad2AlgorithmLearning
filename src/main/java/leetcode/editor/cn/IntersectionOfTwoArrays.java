package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @date 2023-08-28 22:06:55
 * @title [349] 两个数组的交集
 **/
public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArrays().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for(int i = 0; i < nums2.length; i++){
            if (set.contains(nums2[i])) {
                resSet.add(nums2[i]);
            }
        }
        return resSet.stream().mapToInt(item -> item).toArray();
    }
}
// leetcode submit region end(Prohibit modification and deletion)

}