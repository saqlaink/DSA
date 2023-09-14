class Solution {
    public int[] findOrder(int numCourses, int[][] prereq) {
        int n = prereq.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            adj.get(prereq[i][0]).add(prereq[i][1]);
        }
        int[] in = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int it: adj.get(i)) in[it]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(in[i] == 0) q.add(i);
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            res.add(node);
            for(int i: adj.get(node)){
                in[i]--;
                if(in[i] == 0) q.add(i);
            }
        }
        int[] ans = new int[res.size()];
        for(int i=res.size()-1;i>=0;i--){
            ans[ans.length-i-1] = res.get(i);
        }
        if(res.size() != numCourses) return new int[0];
        return ans;
    }
}