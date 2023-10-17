class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1) return intervals;
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        List<int[]> res = new ArrayList<>();
        int[] newInt = intervals[0];
        res.add(newInt);
        for(int[] interval: intervals){
            if(interval[0] <= newInt[1]){
                newInt[1] = Math.max(newInt[1], interval[1]);
            }else{
                newInt = interval;
                res.add(newInt);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}