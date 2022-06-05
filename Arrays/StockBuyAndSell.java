// Problem Statement: You are given an array of prices where prices[i] is the price of a given stock on an ith day.

// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock. Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
// Time complexity: O(n)
// Space Complexity: O(1)

import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution{
    public static int maximumProfit(ArrayList<Integer> prices){
        // Write your code here.
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for(int i=0;i<prices.size();i++){
            int val = prices.get(i);
            min = Math.min(val,min);
            profit = Math.max(profit,(val - min));
            
        }
        return profit;
    }
}