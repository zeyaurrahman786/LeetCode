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
    public ListNode modifiedList(int[] nums, ListNode head) {
        boolean set[] = new boolean[(int) 1e5 + 1];
        for (int num : nums) {
            set[num] = true;
        }
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            if (set[cur.val] == true) {
                if (prev == null) {
                    head = head.next;
                    cur.next = null;
                    cur = head;
                } else {
                    prev.next = cur.next;
                    cur.next = null;
                    cur = prev.next;
                }
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}