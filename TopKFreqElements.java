/**

Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 
 */
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> numMap = new HashMap<Integer,Integer>();
        List<Integer>[] numArray = null;
        List<Integer> result = new ArrayList();
        int max = -1;
        for(int i=0; i<nums.length; i++){
            if(numMap.isEmpty() || !numMap.containsKey(nums[i])){
                numMap.put(nums[i],1);
                if(max < 1) max = 1;
            }else{
                if(numMap.get(nums[i])+1 > max) max = numMap.get(nums[i])+1;
                numMap.put(nums[i],numMap.get(nums[i])+1);
            }
        }
        numArray = new List[max+1];
        for(int i : numMap.keySet()){
            if(numArray[numMap.get(i)] == null) numArray[numMap.get(i)] = new ArrayList<Integer>();
            numArray[numMap.get(i)].add(i);
        }
        int x = numArray.length-1;
        while(k>0 && x>0){
            if(numArray[x]!=null){
                int count = 0;
                while(count < numArray[x].size()){
                    result.add(numArray[x].get(count));
                    count++;
                    k--;
                }
            }
            x--;
        }
        return result;
    }
}