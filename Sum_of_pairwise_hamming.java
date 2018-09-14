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