/**

Count the number of prime numbers less than a non-negative number, n.

Example:

Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.



 */
class Solution {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        
        return count;
    }
    
    public int countPrimes(int n) {
        if(n<2) return 0;
        Set<Integer> numSet = new HashSet<Integer>();
        int count = 0;
        int start = 2;
        while(start != n){
            boolean flag = false;
            if(!numSet.isEmpty()){
                for(Integer it : numSet){
                    //System.out.println(it);
                    if(start%(it) == 0){
                        flag = true;
                        break;
                    }
                }
            }
            if(!flag){
                if(checkIfPrime(start)){
                    count++;
                    numSet.add(start);
                }
            }
            start++;
        }
        return count;
    }
    public boolean checkIfPrime(int n) {
        if(n == 2 || n == 3) return true;
        else{
            int count = 2;
            while(count != (n/2)+1){
                if(n%count == 0){
                    return false;
                }
                count++;
            }
        }
        return true;
    }
}