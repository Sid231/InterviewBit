/**
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode ln1, ListNode ln2) {
        if(ln1 == null && ln2 == null) return null;
        else if(ln1==null) return ln2;
        else if(ln2 == null) return ln1;
        else{
            int co = 0;
            ListNode l1 = ln1;
            ListNode l2 = ln2;
            while(!((null == l1)&&(null == l2))){
                int val1=0,val2=0;
                if(l1!=null) val1=l1.val;
                if(l2!=null) val2=l2.val;
                int sum = co + val1 + val2;
                l1.val = sum%10;
                co = sum/10;
                if((co!=0 || (l2!=null && l2.next!=null))&&(l1.next == null)){
                    ListNode temp = new ListNode(0);
                    l1.next=temp;
                }
                if(l1!=null) l1= l1.next;
                if(l2!=null) l2= l2.next;
            }
            return ln1;
        }
    }
}