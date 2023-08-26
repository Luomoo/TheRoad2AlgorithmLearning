package leetcode.editor.cn;

/**
 * @date 2023-08-26 21:22:30
 * @title [142] 环形链表 II
 **/
public class LinkedListCycleIi {
    public static void main(String[] args) {
        Solution solution = new LinkedListCycleIi().new Solution();
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode fastPoint = head;
            ListNode slowPoint = head;

            while (fastPoint.next != null || slowPoint.next != null) {
                fastPoint = fastPoint.next;
                slowPoint = slowPoint.next.next;

                if (fastPoint == slowPoint) {
                    fastPoint = head;
                    while(fastPoint != slowPoint){
                        fastPoint = fastPoint.next;
                        slowPoint = slowPoint.next;
                    }
                    return fastPoint;
                }
            }
            return null;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}