/**

generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]


 */

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        buildString(result,"",0,0,n);
        return result;
    }
    public void buildString(List<String> result, String str, int start, int close, int n){
        if(str.length() == 2*n){
            result.add(str);
            return;
        }
        if(start<n)
            buildString(result,str+"(",start+1,close,n);
        if(close < start)
            buildString(result,str+")",start,close+1,n);
    }
}