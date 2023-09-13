class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int[] vis = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(vis[i] == 0){
                if(isCyclic(i,adj,vis)) return false;
            }
        }
        return true;
    }
    private boolean isCyclic(int curr,List<List<Integer>> adj, int[] vis){
        if(vis[curr] == 2) return true;
        vis[curr] = 2;
        for(int i=0;i<adj.get(curr).size();i++){
            if(vis[adj.get(curr).get(i)] != 1){
                if(isCyclic(adj.get(curr).get(i),adj,vis)) return true;
            }
        }
        vis[curr] = 1;
        return false;
    }
}
