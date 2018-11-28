/**
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
*/
class Solution {
    
    int start = 0;
    int maxLen = -1;
    
    public String longestPalindrome(String s) {
        
        if(s.length()<2) return s;
        
        for(int i=0; i<s.length(); i++){
            findP(s,i,i);
            findP(s,i,i+1);
        }
        //System.out.println(start);
        //System.out.println(maxLen);
        return s.substring(start,start+maxLen);
    }
    
    public void findP(String s, int j, int k){
        while((j>=0)&&(k<=s.length()-1)&&(s.charAt(j) == s.charAt(k))){
            j--;
            k++;
        }
        int len = k-j-1;
        if(len>maxLen){
            maxLen = Math.max(maxLen,len);
            start=j+1;
        }
    }
}