class Main{
	void printBridge(ArrayList<ArrayList<Integer>> adj, int n){
	    int[] vis = new int[n];
	    int[] tin = new int[n]; //time of insertion
	    int[] low = new int[n]; //lowest time of insertion
	    int timer = 0;
	    for(int i=0;i<n;i++){
	        if(vis[i] == 0){
	            dfs(i,-1,vis,tin,low,adj,timer);
	        }
	    }
	}
	void dfs(int node,int parent,int[] vis,int[] tin,int[] low,ArrayList<ArrayList<Integer>> adj,int timer){
	    vis[node] = 1;
	    tin[node] = low[node] = timer++;
	    
	    for(Integer it: adj.get(node)){
	        if(it == parent) continue;
	        
	        if(vis[it] == 0){
	            dfs(it,node,vis,tin,low,adj,timer);
	            low[node] = Math.min(low[node],low[it]);
	            
	            if(low[it] > tin[node]){
	                System.out.println(it + " " + node);
	            }
	        }else{
	            low[node] = Math.max(low[node],tin[it]);
	        }
	    }
	}
}