/**


Given a positive integer N, print all the integers from 1 to N. But for multiples of 3 print “Fizz” instead of the number and for the multiples of 5 print “Buzz”. Also for number which are multiple of 3 and 5, prints “FizzBuzz”.

Example

N = 5
Return: [1 2 Fizz 4 Buzz]


 */

public class Solution {
    public ArrayList<String> fizzBuzz(int A) {
        ArrayList<String> data = new ArrayList<String>();
        for(int i=1; i<=A; i++){
            if((i % 3 == 0) && !(i % 15 == 0)){
                data.add("Fizz");
            }
            else if((i % 5 == 0) && !(i % 15 == 0)){
                data.add("Buzz");
            }
            else if(i % 15 == 0){
                data.add("FizzBuzz");
            }else{
                data.add(Integer.toString(i));
            }
        }
        return data;
    }
}
