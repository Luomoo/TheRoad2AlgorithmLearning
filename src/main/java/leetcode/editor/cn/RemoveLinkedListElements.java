package leetcode.editor.cn;

/**
 * @date 2023-08-25 14:21:52
 * @title [203] 移除链表元素
 **/
public class RemoveLinkedListElements {
    public static void main(String[] args) {
        Solution solution = new RemoveLinkedListElements().new Solution();
    }

    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            while (head != null && head.val == val) {
                head = head.next;
            }
            ListNode cur = head;
            while (cur != null) {
                while(cur.next!=null && cur.next.val == val){
                    cur.next = cur.next.next;
                }
                cur = cur.next;
            }
            return head;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}