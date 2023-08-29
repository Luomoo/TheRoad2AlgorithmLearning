package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * @date 2023-08-28 22:29:23
 * @title [202] 快乐数
 **/
public class HappyNumber {
    public static void main(String[] args) {
        Solution solution = new HappyNumber().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isHappy(int n) {
            Set<Integer> set = new HashSet<>();

            while (n != 1 && !set.contains(n)) {
                set.add(n);
                n = nextNumber(n);
            }
            return n == 1;
        }

        private int nextNumber(int n) {
            int res = 0;
            while (n > 0) {
                int temp = n % 10;
                res += temp * temp;
                n = n / 10;
            }
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}