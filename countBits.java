/**

Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example 1:

Input: 2
Output: [0,1,1]
Example 2:

Input: 5
Output: [0,1,1,2,1,2]


 */
class Solution {
    public int[] countBits(int n) 
    {
        int dp[]=new int[n+1];
        
        dp[0]=0;
        
        int p=1;
        int pow=1;
        for(int i=1;i<=n;i++)
        {
            if(i==pow)
            {
            dp[i]=1;
            pow=pow<<1;
            p=1;
            }
            else
            {
                dp[i]=dp[p]+1;
                p++;
            }
        }
        
        return dp;
        
    }
}