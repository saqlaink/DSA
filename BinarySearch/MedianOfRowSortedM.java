// Median of Row Wise Sorted Matrix
// In this article we will solve the most asked coding interview problem: Median of Row Wise Sorted Matrix

// Problem Statement: Given a row-wise sorted matrix of size r*c, where r is no. of rows and c is no. of columns, find the median in the given matrix.

// Assume – r*c is odd


public static int countSmallerThanMid(int[] A, int mid, int n) {
    int l = 0, h = n - 1;
    while (l <= h) {
      int md = (l + h) >> 1;
      if (A[md] <= mid) {
        l = md + 1;
      } else {
        h = md - 1;
      }
    }
    return l;
  }
  public static int findMedian(int[][] A, int row, int col) {
    int low = 1;
    int high = 1000000000;
    int n = row;
    int m = col;
    while (low <= high) {
      int mid = (low + high) >> 1;
      int cnt = 0;
      for (int i = 0; i < n; i++) {
        cnt += countSmallerThanMid(A[i], mid, col);
      }
      if (cnt <= (n * m) / 2)
        low = mid + 1;
      else
        high = mid - 1;
    }
    return low;
  }