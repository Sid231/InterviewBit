/**

Given a balanced parentheses string S, compute the score of the string based on the following rule:

() has score 1
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.
 
 */
class Solution {

    public int scoreOfParentheses(String S) {
        return findScore(0,-1,S);
    }
    public int findScore(int index,int n,String S){
        int count = 0;
        while(index <= S.length()-1){
            if(S.charAt(index) == '('){
                n++;
            }else{
                if(S.charAt(index-1) == '(')
                    count += (int)Math.pow(2,n);
                n--;
            }
            index++;
        }
        return count;
    }
}