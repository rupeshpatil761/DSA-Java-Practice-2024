package com.dsa.practice.amex;

import java.util.Arrays;

public class MinimumMovesToNonNegativeSum {
	// AMX -Round 2
	/**
	 * Given an unsorted array of integers, with even amount of elements, 
	 * where sum of all integers is always greater than zero, 
	 * find how many elements (at a minimum) should be moved from the beginning of array to its end, 
	 * so that sum of elements in the first half of array is not negative. 
	 */
	
	private static int minMovesToNonNegativeSum(int[] arr) {
		System.out.println("Slide window apporach 2| Input nums: " + Arrays.toString(arr));
        int n = arr.length;
        int half_n = n / 2;

        // Step 1: Calculate the initial sum of the first half
        int initialSum = 0;
        for (int i = 0; i < half_n; i++) {
            initialSum += arr[i];
        }

        // Step 2: If the sum is already non-negative, return 0
        if (initialSum >= 0) {
        	System.out.println("Minimum moves required: " + 0 + " \n");
            return 0;
        }

        // Step 3: Move elements and check the sum
        int currentSum = initialSum;
        int moves = 0;

        for (int i = 0; i < half_n; i++) {
            moves++;
            currentSum -= arr[i];  // Remove the moved element from the sum
            currentSum += arr[half_n + i];  // Add the corresponding element from the second half

            // Check if the current sum is non-negative
            if (currentSum >= 0) {
            	System.out.println("Minimum moves required: " + moves + " \n");
                return moves;
            }
        }
        System.out.println("Minimum moves required: " + moves + " \n");
        return moves; // This should never be reached if inputs are guaranteed
    }


    public static void main(String[] args) {
       // minMovesToNonNegativeSum(new int[]{3, -1, 2, -2, 5, -3}); // Output: 0
       // minMovesToNonNegativeSum(new int[]{1, -2, -3, 4, 5, -1}); // Output: 1
       // minMovesToNonNegativeSum(new int[]{10, -5, -5, -5, 20, -10}); // Output: 0
        minMovesToNonNegativeSum(new int[]{-3, -2, 4, 5, 1, 2}); // Output: 1
        //minMovesToNonNegativeSum(new int[]{1, 2, 3, -6, 5, 6}); // Output: 1
    }
}