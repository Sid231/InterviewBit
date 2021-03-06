/**

We are given head, the head node of a linked list containing unique integer values.

We are also given the list G, a subset of the values in the linked list.

Return the number of connected components in G, where two values are connected if they appear consecutively in the linked list.

Example 1:

Input: 
head: 0->1->2->3
G = [0, 1, 3]
Output: 2
Explanation: 
0 and 1 are connected, so [0, 1] and [3] are the two connected components.
Example 2:

Input: 
head: 0->1->2->3->4
G = [0, 3, 1, 4]
Output: 2
Explanation: 
0 and 1 are connected, 3 and 4 are connected, so [0, 1] and [3, 4] are the two connected components.
Note:

If N is the length of the linked list given by head, 1 <= N <= 10000.
The value of each node in the linked list will be in the range [0, N - 1].
1 <= G.length <= 10000.
G is a subset of all values in the linked list.

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
    /*
    public int numComponents(ListNode head, int[] G) {
        int result = 0;
        int flag = 0;
        ListNode node = head;
        while(node != null){
            if(gContains(node.val,G)){
                flag = 1;
            }else{
                if(flag == 1){
                    flag = 0;
                    result++;
                }
            }
            node = node.next;
        }
        if(flag == 1) return result+1;
        return result;
    }
    public boolean gContains(int val, int[] G){
        for(int i=0; i<G.length; i++){
            if(G[i] == val) return true;
        }
        return false;
    }*/
    public int numComponents(ListNode head, int[] G) {
        int res = 0;
        ListNode start = head;
        Set<Integer> set = new HashSet<>();
        for(int i : G) {
            set.add(i);
        }
        while(start.next != null) {
            if(((set.contains(start.val))&&(!set.contains(start.next.val)))) {
                res++;
            }
            start = start.next;
        }
        if(set.contains(start.val)) res++;
        return res;
    }
}