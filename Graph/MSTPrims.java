class Node{
    private int v;
    private int weight;
    Pair(int _v, int _w) { v = _v; weight = _w; }
    int getV() { return v; }
    int getWeight() { return weight; }
}
class Main {
    void primsAlgo(ArrayList<ArrayList<Integer>> adj,int n){
        int key[] = new int[n];
        int parent[] = new int[n];
        boolean[] mstSet = new boolean[n];
        for(int i=0;i<n;i++){
            key[i] = Integer.MAX_VALUE;
            parent[i] = -1;
            mstSet[i] = false;
        }
        key[0] = 0;
        for(int i=0;i<n-1;i++){
            int mini = Integer.MAX_VALUE, u = 0;
            for(int v=0;v<n;i++){
                if(mstSet[v] == false && key[v] < mini){
                    mini = key[v];
                    u = v;
                }
            }
            
            mstSet[u] = true;
            for(Node it: adj.get(u)){
                if(mstSet[it.getV()] == false && it.getWeight() < key[it.getV()]){
                    parent[it.getV()] = u;
                    key[it.getV()] = it.getWeight();
                }
            }
        }
    }
}




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
class Main {
    void primsAlgo(ArrayList < ArrayList < Node >> adj, int N) {
        int key[] = new int[N];
        int parent[] = new int[N];
        boolean mstSet[] = new boolean[N];
        for (int i = 0; i < N; i++) {
            key[i] = 100000000;
            mstSet[i] = false;
        }
        PriorityQueue < Node > pq = new PriorityQueue < Node > (N, new Node());
        key[0] = 0;
        parent[0] = -1;
        pq.add(new Node(key[0], 0));
        // Run the loop till all the nodes have been visited
        // because in the brute code we checked for mstSet[node] == false while computing the minimum
        // but here we simply take the minimal from the priority queue, so a lot of times a node might be taken twice
        // hence its better to keep running till all the nodes have been taken. 
        // try the following case: 
        // 6 7 
        // 0 1 5 
        // 0 2 10 
        // 0 3 100 
        // 1 3 50 
        // 1 4 200
        // 3 4 250
        // 4 5 50 
        while (!pq.isEmpty()) {
            int u = pq.poll().getV();
            mstSet[u] = true;
            for (Node it: adj.get(u)) {
                if (mstSet[it.getV()] == false && it.getWeight() < key[it.getV()]) {
                    parent[it.getV()] = u;
                    key[it.getV()] = it.getWeight();
                    pq.add(new Node(it.getV(), key[it.getV()]));
                }
            }
        }
        for (int i = 1; i < N; i++) {
            System.out.println(parent[i] + " - " + i);
        }
    }
}