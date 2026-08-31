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
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int firstCritical = -1;
        int previousCritical = -1;

        int minDistance = Integer.MAX_VALUE;
        int maxDistance = -1;

        int index = 1;

        ListNode prev = head;
        ListNode curr = head.next;

        while (curr != null && curr.next != null) {

            // Check whether curr is a critical point
            boolean isCritical =
                    (curr.val > prev.val && curr.val > curr.next.val) ||
                    (curr.val < prev.val && curr.val < curr.next.val);

            if (isCritical) {

                // First critical point
                if (firstCritical == -1) {
                    firstCritical = index;
                }

                // Distance from previous critical point
                if (previousCritical != -1) {
                    int distance = index - previousCritical;
                    minDistance = Math.min(minDistance, distance);
                }

                previousCritical = index;

                // Distance between first and current critical point
                maxDistance = Math.max(maxDistance, index - firstCritical);
            }

            prev = curr;
            curr = curr.next;
            index++;
        }

        // Fewer than 2 critical points
        if (minDistance == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }

        return new int[]{minDistance, maxDistance};
    }
}