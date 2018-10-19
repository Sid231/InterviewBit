/**

Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 */

class Solution {
    /*
    //O(N^2)
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        int count = 1;
        for(int i=0; i<T.length-1; i++){
            count = 1;
            if(T[i]<T[i+1]) res[i] = count;
            else{
                //System.out.println("i="+i); 
                for(int j=i+1; j<T.length; j++){
                    System.out.println("j="+j); 
                    if(T[i]<T[j]){
                        res[i] = count;
                        break;
                    }
                    else count++;
                    //System.out.println("count="+count); 
                }
            }
        }
        return res;
    }*/
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<T.length; i++){
            while(!s.isEmpty() && T[s.peek()]<T[i]){
                int j = s.pop();
                res[j] = i-j;
            }
            s.push(i);
        }
        return res;
    }
}