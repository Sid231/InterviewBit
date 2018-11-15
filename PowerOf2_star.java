/**
Find if Given number is power of 2 or not. 
More specifically, find if given number can be expressed as 2^k where k >= 1.

Input:

number length can be more than 64, which mean number can be greater than 2 ^ 64 (out of long long range)
Output:

return 1 if the number is a power of 2 else return 0

Example:

Input : 128
Output : 1

 */
public class Solution {
    public int power(String A) {
        java.math.BigInteger A_int = new java.math.BigInteger(A);
        int yes = 0;
        if((A_int.compareTo(java.math.BigInteger.ONE) == 0) ||
        (A_int.compareTo(java.math.BigInteger.ZERO) == 0)){
            return 0;
        }
        for(int i=0; i<A_int.bitLength(); i++){
            if(A_int.testBit(i)) yes++;
        }
        if(yes == 1) return 1;
        return 0;
    }
    
}
