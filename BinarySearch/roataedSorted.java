// Search Element in a Rotated Sorted Array
// Problem Statement: There is an integer array nums sorted in ascending order (with distinct values). Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums. We need to search a given element in a rotated sorted array.


static int search(int arr[], int target) {
        int low = 0, high = arr.length - 1; //<---step 1

        while (low <= high) { //<--- step 2
            int mid = (low + high) >> 1; //<----step 3
            if (arr[mid] == target)
                return mid; // <---step 4

            if (arr[low] <= arr[mid]) { //<---step 5
                if (arr[low] <= target && arr[mid] >= target)
                    high = mid - 1; //<---step 6 
                else
                    low = mid + 1; //<---step 7
            } else { //<---step 7
                if (arr[mid] <= target && target <= arr[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -1; //<---step 8
    }