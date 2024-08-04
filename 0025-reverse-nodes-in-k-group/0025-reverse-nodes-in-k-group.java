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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }

        if (size(head) < k) {
            return head;
        }

        ListNode prev = null;
        ListNode temp = head;
        ListNode forward = null;
        int i = 0;

        while (temp != null && i < k) {
            forward = temp.next;
            temp.next = prev;
            prev = temp;
            temp = forward;
            i++;
        }

        head.next = reverseKGroup(forward, k);
        return prev;
    }

    public int size(ListNode head) {
        ListNode temp = head;
        int c = 0;
        while (temp != null) {
            c++;
            temp = temp.next;
        }
        return c;
    }
}