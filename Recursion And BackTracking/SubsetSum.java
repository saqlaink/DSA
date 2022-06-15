// Subset Sum : Sum of all Subsets
// Problem Statement: Given an array print all the sum of the subset generated from it, in the increasing order.


import java.util.*;
public class Solution {
    public static ArrayList<Integer> subsetSum(int num[]) {
        // Write your code here..
        ArrayList<Integer> res = new ArrayList<>();
        subSet(0,0,num,num.length,res);
        Collections.sort(res);
        return res;
    }
    public static void subSet(int idx,int sum,int[] arr,int n,ArrayList<Integer> res){
        if(idx==n){
            res.add(sum);
            return;
        }
        subSet(idx+1,sum+arr[idx],arr,n,res);
        subSet(idx+1,sum,arr,n,res);
    }
}