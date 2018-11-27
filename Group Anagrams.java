/**
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.

 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int count = 0;
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String,List<String>> hashCMap = new HashMap<String,List<String>>();
        for(int i=0; i<strs.length; i++){
            String hs = getHashCode(strs[i]);
            //System.out.println("hs="+hs+" str="+strs[i]);
            if(hashCMap.isEmpty() || !hashCMap.containsKey(hs)){
                List<String> tList = new ArrayList<String>();
                tList.add(strs[i]);
                hashCMap.put(hs,tList);
            }else{
                List<String> tList = hashCMap.get(hs);
                tList.add(strs[i]);
                hashCMap.put(hs,tList);
            }
        }
        for(Map.Entry<String,List<String>> entryMap : hashCMap.entrySet()){
            result.add(entryMap.getValue());
        }
        return result;
    }
    
    public String getHashCode(String i){
        String res = "";
        int i_n[] = new int[26];
        
        for(int x=0; x<i.length(); x++){
            i_n[(int)i.charAt(x) - (int)'a'] = 1;
        }
        for(int x=0; x<26; x++){
            if(i_n[x]>0){
                while(i_n[x] > 0){
                    res = res + String.valueOf((char) (x+(int)'a'));
                    i_n[x]--;
                }
            }
        }
        return res;
    }
}