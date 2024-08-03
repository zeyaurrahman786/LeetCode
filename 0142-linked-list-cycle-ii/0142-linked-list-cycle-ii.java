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
        ListNode tortoise = head;
        ListNode rabbit = head;
        while (rabbit != null && rabbit.next != null) {
            rabbit = rabbit.next.next;
            tortoise = tortoise.next;
            if (tortoise == rabbit) {
                tortoise = head;
                while (tortoise != rabbit) {
                    tortoise = tortoise.next;
                    rabbit = rabbit.next;
                }
                return tortoise;
            }
        }
        return null;
    }
}