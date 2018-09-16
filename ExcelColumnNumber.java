/**


Given a column title as appears in an Excel sheet, return its corresponding column number.

Example:

    A -> 1
    
    B -> 2
    
    C -> 3
    
    ...
    
    Z -> 26
    
    AA -> 27
    
    AB -> 28 


 */

public class Solution {
    public int titleToNumber(String A) {
        int sum = (int)(A.charAt(A.length()-1)-65+1);
        for(int i=A.length()-2; i>=0; i--){
            if(A.charAt(i)>=65 && A.charAt(i)<=90){
                sum += (int)(A.charAt(i)-65+1)*(Math.pow(26,A.length()-1-i));
            }else{
                return 0;
            }
        }
        return sum;
    }
}

