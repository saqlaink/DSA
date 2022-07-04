class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i] == -1){
                if(!bfsCheck(graph,i,color)) return false;
            }
        }
        return true;
    }
    public boolean bfsCheck(int[][] graph,int node,int color[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        color[node] = 1;
        while(!q.isEmpty()){
            Integer val = q.poll();
            for(Integer it: graph[val]){
                if(color[it] == -1){
                    color[it] = 1 - color[val];
                    q.add(it);
                }else if(color[it] == color[val]) return false;
            }
        }
        return true;
    }
}