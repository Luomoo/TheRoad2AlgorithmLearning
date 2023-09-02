package leetcode.editor.cn;

import java.util.ArrayDeque;

/**
 * @date 2023-09-02 15:43:54
 * @title [1047] 删除字符串中的所有相邻重复项
 **/
public class RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        Solution solution = new RemoveAllAdjacentDuplicatesInString().new Solution();
        System.out.println(solution.removeDuplicates("abbaca"));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeDuplicates(String s) {
            ArrayDeque<Character> queue = new ArrayDeque<>();

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (queue.isEmpty() || queue.peek() != ch) {
                    queue.push(ch);
                } else {
                    queue.pop();
                }
            }
            String res = "";
            if (!queue.isEmpty()) {
                while (!queue.isEmpty()) {
                    res = queue.pop() + res;
                }
            }
            return res;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}