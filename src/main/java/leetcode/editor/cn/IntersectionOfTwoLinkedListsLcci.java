package leetcode.editor.cn;

/**
 * @date 2023-08-26 20:29:47
 * @title [面试题 02.07] 链表相交
 **/
public class IntersectionOfTwoLinkedListsLcci {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoLinkedListsLcci().new Solution();
    }

    public class ListNode {
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
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }
            ListNode A = headA;
            ListNode B = headB;
            int aLen = 0 , bLen = 0;
            while (A.next != null) {
                aLen++;
                A = A.next;
            }
            while (B.next != null) {
                bLen++;
                B = B.next;
            }

            A = headA;
            B = headB;

            int difLen = Math.abs(aLen - bLen);
            if (aLen > bLen) {
                for (int i = 0; i < difLen; i++) {
                    A = A.next;
                }
            }else {
                for (int i = 0; i < difLen; i++) {
                    B = B.next;
                }
            }

            while (A != null) {
                if (A == B) {
                    return A;
                }
                A = A.next;
                B = B.next;
            }
            return null;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}