// Merge two Sorted Arrays Without Extra Space
// Problem statement: Given two sorted arrays arr1[] and arr2[] of sizes n and m in non-decreasing order. Merge them in sorted order. Modify arr1 so that it contains the first N elements and modify arr2 so that it contains the last M elements.
// Example 1:
// Input: 
// n = 4, arr1[] = [1 4 8 10] 
// m = 5, arr2[] = [2 3 9]
// Output: 
// arr1[] = [1 2 3 4]
// arr2[] = [8 9 10]

// Time complexity: O(n*m)
// Space Complexity: O(1) 
static void merge(int[] arr1, int arr2[], int n, int m) {
    // code here
    int i, k;
    for (i = 0; i < n; i++) {
      // take first element from arr1 
      // compare it with first element of second array
      // if condition match, then swap
      if (arr1[i] > arr2[0]) {
        int temp = arr1[i];
        arr1[i] = arr2[0];
        arr2[0] = temp;
      }
      // then sort the second array
      // put the element in its correct position
      // so that next cycle can swap elements correctly
      int first = arr2[0];
      // insertion sort is used here
      for (k = 1; k < m && arr2[k] < first; k++) {
        arr2[k - 1] = arr2[k];
      }
      arr2[k - 1] = first;
    }
  }

// Solution 3: Gap method-
// Approach:
// Initially take the gap as (m+n)/2;
// Take as a pointer1 = 0 and pointer2 = gap.
// Run a oop from pointer1 &  pointer2 to  m+n and whenever arr[pointer2]<arr[pointer1], just swap those.
// After completion of the loop reduce the gap as gap=gap/2.
// Repeat the process until gap>0.

static void merge(int ar1[], int ar2[], int n, int m) {
  // code here 
  int gap =(int) Math.ceil((double)(n + m) / 2.0);
  while (gap > 0) {
    int i = 0;
    int j = gap;
    while (j < (n + m)) {
      if (j < n && ar1[i] > ar1[j]) {
        swap(ar1[i], ar1[j]);
      } else if (j >= n && i < n && ar1[i] > ar2[j - n]) {
        swap(ar1[i], ar2[j - n]);
      } else if (j >= n && i >= n && ar2[i - n] > ar2[j - n]) {
        swap(ar2[i - n], ar2[j - n]);
      }
      j++;
      i++;
    }
    if (gap == 1) {
      gap = 0;
    } else {
      gap =(int) Math.ceil((double) gap / 2.0);
    }
  }

Time complexity: O(n*logn)

Space Complexity: O(1)