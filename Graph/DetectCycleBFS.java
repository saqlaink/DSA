class Node {
    int first;
    int second;
    public Node(int first, int second) {
        this.first = first;
        this.second = second; 
    }
}
class Solution {
    public boolean isCycle(int v,ArrayList<ArrayList<Integer>> adj){
        boolean[] vis = new boolean[v];
        Arrays.fill(vis,false);
        for(int i=0;i<v;i++){
            if(vis[i] == false){
                if(checkForCycle(adj,i,vis)) return true;
            }
        }
        return false;
    }
    static boolean checkForCycle(ArrayList<ArrayList<Integer>> adj, int s,boolean vis[]){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(s,-1));//node and parent
        vis[s] = true;
        while(!q.isEmpty()){
            int node = q.peek().first;
            int par = q.peek().second;
            q.remove();
            for(Integer it: adj.get(node)){
                if(vis[it] == false){
                    q.add(new Node(it,node));
                    vis[it] = true;
                }else if(par != it) {//if already visited but not its parent
                    return true;
                }
            }
        }
        return false;
    }
}