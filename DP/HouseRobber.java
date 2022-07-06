static int solve(int n, int[] arr){
   int prev = arr[0];
    int prev2 =0;
    for(int i=1; i<n; i++){
        int pick = arr[i];
        if(i>1) pick += prev2;
        int nonPick = 0 + prev;
        int cur_i = Math.max(pick, nonPick);
        prev2 = prev;
        prev= cur_i;
    }
    return prev;
}