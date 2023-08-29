package leetcode.editor.cn;

/**
 * @date 2023-08-26 15:04:01
 * @title [24] 两两交换链表中的节点
 **/
public class SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs().new Solution();
    }

    public class ListNode {
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
    class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode dummyPoint = new ListNode();
            dummyPoint.next = head;
            ListNode cur = dummyPoint;
            ListNode temp;
            ListNode first;
            ListNode second;

            while (cur.next != null && cur.next.next != null) {
                temp = cur.next.next.next;
                first = cur.next;
                second = cur.next.next;

                second.next = first;
                first.next = temp;
                cur.next = second;
                cur = first;

            }

            return dummyPoint.next;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}