/**
Given a singly linked list, determine if its a palindrome. Return 1 or 0 denoting if its a palindrome or not, respectively.

Notes:

Expected solution is linear in time and constant in space.
For example,

List 1-->2-->1 is a palindrome.
List 1-->2-->3 is not a palindrome.

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
    public int lPalin(ListNode A) {
        if(A.next == null) return 1;
        else if(A.next.next == null){
            if(A.val == A.next.val) return 1;
            else return 0;
        }
        else{
            Stack<Integer> numStack = new Stack<Integer>();
            ListNode slow = A;
            ListNode fast = A;
            while((fast.next != null)&&(fast.next.next != null)){
                numStack.push(slow.val);
                slow = slow.next;
                fast = fast.next.next;
            }
            if(fast.next != null){
                numStack.push(slow.val);
            }
            slow = slow.next;
            while(slow != null){
                if(slow.val != numStack.pop()) return 0;
                slow = slow.next;
            }
        }
        return 1;
    }
}
