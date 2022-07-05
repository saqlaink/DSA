static int[] topoSort(int N, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[N];
        for(int i=0;i<N;i++){
            for(Integer it: adj.get(i)){
                indegree[it]++;
            }
        }
        
        for(int i = 0;i<N;i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }
        
        int topo[] = new int[N];
        int ind = 0; 
        while(!q.isEmpty()){
            Integer node = q.poll();
            topo[ind++] = node;
            for(Integer it: adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }
        return topo; 
    }