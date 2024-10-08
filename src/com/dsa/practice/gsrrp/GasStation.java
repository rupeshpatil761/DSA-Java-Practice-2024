package com.dsa.practice.gsrrp;

public class GasStation {
	
	// https://leetcode.com/problems/gas-station/description/
	
	//The time complexity is O(N), where N is the number of stations, making it suitable for large inputs. 
	public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0, currentBalance = 0;
        int startIndex = 0;

        for (int i = 0; i < gas.length; i++) {
        	System.out.println("i: "+i);
        	System.out.println("startIndex: "+startIndex);
        	totalGas += gas[i];
            totalCost += cost[i];
            currentBalance += gas[i] - cost[i];

            System.out.println("Total gas: "+totalGas);
            System.out.println("Total cost: "+totalCost);
            System.out.println("gas[i] - cost[i] = currentBalance: "+currentBalance);
            // If the balance is negative, reset the start index
            if (currentBalance < 0) {
                startIndex = i + 1;
                currentBalance = 0;
                System.out.println("Reseting startIndex and currentBalance | new startIndex: "+startIndex);
            }
            System.out.println("--------------------");
        }

        // Check if the total gas is enough to cover the total cost
        return totalGas >= totalCost ? startIndex : -1;
    }

    public static void main(String[] args) {
        //int[] gas = {1, 2, 3, 4, 5};
        //int[] cost = {3, 4, 5, 1, 2}; // output should be 3
    	 int[] gas = {2, 3, 4};
         int[] cost = {3, 4, 3};  // output should be -1
        int result = canCompleteCircuit(gas, cost);
        System.out.println("result i.e. minimum starting gas station’s index : "+result);  // Output: 3
    }
}
