package fun.luomo.simple;

import java.util.Stack;

/**
 * @author luomo
 * @date 2020/12/9 10:47
 */
public class 用两个栈实现队列 {

}
class CQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public CQueue() {
        s1 = new Stack();
        s2 = new Stack();
    }

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        if(s2.isEmpty()){
            if(s1.isEmpty()){
                return -1;
            }else{
                while(!s1.isEmpty()){
                    s2.push(s1.pop());
                }
                return s2.pop();
            }
        }else{
            return s2.pop();
        }
    }
}
