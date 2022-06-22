// 15. Find maximum of minimum for every window size in a given array
    
// Given an integer array of size n, find the maximum of the minimum’s of every window size in the array. Note that window size varies from 1 to n.
// ```
// Input: arr[] = {10, 20, 30, 50, 10, 70, 30} 
// Output: 70, 30, 20, 10, 10, 10, 10
// The first element in the output indicates the maximum of minimums of all 
// windows of size 1. 
// Minimums of windows of size 1 are {10}, {20}, {30}, {50}, {10}, 
// {70} and {30}. Maximum of these minimums is 70
// The second element in the output indicates the maximum of minimums of all 
// windows of size 2. 
// Minimums of windows of size 2 are {10}, {20}, {30}, {10}, {10}, 
// and {30}. Maximum of these minimums is 30
// The third element in the output indicates the maximum of minimums of all 
// windows of size 3. 
// Minimums of windows of size 3 are {10}, {20}, {10}, {10} and {10}. 
// Maximum of these minimums is 20


// - Time Complexity:O(n). 
//   Every sub-task in this approach takes Linear time.
// - Auxiliary Space :O(n). 
//   Use of stack for calculating next minimum and arrays to store the intermediate results.
// ```



public class Solution {
    public static int[] maxMinWindow(int[] arr, int n) {
        // Definition: answer[i] will store the maximum of minimum of every window of size 'i'.
        int[] answer = new int[n];
        for (int i = 0; i < n; ++i) {
            answer[i] = Integer.MIN_VALUE;
        }
        int[] next = nextSmaller(arr, n);
        int[] prev = previousSmaller(arr, n);
        for (int i = 0; i < n; i++) {
            // Length of the window in which a[i] is minimum
            int length = next[i] - prev[i] - 1;
            // Update the answer[length-1] ( 0 based indexing )  with a[i]
            answer[length - 1] = Math.max(answer[length - 1], arr[i]);
        }
       // Some entries in answer[] may not be filled yet.
       // We fill them by taking maximum element from suffix starting from 'i'.
        for (int i = n - 2; i >= 0; i--) {
            answer[i] = Math.max(answer[i], answer[i + 1]);
        }
        return answer;
    }
    // Each ith position contains the index of previous smaller elements in the original array.
    private static int[] previousSmaller(int[] arr, int n) {
        int[] prev = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!s.empty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.empty()) {
                prev[i] = -1;
            } 
            else {
                prev[i] = s.peek();
            }
            s.push(i);
        }
        return prev;
    }
    // Each ith position contains the index of next smaller elements in the original array.
    private static int[] nextSmaller(int[] arr, int n) {
        Stack<Integer> s = new Stack<>();
        int[] next = new int[n];
        for (int i = n - 1; i >= 0; i--)  {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.empty()) {
                next[i] = n;
            } 
            else {
                next[i] = s.peek();
            }
            s.push(i);
        }
        return next;
    }
}
```