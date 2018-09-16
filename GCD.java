/**


Given 2 non negative integers m and n, find gcd(m, n)

GCD of 2 integers m and n is defined as the greatest integer g such that g is a divisor of both m and n.
Both m and n fit in a 32 bit signed integer.

Example

m : 6
n : 9

GCD(m, n) : 3 


 */

public class Solution {
    public int gcd(int A, int B) {
        int gcd = 0;
        if(A < B){
            gcd = findGCD(A,B);
        }else if(B < A){
            gcd = findGCD(B,A);
        }else{
            return A;
        }
        return gcd;
    }
    public int findGCD(int small, int big) {
        int gcd = 1;
        int count = 1;
        while(count <= small){
            if((small%count == 0)&&(big%count == 0)){
                gcd = count;
            }
            count++;
        }
        return gcd;
    }
}
