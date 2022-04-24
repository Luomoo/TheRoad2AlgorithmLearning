package fun.luomo.datastructure;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gluomo
 * @describe 前缀树
 */
public class TrieDemo {
    @Test
    public void fun1() {
        String[] arr = {"a\\b\\c", "a\\b\\d"};
        TrieTree(arr);
    }

    public Node TrieTree(String[] arr) {
        Node head = new Node("");
        for (String s : arr) {
            String[] split = s.split("\\\\");
            Node cur = head;
            for (int i = 0; i < split.length; i++) {

                if (!cur.getNext().containsKey(split[i])) {
                    cur.getNext().put(split[i], new Node(split[i]));
                }

                cur = cur.getNext().get(split[i]);
            }
        }

        return head;
    }

    class Node {
        String string;
        Map<String, Node> next = new HashMap<>();


        public Node(String string) {
            this.string = string;
        }

        public String getString() {
            return this.string;
        }

        public void setString(String string) {
            this.string = string;
        }

        public Map<String, Node> getNext() {
            return this.next;
        }

        public void setNext(Map<String, Node> next) {
            this.next = next;
        }
    }
}
