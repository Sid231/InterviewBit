/**


Determine whether an integer is a palindrome. Do this without extra space.

A palindrome integer is an integer x for which reverse(x) = x where reverse(x) is x with its digit reversed.
Negative numbers are not palindromic.

Example :

Input : 12121
Output : True

Input : 123
Output : False


 */

public class Solution {
    public int isPalindrome(int A) {
        int count = 0;
        while(A/(int)Math.pow(10,count) != 0){
            count++;
        }
        count--;
        //System.out.println("count="+count);
        while(count > 0){
            if((A%10) == (int)(A/(Math.pow(10,count)))){
                A = A % (int)Math.pow(10,count);
                A = A/10;
                count = count - 2;
            }else{
                return 0;
            }
        }
        return 1;
    }
}
