package leetcode.editor.cn;

/**
 * @date 2023-08-30 23:02:46
 * @title [151] 反转字符串中的单词
 **/
public class ReverseWordsInAString {
    public static void main(String[] args) {
        Solution solution = new ReverseWordsInAString().new Solution();
        System.out.println(solution.reverseWords(" the sky is                  blue "));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            // 1. 删除多余空格
            StringBuilder sb = removeSpace(s);
            // 2.反转整个字符串
            reverseString(sb, 0, sb.length() - 1);
            // 3.反转各个单词
            reverseEachWord(sb);
            return sb.toString();
        }

        private void reverseEachWord(StringBuilder sb) {
            int start = 0;
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == ' ') {
                    reverseString(sb, start, i - 1);
                    start = i + 1;
                }
            }
            if (start != sb.length()-1) {
                reverseString(sb, start, sb.length()-1);
            }

        }


        private void reverseString(StringBuilder sb, int start, int end) {
            while (start < end) {
                char temp = sb.charAt(start);
                sb.setCharAt(start, sb.charAt(end));
                sb.setCharAt(end, temp);
                start++;
                end--;
            }

        }

        private StringBuilder removeSpace(String s) {
            StringBuilder sb = new StringBuilder();
            s = s.trim();
            for (char c : s.toCharArray()) {
                if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(c);
                }
            }
            return sb;
        }

    }
// leetcode submit region end(Prohibit modification and deletion)

}