/**
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.

 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Map<Integer,Integer> numMap = new HashMap<Integer,Integer>();
        int res=-1;
        int max=Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            if(numMap.isEmpty() || numMap.get(nums[i])==null){
                numMap.put(nums[i],1);
                max = Math.max(max,nums[i]);
            }else{
                numMap.put(nums[i],numMap.get(nums[i])+1);
            }
        }
        max++;
        if(k>0){
            while(k>0){
                max--;
                //System.out.println("max"+max);
                if(numMap.get(max) == null){
                    continue;
                }
                res = numMap.get(max);
                //System.out.println("res"+res);
                k=k-res;
            }
            return max;
        }else{
            return max-1;
        }
    }
}