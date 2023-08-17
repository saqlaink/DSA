class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n], right = new int[n];
        left[0] = height[0];
        for(int i=1;i<n;i++){
            left[i] = Math.max(left[i-1], height[i]);
        }
        right[n-1] = height[n-1];
        for(int i=n-2;i>=0;i--){
            right[i] = Math.max(right[i+1],height[i]);
        }
        int waterTrapped = 0;
        for(int i=0;i<n;i++){
            waterTrapped += Math.min(left[i],right[i]) - height[i];
        }
        return waterTrapped;
    }
}
// class TUF {
//     static int trap(int[] arr) {
//         int n = arr.length;
//         int prefix[] = new int[n];
//         int suffix[] = new int[n];
//         prefix[0] = arr[0];
//         for (int i = 1; i < n; i++) {
//             prefix[i] = Math.max(prefix[i - 1], arr[i]);
//         }
//         suffix[n - 1] = arr[n - 1];
//         for (int i = n - 2; i >= 0; i--) {
//             suffix[i] = Math.max(suffix[i + 1], arr[i]);
//         }
//         int waterTrapped = 0;
//         for (int i = 0; i < n; i++) {
//             waterTrapped += Math.min(prefix[i], suffix[i]) - arr[i];
//         }
//         return waterTrapped;
//     }

//     public static void main(String args[]) {
//         int arr[] = {0,1,0,2,1,0,1,3,2,1,2,1};
//         System.out.println("The duplicate element is " + trap(arr));
//     }
// }
