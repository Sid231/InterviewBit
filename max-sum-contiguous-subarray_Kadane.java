/*

Question:

Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example:

Given the array [-2,1,-3,4,-1,2,1,-5,4],

the contiguous subarray [4,-1,2,1] has the largest sum = 6.

For this problem, return the maximum sum.



Hint:

Let us say Ai, Ai+1 … Aj is our optimal solution.

Note that no prefix of the solution will ever have a negative sum.

Let us say Ai … Ak prefix had a negative sum.

Sum ( Ai Ai+1 … Aj ) = Sum (Ai … Ak) + Sum(Ak+1 … Aj)

Sum ( Ai Ai+1 … Aj) - Sum(Ak+1 … Aj) = Sum(Ai … Ak)

Now, since Sum(Ai … Ak) < 0,

Sum (Ai Ai+1 … Aj) - Sum (Ak+1 … Aj) < 0

which means Sum(Ak+1 … Aj ) > Sum (Ai Ai+1 … Aj)

This contradicts the fact that Ai, Ai+1 … Aj is our optimal solution.

Instead, Ak+1, Ak+2 … Aj will be our optimal solution.

Similarily, you can prove that for optimal solution, it is always good to include a prefix with positive sum.

Try to come up with a solution based on the previous 2 facts.


*/
public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxSubArray(final List<Integer> A) {
        int maxsum_tillnow = A.get(0);
        int maxsum_possible = 0;
        
        if(A.size() > 1){
            for(int i=1; i<A.size(); i++){
                maxsum_possible += A.get(i);
                if(maxsum_tillnow < maxsum_possible){
                    maxsum_tillnow = maxsum_possible;
                }
                if(maxsum_possible < 0){
                    maxsum_possible = 0;
                }
            }
        }
        
        return maxsum_tillnow;
    }
}
