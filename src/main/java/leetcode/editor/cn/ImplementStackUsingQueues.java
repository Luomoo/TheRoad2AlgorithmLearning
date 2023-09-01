package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @date 2023-09-01 21:34:58
 * @title [225] 用队列实现栈
 **/
public class ImplementStackUsingQueues {
    public static void main(String[] args) {
        MyStack solution = new ImplementStackUsingQueues().new MyStack();
        solution.push(1);
        solution.push(2);
        System.out.println(solution.top()); // 返回 2
        System.out.println(solution.pop()); // 返回 2
        System.out.println(solution.empty()); // 返回 False
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class MyStack {
        Queue<Integer> q1;

        public MyStack() {
            q1 = new LinkedList<>();
        }

        public void push(int x) {
            q1.offer(x);
        }

        public int pop() {
            getInteger();
            return q1.poll();
        }

        private void getInteger() {
            for (int i = 0; i < q1.size() - 1; i++) {
                q1.offer(q1.poll());
            }
        }

        public int top() {
            getInteger();
            Integer poll = q1.poll();
            q1.offer(poll);
            return poll != null ? poll.intValue() : -1;
        }

        public boolean empty() {
            return q1.isEmpty();
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// leetcode submit region end(Prohibit modification and deletion)

}