/**
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.

 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode A, int B) {
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        
        ListNode temp = A;
        ListNode largeTemp = large;
        ListNode smallTemp = small;
        while(temp != null){
            ListNode node = new ListNode(temp.val);
            if(temp.val < B){
                smallTemp.next = node;
                smallTemp = smallTemp.next;
            }else{
                largeTemp.next = node;
                largeTemp = largeTemp.next;
            }
            temp = temp.next;
        }
        small = small.next;
        large = large.next;
        smallTemp.next = large;
        if(small == null) return large;
        return small;
    }
}
