/**
 * Difficulty: Medium
 * Tags: Linked List, Math
 * Favorite: No
 * Details: Runtime: 1 ms, faster than 100.00% of Java online submissions for Add Two Numbers.
            Memory Usage: 39.2 MB, less than 97.46%% of Java online submissions for Add Two Numbers.
 */

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
    // Linked List --> Time: O(max(m, n)) Space: O(max(m,n))
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0, curSum = 0, x = 0, y = 0; 
        while (l1 != null || l2 != null) {
            x = (l1 != null) ? l1.val : 0;
            y = (l2 != null) ? l2.val : 0;
            curSum = x + y + carry;
            carry = curSum / 10;
            curr.next = new ListNode(curSum % 10);
            curr = curr.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(1);
        }

        return dummyHead.next;
    }
}