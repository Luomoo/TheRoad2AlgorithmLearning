package leetcode.editor.cn;

/**
 * @date 2023-08-30 20:13:05
 * @title [344] 反转字符串
 **/
public class ReverseString {
    public static void main(String[] args) {
        Solution solution = new ReverseString().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void reverseString(char[] s) {
            int l = 0;
            int r = s.length - 1;

            while (l < r) {
                swap(s,l, r);
                l++;
                r--;
            }

        }

        private void swap(char[] s,int l, int r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}