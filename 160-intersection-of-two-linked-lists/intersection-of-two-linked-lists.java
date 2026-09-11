/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> seen = new HashSet<>();
        ListNode h1 = headA;
        ListNode h2 = headB;
        while(h1 != null){
            seen.add(h1);
           
            h1=h1.next;
        }
        while(h2 != null){
            if(seen.contains(h2)){
                return h2;
            }
            h2=h2.next;
        }
        return null;
    }
}