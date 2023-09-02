package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @date 2023-09-02 21:59:50
 * @title [150] 逆波兰表达式求值
 **/
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        Solution solution = new EvaluateReversePolishNotation().new Solution();
        System.out.println(solution.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int evalRPN(String[] tokens) {
            Deque<Integer> stack = new LinkedList<Integer>();

            for (String s : tokens) {
                if ("+".equals(s)) {
                    stack.push(stack.pop() + stack.pop());
                } else if ("-".equals(s)) {
                    stack.push(-stack.pop() + stack.pop());
                } else if ("*".equals(s)) {
                    stack.push(stack.pop() * stack.pop());
                } else if ("/".equals(s)) {
                    Integer t1 = stack.pop();
                    Integer t2 = stack.pop();
                    stack.push(t2 / t1);
                }else {
                    stack.push(Integer.valueOf(s));
                }
            }

            return stack.pop();
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}