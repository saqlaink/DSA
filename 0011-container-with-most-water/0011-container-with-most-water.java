class Solution {
    public int maxArea(int[] height) {
        // int l = 0, r = height.length - 1;
        // int res = 0;
        // while(l < r){
        //     int len = r - l;
        //     int area = len * Math.min(height[r],height[l]);
        //     res = Math.max(res,area);
        //     if(height[l] < height[r]) l++;
        //     else r--;
        // }
        // return res;
        int l = 0, r = height.length - 1;
        int ans = 0;
        while(l<r){
            int len = r - l;
            int area = len * Math.min(height[l], height[r]);
            ans = Math.max(ans,area);
            if(height[l] < height[r]) l++;
            else r--;
        }
        return ans;
    }
}