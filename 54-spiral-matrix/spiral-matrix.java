class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // List<Integer> res = new ArrayList<>();
        // int top = 0,left = 0;
        // int right = matrix[0].length - 1,bottom = matrix.length - 1;
        // while(bottom>= top && left<=right){
        //     for(int i=left;i<=right;i++){
        //         res.add(matrix[top][i]);
        //     }
        //     for(int i=top+1;i<=bottom;i++){
        //         res.add(matrix[i][right]);
        //     }
        //     if(top!=bottom){
        //         for(int i=right-1;i>=left;i--){
        //             res.add(matrix[bottom][i]);
        //         }
        //     }
        //     if(left!=right){
        //         for(int i=bottom-1;i>=top+1;i--){
        //             res.add(matrix[i][left]);
        //         }
        //     }
        //     left++;
        //     right--;
        //     bottom--;
        //     top++;
        // }
        // return res;
        List<Integer> res = new ArrayList<>();
        int top = 0, left =0;
        int right = matrix[0].length-1, bottom = matrix.length - 1;
        while(bottom >= top && right >= left){
            for(int i=left;i<=right;i++){
                res.add(matrix[top][i]);
            }
            for(int i=top+1;i<=bottom;i++){
                res.add(matrix[i][right]);
            }
            if(top!=bottom){
                for(int i=right-1;i>=left;i--){
                    res.add(matrix[bottom][i]);
                }
            }
            if(left != right){
                for(int i=bottom-1;i>=top+1;i--){
                    res.add(matrix[i][left]);
                }
            }
            top++;bottom--;
            right--;left++;
        }
        return res;
    }
}

