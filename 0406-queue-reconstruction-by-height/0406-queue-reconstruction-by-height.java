class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        int[][] res = new int[people.length][2];
        int i = 0;
        ArrayList<int[]> list = new ArrayList<>();
        for(int[] p: people){
            list.add(p[1],p);
        }
        for(int[] a: list) res[i++] = a;
        return res;
    }
}