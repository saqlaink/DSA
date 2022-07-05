class Pair{
    private int v;
    private int weight;
    Pair(int _v, int _w) { v = _v; weight = _w; }
    int getV() { return v; }
    int getWeight() { return weight; }
}
class Main{
    void topologicalSortUtil(int node, Boolean visited[], Stack stack, 
                                    ArrayList<ArrayList<Pair>> adj){
        visited[node] = true;
        for(Pair it: adj.get(node)) {
            if(visited[it.getV()] == false) {
                topologicalSortUtil(it.getV(), visited, stack, adj);
            }
        }
        stack.add(node);
    }
    void shortestPath(int s, ArrayList<ArrayList<Pair>> adj, int N){
        Stack<Integer> stack = new Stack();
        int dist[] = new int[N];
        Boolean visited[] = new Boolean[N];
				Arrays.fill(visited,false);
        for (int i = 0; i < N; i++)
            if (visited[i] == false)
                topologicalSortUtil(i, visited, stack, adj);

        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[s] = 0;
        while (!stack.empty()){
            int node = (int)stack.pop();
            if (dist[node] != Integer.MAX_VALUE){
                for(Pair it: adj.get(node)) {
                    if(dist[node] + it.getWeight() < dist[it.getV()]) {
                        dist[it.getV()] = dist[node] + it.getWeight(); 
                    }
                }
            }
        }
        for (int i = 0; i < N; i++){
            if (dist[i] == Integer.MAX_VALUE) System.out.print( "INF ");
            else System.out.print( dist[i] + " ");
        }
    }
}