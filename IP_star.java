/**
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

A valid IP address must be in the form of A.B.C.D, where A,B,C and D are numbers from 0-255. The numbers cannot be 0 prefixed unless they are 0.

Example:

Given “25525511135”,

return [“255.255.11.135”, “255.255.111.35”]. (Make sure the returned strings are sorted in order)

 */
public class Solution {
    public ArrayList<String> restoreIpAddresses(String A) {
        ArrayList<String> result = new ArrayList<String>();
        if(A.length()>3 && A.length()<=12)
            getIP(A,"",0,result);
        return result;
    }
    
    public String getIP(String str, String temp, int level, ArrayList<String> result) {
        if(level != 3){
            for(int i=1; i<4 && i<str.length(); i++){
                String s = str.substring(0,i);
                if(isValid(s)){
                    getIP(str.substring(i),temp+s+".",level+1,result);
                }
            }
        }else{
            if(isValid(str)){
                result.add(temp+str);
            }
        }
        return "";
    }
    
    public boolean isValid(String A){
        if(A.length() > 3 || A.length() == 0) return false;
        else if(A.charAt(0) == '0') return A.equals("0");
        else{
            int num = Integer.parseInt(A);
            if(num >= 0 && num <= 255) return true;
        }
        return false;
    }
    
}
