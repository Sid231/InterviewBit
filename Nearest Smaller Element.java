/**
Given an array, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.

More formally,

G[i] for an element A[i] = an element A[j] such that 
    j is maximum possible AND 
    j < i AND
    A[j] < A[i]
Elements for which no smaller element exist, consider next smaller element as -1.

Example:

Input : A : [4, 5, 2, 10, 8]
Return : [-1, 4, -1, 2, 2]

Example 2:

Input : A : [3, 2, 1]
Return : [-1, -1, -1]

 */
public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<Integer> numStack = new Stack<Integer>();
        int[] res = new int[A.size()];
        for(int i=A.size()-1; i>=0; i--){
            while((!numStack.isEmpty()) && (A.get(i)<A.get(numStack.peek()))){
                int n = numStack.pop();
                res[n] = A.get(i);
                if(numStack.isEmpty()) break;
            }
            numStack.push(i);
        }
        while(!numStack.isEmpty()){
            res[numStack.pop()] = -1;
        }
        for(int i=0; i<res.length; i++){
            result.add(res[i]);
        }
        return result;
    }
}
