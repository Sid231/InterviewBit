/**
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
 */
class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==0) return -1;
        int pivotIndex = findPivot(nums);
        if(pivotIndex==nums.length-1){
            return findByBS(nums,target);
        }else{
            if(target<=nums[pivotIndex] && target>=nums[0]){
                return findByBS(Arrays.copyOfRange(nums, 0, pivotIndex+1),target);
            }
            int res = findByBS(Arrays.copyOfRange(nums, pivotIndex, nums.length),target);
            if(res == -1) return -1;
            else return res+pivotIndex;
        }
        
    }
    public int findByBS(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        int mid=0;
        while(start+1<end){
            mid=(start+end)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                end=mid;
            }else{
                start=mid;
            }
        }
        if(nums[start]==target) return start;
        else if(nums[end]==target) return end;
        else return -1;
    }
    
    public int findPivot(int[] nums){
        if(nums[nums.length-1]>nums[0]) return nums.length-1;
        int start=0;
        int end=nums.length-1;
        int mid=0;
        while(start+1<end){
            mid=(start+end)/2;
            if(nums[mid]>nums[mid+1]&&nums[mid]>nums[mid-1]){
                return mid;
            }else if(nums[mid]>nums[end]){
                start=mid;
            }else{
                end=mid;
            }
        }
        return start;
    }
}