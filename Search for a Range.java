/**
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

 */
class Solution {
    int start=0;
    int end=0;
    int mid=0;
    boolean extremeFlag=false;
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0){
            int[] result = {-1,-1};
            return result;
        }
        start=0;
        end=nums.length-1;
        int index = 0;
        if(nums.length==1){
            if(nums[0] == target) index=0;
            else index=-1;
        }else index = findNum(target,nums);
        int[] result = new int[2];
        //System.out.println("index="+index);
        if(index == -1){
            result[0]=-1;
            result[1]=-1;
        }else{
            result[0]=findExtremeLeft(nums,0,index,nums[index]);
            result[1]=findExtremeRight(nums,index,nums.length-1,nums[index]);
        }
        return result;
    }
    
    public int findExtremeLeft(int[] nums, int start, int end, int target){
        if(start+1 < end){
            int mid = (start+end)/2;
            if(nums[mid]!=target){
                start=mid;
                return findExtremeLeft(nums,start,end,target);
            }else{
                end=mid;
                return findExtremeLeft(nums,start,end,target);
            }
        }else{
            if(nums[start]==target) return start;
            else return end;
        }
    }
    
    public int findExtremeRight(int[] nums, int start, int end, int target){
        if(start+1 < end){
            int mid = (start+end)/2;
            if(nums[mid]!=target){
                end=mid;
                return findExtremeRight(nums,start,end,target);
            }else{
                start=mid;
                return findExtremeRight(nums,start,end,target);
            }
        }else{
            if(nums[end]==target) return end;
            else return start;
        }
    }
    
    public int findNum(int target, int[] nums){
        if(start+1 != end){
            mid = (start+end)/2;
            if(nums[mid]>target){
                end = mid;
                return findNum(target,nums);
            }else if(nums[mid]<target){
                start = mid;
                return findNum(target,nums);
            }else return mid;
        }else{
            extremeFlag=true;
            if(nums[start]==target) return start;
            else if(nums[end]==target) return end;
            else{
                extremeFlag=false;
                return -1;
            }
        }
    }
}