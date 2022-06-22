// 8. Next Smaller Element
   
// Problem Statement : You are given an array 'ARR' of integers of length N. Your task is to find the next smaller element for each of the array elements.Next Smaller Element for an array element is the first element to the right of that element which has a value strictly smaller than that element. If for any array element the next smaller element does not exist, you should print -1 for that array element.



import java.util.*;
import java.io.*;

public class Solution{
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        Stack<Integer> s = new Stack<>();
       s.push(-1);
       ArrayList<Integer> ans = new ArrayList<>();
       for(int i=n-1;i>=0;i--){
           int cur = arr.get(i);
           while(s.peek()>=cur){
               s.pop();
           }
           ans.add(s.peek());
           s.push(cur);
       }
       Collections.reverse(ans);
       return ans;
    }
}
```