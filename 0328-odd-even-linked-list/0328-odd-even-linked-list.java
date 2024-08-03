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
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        // Maintain the even head
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            // Change pointers for odd list
            odd.next = odd.next.next;
            odd = odd.next;
            // Change pointers for even list
            even.next = even.next.next;
            even = even.next;
        }
        // Assign even list at the end of odd list
        odd.next = evenHead;
        return head;
    }
}