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
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(lists == null || n == 0)return null;
        ListNode head = new ListNode();

        ListNode tail = head;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));
        for(ListNode l : lists){
            if(l != null)pq.offer(l);
        }
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            tail.next = node;
            tail=tail.next;
            if(node.next!= null){
                pq.offer(node.next);
            }
        }
        return head.next;
    }
}