/**

Given two strings A and B of lowercase letters, return true if and only if we can swap two letters in A so that the result equals B.

 

Example 1:

Input: A = "ab", B = "ba"
Output: true
Example 2:

Input: A = "ab", B = "ab"
Output: false
Example 3:

Input: A = "aa", B = "aa"
Output: true
Example 4:

Input: A = "aaaaaaabc", B = "aaaaaaacb"
Output: true
Example 5:

Input: A = "", B = "aa"
Output: false
 

Note:

0 <= A.length <= 20000
0 <= B.length <= 20000
A and B consist only of lowercase letters.


 */

class Solution {
    public boolean buddyStrings(String A, String B) {
        if((A != null && B != null)&&(A.length() != B.length())) return false;
        if(A.equals(B)){
            Set<String> sSet = new HashSet<String>();
            for(int i=0; i<A.length(); i++){
                sSet.add(String.valueOf(A.charAt(i)));
            }
            if(sSet.size()<A.length()) return true;
        }else{
            List<Integer> al = new ArrayList<Integer>();
            for(int i=0; i<A.length(); i++){
                if(A.charAt(i) != B.charAt(i)) al.add(i);
            }
            if(al.size() == 2 && A.charAt(al.get(0)) == B.charAt(al.get(1)) &&
              B.charAt(al.get(0)) == A.charAt(al.get(1))){
                return true;
            }
        }
        return false;
    }
}