// Kadane’s Algorithm : Maximum Subarray Sum in an Array
// Problem Statement: Given an integer array arr, find the contiguous subarray (containing at least one number) which
// has the largest sum and return its sum
// Time Complexity: O(N) 
// Space Complexity:O(1)

import java.util.* ;
import java.io.*; 

public class Solution {
	public static long maxSubarraySum(int[] arr, int n) {
        if(arr.length == 0 || arr == null ) return 0;
	    long currSum = 0;
        long maxSum = 0;
        for(int i=0;i<n;i++){
            currSum+=arr[i];
            if(currSum > maxSum){
                maxSum = currSum;
            }
            if(currSum < 0){
                currSum=0;
            }
        }
        return maxSum;
	}

}
