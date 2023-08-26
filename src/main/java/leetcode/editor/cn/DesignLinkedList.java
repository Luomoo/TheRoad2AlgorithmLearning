package leetcode.editor.cn;

/**
 * @date 2023-08-25 15:46:27
 * @title [707] 设计链表
 **/
public class DesignLinkedList {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new DesignLinkedList().new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);    // 链表变为 1->2->3
        System.out.println(myLinkedList.get(1));    // 返回 2
        myLinkedList.deleteAtIndex(1);              // 现在，链表变为 1->3
        System.out.println(myLinkedList.get(1));    // 返回 3
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class MyLinkedList {

        int size;
        ListNode head;

        public MyLinkedList() {
            size = 0;
            head = new ListNode(0);
        }

        public int get(int index) {
            if (index < 0 && index >= size) {
                return -1;
            }
            ListNode temp = head;
            for (int i = 0; i <= index; i++) {
                temp = temp.next;
            }
            return temp.val;
        }

        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            if (index < 0) {
                index = 0;
            }
            size++;

            ListNode temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            ListNode listNode = new ListNode(val);
            listNode.next = temp.next;
            temp.next = listNode;


        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            size--;
            if (index == 0) {
                head = head.next;
                return;
            }
            ListNode temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
// leetcode submit region end(Prohibit modification and deletion)

}