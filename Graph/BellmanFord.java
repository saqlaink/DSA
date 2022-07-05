class Node {
	private int u;
    private int v;
    private int weight;
    Node(int _u, int _v, int _w){ u = _u; v = _v; weight = _w; }
    int getV() { return v; }
    int getU() { return u; }
    int getWeight() { return weight; }
}
class Main{
    void bellmanFord(ArrayList<Node> edges, int N, int src){
        int dist[] = new int[N];
        for(int i = 0;i<N;i++) dist[i] = 10000000; 
        dist[src] = 0;
    	for(int i = 1;i<=N-1;i++) {
    		for(Node node : edges) {
    			if(dist[node.getU()] + node.getWeight() < dist[node.getV()]) {
    				dist[node.getV()] = dist[node.getU()] + node.getWeight(); 
    			}
    		}
    	}
//extra relaxation to check if it reduces if it does then there is a -ve cycle
    	int fl = 0; 
    	for(Node node: edges) {
    		if(dist[node.getU()] + node.getWeight() < dist[node.getV()]) {
    			fl = 1;
    			System.out.println("Negative Cycle"); 
    			break;
    		}
    	}

    	if(fl == 0) {
    		for(int i = 0;i<N;i++) {
    			System.out.print(  dist[i]+" "); 
    		}
    	}
    }