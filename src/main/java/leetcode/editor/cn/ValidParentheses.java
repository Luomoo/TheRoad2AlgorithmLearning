package leetcode.editor.cn;

import java.util.Stack;

/**
 * @date 2023-09-02 15:28:52
 * @title [20] 有效的括号
 **/
public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("(]"));
        System.out.println(solution.isValid("]"));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '{' || c == '[' || c == '(') {
                    stack.push(c);
                } else {
                    if (c == '}') {
                        if (stack.isEmpty() || stack.pop() != '{') {
                            return false;
                        }
                    }
                    if (c == ']') {
                        if (stack.isEmpty() || stack.pop() != '[') {
                            return false;
                        }
                    }
                    if (c == ')') {
                        if (stack.isEmpty() || stack.pop() != '(') {
                            return false;
                        }
                    }
                }
            }
            return stack.isEmpty();

        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}