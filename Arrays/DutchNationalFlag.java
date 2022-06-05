// Sort an array of 0s, 1s and 2s
// Problem Statement: Given an array consisting of only 0s, 1s and 2s. Write a program to in-place sort the array without using inbuilt sort functions. ( Expected: Single pass-O(N) and constant space)
// Time Complexity: O(N)
// Space Complexity: O(1)

import java.util.* ;
import java.io.*; 
public class Solution {
    public static void sort012(int[] arr){
        int i=0,j=0,k=arr.length-1;
        while(i<=k){
            if(arr[i] == 2){
                swap(arr,i,k);
                k--;
            }else if(arr[i] == 1){
                i++;
            }else{
                swap(arr,i,j);
                i++;j++;
            }
        }
    }
    public static void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}