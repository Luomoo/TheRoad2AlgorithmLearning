package leetcode.editor.cn;

/**
*  @date 2023-08-26 17:26:08
*  @title [19] 删除链表的倒数第 N 个结点
**/
public class RemoveNthNodeFromEndOfList{
    public static void main(String[] args) {
       Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
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
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyPoint = new ListNode();
        dummyPoint.next = head;

        ListNode slowPoint = dummyPoint;
        ListNode fastPoint = dummyPoint;
        for (int i = 0; i < n + 1; i++) {
            fastPoint = fastPoint.next;
        }
        while (fastPoint != null) {
            slowPoint = slowPoint.next;
            fastPoint = fastPoint.next;
        }
        slowPoint.next = slowPoint.next.next;

        return dummyPoint.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}