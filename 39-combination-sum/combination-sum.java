class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int k) {
        List<List<Integer>> res = new ArrayList<>();
        sum(0,arr,k,res,new ArrayList<>());
        return res;
    }
    static void sum(int idx,int[] arr,int k,List<List<Integer>> res,ArrayList<Integer> ds){
        // if(idx == arr.length){
        //     if(k == 0){
        //         res.add(new ArrayList<>(ds));
        //     }
        //     return;
        // }
        // if(arr[idx] <= k){
        //     ds.add(arr[idx]);
        //     sum(idx,arr,k-arr[idx],res,ds);
        //     ds.remove(ds.size() - 1);
        // }
        // sum(idx+1,arr,k,res,ds);
        if(idx == arr.length){
            if(k == 0) res.add(new ArrayList<>(ds));
            return;
        }
        if(arr[idx] <= k){
            ds.add(arr[idx]);
            sum(idx,arr,k - arr[idx],res,ds);
            ds.remove(ds.size() - 1);
        }
        sum(idx+1,arr,k,res,ds);
    }
}