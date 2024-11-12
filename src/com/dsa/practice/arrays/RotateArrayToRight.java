package com.dsa.practice.arrays;

import java.util.Arrays;

public class RotateArrayToRight {
	
	// https://www.youtube.com/watch?v=ENcnXXiRT6E -- to rotate right -- leetcode 189

	// https://leetcode.com/problems/rotate-array/
	
	//time complexity is o(n)
	
	public static void main(String[] args) {
		
		int[] array = {1,2,3,4,5};  // output: 4,5,1,2,3
		int k = 2;
		
		System.out.println("RotateArrayToRight by k : " + k +" | before rotate:  "+Arrays.toString(array));
		
		rotate(array, k);
		
		System.out.println("RotateArrayToRight by k : " + k +" | after rotate:  "+Arrays.toString(array));
	}
	
	private static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        // full rotate
        reverseArray(nums, 0, n-1);

        // 0 to k rotate
        reverseArray(nums, 0, k-1);

        // k to n-1 rotate
        reverseArray(nums, k, n-1);
    }

    private static void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start]  = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}

/*
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

Example 1:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]


Example 2:
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

*/