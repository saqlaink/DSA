// Search Single Element in a sorted array
// Problem Statement: Given a sorted array of N integers, where every element except one appears exactly twice and one element appears only once. Search Single Element in a sorted array.

static int findSingleElement(int nums[]) {
        
        int low = 0;
        int high = nums.length - 2;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid % 2 == 0) {
                // Checking whether we are in right half
                if (nums[mid] != nums[mid + 1]) 
                    
                    //Shrinking the right half
                    high = mid - 1; 
                else
                    // Shrinking the left half
                    low = mid + 1; 
            } else {
                // Checking whether we are in right half
                if (nums[mid] == nums[mid + 1])
                    //Shrinking the right half
                    high = mid - 1; 
                else
                    // Shrinking the left half
                    low = mid + 1; 
            }
        }
        return nums[low];
    }