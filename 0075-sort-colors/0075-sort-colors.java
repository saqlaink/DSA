class Solution {
    public void sortColors(int[] nums) {
        // int a = 0, b = 0, c = nums.length - 1;
        // while(b<=c){
        //     if(nums[b] == 0){
        //         nums[b] = nums[a];
        //         nums[a] = 0;
        //         a++;
        //     }
        //     if(nums[b] == 2){
        //         nums[b] = nums[c];
        //         nums[c] = 2;
        //         c--;b--;
        //     }
        //     b++;
        // }
        int a = 0, b = 0, c = nums.length - 1;
        while(b<=c){
            if(nums[b] == 0){
                nums[b] = nums[a];
                nums[a] = 0;
                a++;
            }
            if(nums[b] == 2){
                nums[b] = nums[c];
                nums[c] = 2;
                c--;b--;
            }
            b++;
        }
    }
}