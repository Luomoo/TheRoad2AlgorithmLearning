package leetcode.editor.cn;

/**
 * @date 2023-08-30 21:14:21
 * @title [541] 反转字符串 II
 **/
public class ReverseStringIi {
    public static void main(String[] args) {
        Solution solution = new ReverseStringIi().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseStr(String s, int k) {
            char[] ch = s.toCharArray();
            for (int i = 0; i < ch.length; i += (2 * k)) {
                if (i + k <= s.length()) {
                    reverse(ch, i, i + k - 1);
                } else {
                    // 3. 剩余字符少于 k 个，则将剩余字符全部反转。
                    reverse(ch, i, s.length() - 1);
                }

            }
            return new String(ch);
        }

        public void reverse(char[] ch, int i, int j) {
            for (; i < j; i++, j--) {
                char temp = ch[i];
                ch[i] = ch[j];
                ch[j] = temp;
            }

        }
    }
// leetcode submit region end(Prohibit modification and deletion)
}