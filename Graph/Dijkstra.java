class Node implements Comparator<Node>{
    private int v;
    private int weight;
    Pair(int _v, int _w) { v = _v; weight = _w; }
    int getV() { return v; }
    int getWeight() { return weight; }

    public int compare(Node node1,Node node2){//min Priority Q sorts weight
        if(node1.weight < node2.weight ) return -1;
        if(node1.weight > node2.weight ) return 1;
        return 0;
    }
}
class Main{
    void shortestPath(int s, ArrayList<ArrayList<Pair>> adj, int N){
        int dist[] = new int[N];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(N,new Node());
        pq.add(new Node(s,0));
        while(pq.size() > 0){
            Node node = pq.poll();
            for(Node it: adj.get(node.getV())){
    //prev value dist[node.getV()] + new wt of adjacent
                if(node.getWeight() + it.getWeight() < dist[it.getV()]){
                    dist[it.getV()] = node.getWeight() + it.getWeight();
                    pq.add(new Node(it.getV(),dist[it.getV()]));
                }
            }
        }
    }
}