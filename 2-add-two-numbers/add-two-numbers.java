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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c  = 0;
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode newHead = new ListNode();
        ListNode ans = newHead;
        while(t1 != null && t2 != null){
            int temp = t1.val + t2.val + c;
            if(temp > 9)c=1;
            else c=0;
            temp = temp%10;
            ans.next = new ListNode(temp);
            ans= ans.next;
            t1=t1.next;
            t2 = t2.next;
        }
        while(t1 != null){
            int temp = t1.val+c;
            if(temp > 9)c=1;
            else c=0;
            temp=temp%10;
            ans.next = new ListNode(temp);
            ans= ans.next;
            t1=t1.next;
        }
         while(t2 != null){
            int temp = t2.val+c;
            if(temp > 9)c=1;
            else c=0;
            temp=temp%10;
            ans.next = new ListNode(temp);
            ans= ans.next;
            t2=t2.next;
        }
        if( c== 1) ans.next = new ListNode(c);
        return newHead.next;
    }
}