class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        int n = matrix.length, m = matrix[0].length;
        int lo = 0, hi = (n*m) - 1;
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(matrix[mid/m][mid%m] == target) return true;
            else if(matrix[mid/m][mid%m] < target) lo = mid+1;
            else hi = mid-1; 
        }
        return false;
    }
}