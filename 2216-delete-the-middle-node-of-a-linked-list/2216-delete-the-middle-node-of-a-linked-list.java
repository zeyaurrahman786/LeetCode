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
    public ListNode deleteMiddle(ListNode head) {
         if (head.next == null) {
            return null;
        }
        ListNode tortoise = head, rabbit = head, chotaTurtoise = null;
        while (rabbit != null && rabbit.next != null) {
            rabbit = rabbit.next.next;
            chotaTurtoise = tortoise;
            tortoise = tortoise.next;
        }
        chotaTurtoise.next = chotaTurtoise.next.next;
        tortoise.next = null;
        return head;
    }
}