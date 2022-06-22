// 14. Online Stock Span
    
// The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate the span of the stock’s price for all n days. The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day, for which the price of the stock on the current day is less than its price on the given day. 
// ```
// Input: N = 7, price[] = [100 80 60 70 60 75 85]
// Output: 1 1 1 2 1 4 6
// ```
// Time Complexity: O(N), where 'N' is the size of array/list ‘PRICE’.
// Each index will be pushed or pop at most once, from the stack,  Both push and pop operation takes O(1) times in stack. Thus, the overall time complexity will be O(N).
// Space Complexity: O(N), where 'N' is the size of array/list ‘PRICE’.  The size of the stack ‘STK’ can go up to ‘N’. Thus overall complexity is O(N).




import java.util.*;
public class Solution {
    public static ArrayList<Integer> findSpans(ArrayList<Integer> price) {
        // Write your code here.
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        st.push(0);
        res.add(1);// Span value of first element is always 1 
        for(int i=1;i<price.size();i++){
            while(!st.isEmpty() && price.get(st.peek()) <= price.get(i)){
                st.pop();//if less values then not needed as it will take care of rest
            }
            if(st.isEmpty()){
                res.add(i+1);
            }else res.add(i-st.peek());
            st.push(i);
        }
        return res;
    }
}
```