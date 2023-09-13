class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();
        boolean[][] atlantic = new boolean[row][col];
        boolean[][] pacific = new boolean[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i == 0 || j == 0) dfs(i,j,0,pacific,heights);
                if(i == row-1 || j == col - 1) dfs(i,j,0,atlantic,heights);
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(atlantic[i][j] && pacific[i][j]) res.add(Arrays.asList(i,j));
            }
        }
        return res;
    }
    public static void dfs(int i,int j, int prev,boolean[][] sea,int[][] heights){
        if(i<0 || j<0 || i>=heights.length || j>=heights[0].length || heights[i][j] < prev || sea[i][j]) return;
        sea[i][j] = true;
        dfs(i+1,j,heights[i][j],sea,heights);
        dfs(i,j+1,heights[i][j],sea,heights);
        dfs(i-1,j,heights[i][j],sea,heights);
        dfs(i,j-1,heights[i][j],sea,heights);
    }
}