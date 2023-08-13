class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // List<int[]> result = new ArrayList<>();
        // for(int[] slot : intervals){
        //     // if newInterval before slot insert newInterval & update slot as new interval
        //     if(newInterval[1] < slot[0]){
        //         result.add(newInterval);
        //         newInterval = slot;
        //     } 
        //     // if slot is lesser than new Interval insert slot
        //     else if(slot[1] < newInterval[0]){
        //         result.add(slot);
        //     } 
        //     // if above conditions fail its an overlap since possibility of new interval existing in left & right of slot is checked
        //     // update lowest of start & highest of end & not insert
        //     else {
        //         newInterval[0] = Math.min(newInterval[0],slot[0]);
        //         newInterval[1] = Math.max(newInterval[1],slot[1]);
        //     }
        // }
        // result.add(newInterval);// insert the last newInterval
        // return result.toArray(new int[result.size()][]);// convert to int[][] array
        List<int[]> res = new ArrayList<>();
        for(int[] slot: intervals){
            if(newInterval[1] < slot[0]){
                res.add(newInterval);
                newInterval = slot;
            }else if(slot[1] < newInterval[0]) res.add(slot);
            else{
                newInterval[0] = Math.min(newInterval[0],slot[0]);
                newInterval[1] = Math.max(newInterval[1],slot[1]);
            }
        }
        res.add(newInterval);
        return res.toArray(new int[res.size()][]);
    }
}