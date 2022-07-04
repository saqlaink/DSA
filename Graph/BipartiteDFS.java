class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i] == -1){
                if(!dfsCheck(graph,i,color)) return false;
            }
        }
        return true;
    }
    public boolean dfsCheck(int[][] graph,int node,int[] color){
        if(color[node] == -1) color[node] = 1;
        for (Integer it: graph[node]) {
            if (color[it] == -1) {
                //Color of variable neighbor is the inverted color of variable node
                color[it] = 1 - color[node];

                if (!dfsCheck(graph, it, color))
                    return false;
            } else if (color[it] == color[node]) {
                return false;
            }
        }
        return true;
    }
}