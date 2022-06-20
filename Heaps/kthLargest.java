// Kth largest/smallest element in an array
   
// Problem Statement: Given an unsorted array, print Kth Largest and Smallest Element from an unsorted array.


public static ArrayList<Integer> kthSmallLarge(ArrayList<Integer> arr, int n, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(kthSmallest(arr,n,k));
        res.add(kthLargest(arr,n,k));
        return res;
    }
    static int kthLargest(ArrayList<Integer> arr,int n,int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            pq.add(arr.get(i));
        }
        int f = k-1;
        while(f>0){
            pq.remove();f--;
        }
        return pq.peek();
    }
    static int kthSmallest(ArrayList<Integer> arr,int n,int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++) pq.add(arr.get(i));
        int f = k-1;
        while(f>0){
            pq.remove();f--;
        }
        return pq.peek();
    }