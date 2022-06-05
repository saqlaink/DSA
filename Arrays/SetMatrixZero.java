// Problem Statement: Given a matrix if an element in the matrix is 0 then you will have to set its entire column and row to 0 and then return the matrix.
// Time Complexity: O(N*M + N*M)
// Space Complexity: O(N)

import java.util.* ;
import java.io.*; 
public class Solution {
    public static void setZeros(int matrix[][]) {
        int rows = matrix.length;int cols = matrix[0].length;
        int[] dummy1 = new int[rows];
        int[] dummy2 = new int[cols];
        Arrays.fill(dummy1,-1);
        Arrays.fill(dummy2,-1);
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j] == 0){
                    dummy1[i] = 0;
                    dummy2[j] = 0;
                }
            }
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(dummy1[i] == 0 || dummy2[j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

//Approach 2
// Time Complexity: O(2*(N*M)), as we are traversing two times in a matrix,
// Space Complexity: O(1).

import java.util.* ;
import java.io.*; 
public class Solution {
    public static void setZeros(int matrix[][]) {
        int rows = matrix.length;int cols = matrix[0].length;
        int col0 = 1;
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) col0 = 0;
            for (int j = 1; j < cols; j++)
                if (matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
        }
        for(int i=rows-1;i>=0;i--){
            for(int j=cols-1;j>=1;j--){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
            if(col0 == 0) matrix[i][0] = 0;
        }
    }
}