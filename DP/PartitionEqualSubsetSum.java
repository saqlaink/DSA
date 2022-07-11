public static boolean canPartition(int[] arr, int n) {
        int totSum = 0;
        for(int a:arr) totSum+=a;
        if(totSum%2==1) return false;
        int target = totSum/2;
        return subsetSumK(n,target,arr); //same as above question
    }