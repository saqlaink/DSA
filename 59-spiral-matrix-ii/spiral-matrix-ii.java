class Solution {
    public int[][] generateMatrix(int n) {
        // int[][] mat = new int[n][n];
        // int top = 0,left = 0;
        // int right = n-1,bottom = n-1;
        // int val = 1;
        // while(top<=bottom && left <= right){
        //     for(int i=left;i<=right;i++){
        //         mat[top][i] = val;
        //         val++;
        //     }
        //     for(int i=top+1;i<=bottom;i++){
        //         mat[i][right] = val;
        //         val++;
        //     }
        //     if(top!=bottom){
        //         for(int i=right-1;i>=left;i--){
        //             mat[bottom][i] = val;
        //             val++;
        //         }
        //     }
        //     if(left != right){
        //         for(int i=bottom-1;i>=top+1;i--){
        //             mat[i][left] = val;
        //             val++;
        //         }
        //     }
        //     left++;
        //     right--;
        //     bottom--;
        //     top++;
        // }
        // return mat;
        int[][] mat = new int[n][n];
        int top = 0, left = 0;
        int bottom = n-1,right = n-1;
        int val = 1;
        while(top<=bottom && left<=right){
            for(int i=left;i<=right;i++){
                mat[top][i] = val++;
            }
            for(int i=top+1;i<=bottom;i++){
                mat[i][right] = val++;
            }
            if(top!=bottom){
                for(int i=right-1;i>=left;i--){
                    mat[bottom][i] = val++;
                }
            }
            if(left!=right){
                for(int i=bottom-1;i>=top+1;i--){
                    mat[i][left] = val++;
                }
            }
            left++;right--;
            top++;bottom--;
        }
        return mat;
    }
}