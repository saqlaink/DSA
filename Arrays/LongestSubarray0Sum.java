// Length of the longest subarray with zero Sum
// Problem Statement: Given an array containing both positive and negative integers, we have to find the length of the longest subarray with the sum of all elements equal to zero.

// Time Complexity: O(N), as we are traversing the array only once

// Space Complexity: O(N), in the worst case we would insert all array elements prefix sum into our hashmap



int maxLen(int A[], int n){
    HashMap<Integer, Integer> mpp = new HashMap<Integer, Integer>();

    int maxi = 0;
    int sum = 0; 

    for(int i = 0;i<n;i++) {

        sum += A[i]; 

        if(sum == 0) {
            maxi = i + 1; 
        }
        else {
            if(mpp.get(sum) != null) {

                maxi = Math.max(maxi, i - mpp.get(sum)); 
            }
            else {

                mpp.put(sum, i); 
            }
        }
    }
    return maxi; 
    }