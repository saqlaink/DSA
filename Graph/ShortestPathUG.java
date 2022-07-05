public static void sp(ArrayList<ArrayList<Integer>> adj,int n,int src){
    Queue<Integer> q = new LinkedList<>();
    int[] dist = new int[n];
    for(int i=0;i<n;i++){
        dist[i] = Integer.MAX_VALUE;
    }
    dist[src] = 0;
    q.add(src);
    while(!q.isEmpty()){
        Integer node = q.poll();
        for(Integer it: adj.get(node)){
            if(dist[node]+1<dist[it]){
                dist[it] = dist[node] + 1;
                q.add(it);
            }
        }
    }
}