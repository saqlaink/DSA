// Merge Overlapping Sub-intervals
// Problem Statement: Given an array of intervals, merge all the overlapping intervals and return an array of non-overlapping intervals.
// Time Complexity: O(NlogN) + O(N). O(NlogN) for sorting and O(N) for traversing through the array.
// Space Complexity: O(N) to return the answer of the merged intervals.


    static ArrayList < List < Integer >> merge(ArrayList < List < Integer >> intervals) {

        Collections.sort(intervals, (a, b) - > a.get(0) - b.get(0));
        ArrayList < List < Integer >> merged = new ArrayList < > ();

        for (int i = 0; i < intervals.size(); i++) {
            if (merged.isEmpty() || merged.get(merged.size() - 1).get(1) < intervals.get(i).get(0)) {
                ArrayList < Integer > v = new ArrayList < > ();
                v.add(intervals.get(i).get(0));
                v.add(intervals.get(i).get(1));

                merged.add(v);
            } else {
                
                merged.get(merged.size() - 1).set(1, Math.max(merged.get(merged.size() - 1).get(1), intervals.get(i).get(1)));
            }
        }

        return merged;
    }