/**

Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

 */

class Solution {
    public int reverse(int x) {
        if(!(x<=Integer.MAX_VALUE && x>=Integer.MIN_VALUE)) return 0;
        int num = Math.abs(x);
        int revNum = 0;
        while(num != 0){
            int revNum_old = revNum;
            revNum = revNum*10 + num%10;
            if(revNum/10 != revNum_old) return 0;
            num /= 10;
        }
        if (x<0) return -1*revNum;
        return revNum;
    }
}