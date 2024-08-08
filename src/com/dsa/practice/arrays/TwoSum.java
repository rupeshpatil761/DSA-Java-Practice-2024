package com.dsa.practice.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	// Given an array of integers nums and an integer target, 
	// return indices of the two numbers such that they add up to target.
	
	/*
	 * Example 1: Input: nums = [2,7,11,15], target = 9 Output: [0,1] Explanation:
	 * Because nums[0] + nums[1] == 9, we return [0, 1].
	 */
	
	/*
	 * Example 2: Input: nums = [3,2,4], target = 6 Output: [1,2]
	 */

	public static void main(String[] args) {
		System.out.println("Hello from TwoSum");
		
		// input 1
		int[] nums = new int[]{2,7,11,15};
		int target = 9;
		
		// input 2
		//int[] nums = new int[]{3,2,4};
		//int target = 6;
		
		// input 3
		//int[] nums = new int[]{3,3};
		//int target = 6;
		
		//input 4
		//int[] nums = new int[]{3,2,3};
		//int target = 6;

		int[] result  = twoSumNew(nums, target);
		System.out.println("Result: " + Arrays.toString(result));
	}
	
	// solution with O(n2) -- brute force approach
    public static int[] twoSum(int[] nums, int target) {
        for(int i=0; i<nums.length;i++){
        	for(int j=i+1;j<nums.length;j++) {
        		if(nums[i] + nums[j] == target) {
        			System.out.println("Result: ["+nums[i] +","+ nums[j]+"]");
        			System.out.println("Result Indexes: ["+i +","+ j+"]");
        			return new int[]{i,j};
        		}
        	}
        }
        return null;
    }
    
    // https://www.youtube.com/watch?v=7jDS9KQEDbI
    // solution with O(n) -- using additional space - hashmap
    public static int[] twoSumNew(int[] nums, int target) {
    	 System.out.println("Input nums: " + Arrays.toString(nums) +" | target: "+target);
    	 Map<Integer, Integer> numsMap = new HashMap<>();
    	 for(int i=0; i<nums.length;i++){
    		 numsMap.put(nums[i], i);
    	 }
    	 System.out.println(numsMap +" <<<<<<<<<<< numsMap");
    	 for (int i = 0; i < nums.length; i++) {
    		 int complement = target - nums[i];
				System.out.println(complement + " <<<<<<<<<<< complement" + " | i: " + i + " nums[i]: " + nums[i]
						+ " | numsMap.get(complement): " + numsMap.get(complement));
    		 if(numsMap.containsKey(complement) && numsMap.get(complement) != i) {
    			 return new int[]{i, numsMap.get(complement)};
    		 }
    	 }
    	 return null;
    }
    
    //https://medium.com/@AlexanderObregon/solving-the-two-sum-problem-on-leetcode-a-java-walkthrough-3388ce0186e4
}