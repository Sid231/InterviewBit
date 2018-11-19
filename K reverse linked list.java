/**
Given a singly linked list and an integer K, reverses the nodes of the

list K at a time and returns modified linked list.

 NOTE : The length of the list is divisible by K 
Example :

Given linked list 1 -> 2 -> 3 -> 4 -> 5 -> 6 and K=2,

You should return 2 -> 1 -> 4 -> 3 -> 6 -> 5

Try to solve the problem using constant extra space.
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
    public ListNode reverseList(ListNode A, int B) {
        if(B==1) return A;
        int count = 0;
        ListNode temp = A;
        ListNode result = null;
        ListNode tail = null;
        ListNode tailOld = null;
        int firstIteration = 1;
        while(temp != null){
            ListNode start = temp;
            ListNode next = start.next;
            count = 0;
            while(count < B-1){
                ListNode curNode = next;
                next = next.next;
                curNode.next = start;
                if(count == 0){
                    tailOld = tail;
                    tail = start;
                }
                start = curNode;
                count++;
            }
            if(firstIteration == 1){
                result = start;
                firstIteration = 0;
            }else{
                tailOld.next = start;
            }
            temp = next;
            //System.out.println(tail.val);
            //System.out.println("1");
        }
        tail.next = null;
        return result;
    }
}
