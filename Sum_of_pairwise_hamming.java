/*

Hamming distance between two non-negative integers is defined as the number of positions at which the corresponding bits are different.

For example,

HammingDistance(2, 7) = 2, as only the first and the third bit differs in the binary representation of 2 (010) and 7 (111).

Given an array of N non-negative integers, find the sum of hamming distances of all pairs of integers in the array.
Return the answer modulo 1000000007.

Let f(x, y) be the hamming distance defined above.

A=[2, 4, 6]

We return,
f(2, 2) + f(2, 4) + f(2, 6) + 
f(4, 2) + f(4, 4) + f(4, 6) +
f(6, 2) + f(6, 4) + f(6, 6) = 

0 + 2 + 1
2 + 0 + 1
1 + 1 + 0 = 8


*/
public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int hammingDistance(final List<Integer> A) {
        int ans = 0; // Initialize result 
  
        // traverse over all bits 
        for (int i = 0; i < 32; i++) { 
              
            // count number of elements  
            // with i'th bit set 
            int count = 0; 
              
            for (int j = 0; j < A.size(); j++) 
                if ((A.get(j) & (1 << i)) == 0) 
                    count++; 
  
            // Add "count * (n - count) * 2"  
            // to the answer 
            // System.out.println(count);
            ans += (count * (A.size() - count) * 2); 
        } 
          
        return ans; 
    }
}
