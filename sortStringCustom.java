/**

S and T are strings composed of lowercase letters. In S, no letter occurs more than once.

S was sorted in some custom order previously. We want to permute the characters of T so that they match the order that S was sorted. More specifically, if x occurs before y in S, then x should occur before y in the returned string.

Return any permutation of T (as a string) that satisfies this property.

Example :
Input: 
S = "cba"
T = "abcd"
Output: "cbad"
Explanation: 
"a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a". 
Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.
 

Note:

S has length at most 26, and no character is repeated in S.
T has length at most 200.
S and T consist of lowercase letters only.

 */

class Solution {
    public String customSortString(String S, String T) {
        
        /*
        11ms
        
        int[] abcArr = new int[26];
        StringBuilder str = new StringBuilder(T.length());
        
        for(int i=0; i<T.length(); i++){
            //System.out.println(i);
            abcArr[T.charAt(i)-'a']++;
            //System.out.println(abcArr[T.charAt(i)-'a']);
        }
        
        
        for(int i=0; i<S.length(); i++){
            //System.out.println(i);
            //System.out.println(S.charAt(i));
            System.out.println(abcArr[S.charAt(i)-'a']);
            int size = abcArr[S.charAt(i)-'a'];
            for(int j=0; j<size; j++){
                str.append(S.charAt(i));
            }
            abcArr[S.charAt(i)-'a'] = 0;
        }
        
        for(int i=0; i<abcArr.length; i++){
            if(abcArr[i]>0){
                int size = abcArr[i];
                while(size > 0){
                    str.append((char)(i+'a'));
                    size--;
                }
            }
        }
        return str.toString();*/
        
        int[] freqOfTgt = new int[26];

        for (int i = 0; i < T.length(); i++) {
            freqOfTgt[T.charAt(i) - 'a']++;
        }

        StringBuilder sorted = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            for (int j = 0; j < freqOfTgt[S.charAt(i) - 'a']; j++) {
                sorted.append(S.charAt(i));
            }

            freqOfTgt[S.charAt(i) - 'a'] = 0;
        }

        for (int i = 0; i < 26; i++) {
            int count = 0;
            while (count < freqOfTgt[i]) {

                sorted.append((char)(i + 'a'));
                count++;
            }
        }

        return sorted.toString();
    }
}