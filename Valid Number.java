/**
Please Note:
Note: It is intended for some problems to be ambiguous. You should gather all requirements up front before implementing one.

Please think of all the corner cases and clarifications yourself.

Validate if a given string is numeric.

Examples:

"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Return 0 / 1 ( 0 for false, 1 for true ) for this problem

Clarify the question using “See Expected Output”

Is 1u ( which may be a representation for unsigned integers valid?
For this problem, no.
Is 0.1e10 valid?
Yes
-01.1e-10?
Yes
Hexadecimal numbers like 0xFF?
Not for the purpose of this problem
3. (. not followed by a digit)?
No
Can exponent have decimal numbers? 3e0.1?
Not for this problem.
Is 1f ( floating point number with f as prefix ) valid?
Not for this problem.
How about 1000LL or 1000L ( C++ representation for long and long long numbers )?
Not for this problem.
How about integers preceded by 00 or 0? like 008?
Yes for this problem
 */
public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int isNumber(final String B) {
        String A = B.trim();
        if(A.isEmpty()) return 0;
        int result = 0;
        if(A.contains("e")){
            //System.out.println(A.split("e")[0]);
            //System.out.println(A.split("e")[1]);
            result = (A.charAt(0) != 'e' ? 1:0) * check(A.substring(0,A.indexOf("e")),true) * check(A.substring(A.indexOf("e")+1,A.length()),false);
        }else{
            result = check(A,true);
        }
        return result;
    }
    
    public int check(String A, boolean checkDecimal) {
        //System.out.println(A);
        if(A.contains("e")) return 0;
        boolean dotFlag = A.contains(".") && (A.split("\\.").length == 2);
         //System.out.println(checkDecimal);
         //System.out.println(dotFlag);
         //System.out.println(A.split("\\.").length);
        if(!checkDecimal && dotFlag) return 0;
        else{
            return isValid(A);
        }
    }
    
    public int isValid(String s) {
        for(int i=0; i<s.length(); i++){
            Character ch = s.charAt(i);
            if(((int)ch <=57) && ((int)ch >=48)){
                continue;
            }else if(ch == '.' && i != s.length()-1){
                continue;
            }else if(ch == '-' && i == 0){
                continue;
            }else{
                return 0;
            }
        }
        return 1;
    }
}
