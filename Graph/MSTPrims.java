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