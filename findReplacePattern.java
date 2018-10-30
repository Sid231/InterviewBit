/**

You have a list of words and a pattern, and you want to know which words in words matches the pattern.

A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.

(Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.)

Return a list of the words in words that match the given pattern. 

You may return the answer in any order.

 

Example 1:

Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
Output: ["mee","aqq"]
Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}. 
"ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
since a and b map to the same letter.

 */

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<String>();
        Map<String,String> wordMap = null;
        Map<String,String> wordRevMap = null;
        int flag = 0;
        for(int i = 0; i<words.length; i++){
            String word = words[i];
            if(word.length() == pattern.length()){
                wordMap = new HashMap<String,String>();
                wordRevMap = new HashMap<String,String>();
                flag = 0;
                for(int j=0; j<pattern.length(); j++){
                    if(wordMap.isEmpty()){
                        wordMap.put(String.valueOf(pattern.charAt(j)),
                                     String.valueOf(word.charAt(j)));
                        wordRevMap.put(String.valueOf(word.charAt(j)),
                                     String.valueOf(pattern.charAt(j)));
                        continue;
                    }
                    if((wordMap.get(String.valueOf(pattern.charAt(j))) == null) && 
                      wordRevMap.get(String.valueOf(word.charAt(j))) == null){
                        wordMap.put(String.valueOf(pattern.charAt(j)),
                                     String.valueOf(word.charAt(j)));
                        wordRevMap.put(String.valueOf(word.charAt(j)),
                                     String.valueOf(pattern.charAt(j)));
                    }else if(((wordMap.get(String.valueOf(pattern.charAt(j))) != null) && 
                      wordRevMap.get(String.valueOf(word.charAt(j))) == null) || 
                            (wordMap.get(String.valueOf(pattern.charAt(j))) == null) && 
                      wordRevMap.get(String.valueOf(word.charAt(j))) != null){
                        flag = 1;
                        break;
                    }else{
                        //System.out.println("p="+pattern.charAt(j));
                        //System.out.println("w="+word.charAt(j));
                        if((!wordMap.get(String.valueOf(pattern.charAt(j)))
                           .equals(String.valueOf(word.charAt(j)))) && 
                        (!wordRevMap.get(String.valueOf(word.charAt(j)))
                           .equals(String.valueOf(pattern.charAt(j))))){
                            flag = 1;
                            break;
                        }
                    }
                }
                //System.out.println("flag="+flag);
                if(flag == 0){
                    result.add(word);
                }
            }
        }
        return result;
    }
}