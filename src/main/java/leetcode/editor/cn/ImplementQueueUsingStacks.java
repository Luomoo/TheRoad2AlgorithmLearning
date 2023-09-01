package leetcode.editor.cn;

import java.util.Stack;

/**
 * @date 2023-09-01 21:34:19
 * @title [232] 用栈实现队列
 **/
public class ImplementQueueUsingStacks {
    public static void main(String[] args) {
        MyQueue solution = new ImplementQueueUsingStacks().new MyQueue();
        solution.push(1);
        solution.push(2);
        System.out.println(solution.peek());  // 返回 1
        System.out.println(solution.pop());   // 返回 1
        System.out.println(solution.empty()); // 返回 false
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class MyQueue {
        Stack<Integer> sIn;
        Stack<Integer> sOut;

        public MyQueue() {
            sIn = new Stack<>();
            sOut = new Stack<>();
        }

        public void push(int x) {
            sIn.push(x);
        }

        public int pop() {
            if (!sOut.isEmpty()) {
                return sOut.pop();
            } else {
                while (!sIn.isEmpty()) {
                    sOut.push(sIn.pop());
                }
                return sOut.pop();
            }
        }

        public int peek() {
            if (!sOut.isEmpty()) {
                return sOut.peek();
            } else {
                while (!sIn.isEmpty()) {
                    sOut.push(sIn.pop());
                }
                return sOut.peek();
            }
        }

        public boolean empty() {
            return sIn.isEmpty() && sOut.isEmpty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// leetcode submit region end(Prohibit modification and deletion)

}