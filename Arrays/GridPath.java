// Grid Unique Paths | Count paths from left-top to the right bottom of a matrix
// Problem Statement: Given a matrix m X n, count paths from left-top to the right bottom of a matrix with the constraints that from each cell you can either only move to the rightward direction or the downward direction.

int uniquePaths(int m, int n) {
            int N = n + m - 2;
            int r = m - 1; 
            double res = 1;
            
            for (int i = 1; i <= r; i++)
                res = res * (N - r + i) / i;
            return (int)res;
    }