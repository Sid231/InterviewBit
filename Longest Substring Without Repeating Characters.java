/**
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] intarr = new int[255];
        int count = 0;
        int maxCount = -1;
        int start = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            int index = (int)c;
            if(intarr[index] == 0){
                //System.out.println("ifchar"+c);
                intarr[index]++;
                count++;
            }else{
                //System.out.println("elsechar"+c);
                maxCount = Math.max(maxCount,count);
                while(((int)s.charAt(start)) != index){
                    intarr[((int)s.charAt(start))] = 0;
                    start++;
                    count--;
                }
                start++;
            }
            //System.out.println("count"+count);
            //System.out.println("maxCount"+maxCount);
        }
        return Math.max(maxCount,count);
    }
}