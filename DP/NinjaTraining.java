static int f(int day, int last, int[][] points, int[][] dp) {
    if (dp[day][last] != -1) return dp[day][last];
    if (day == 0) {
        int maxi = 0;
        for (int i = 0; i <= 2; i++) {
            if (i != last)
                maxi = Math.max(maxi, points[0][i]);
        }
        return dp[day][last] = maxi;
    }
    int maxi = 0;
    for (int i = 0; i <= 2; i++) {
        if (i != last) {
            int activity = points[day][i] + f(day - 1, i, points, dp);
            maxi = Math.max(maxi, activity);
        }
    }
    return dp[day][last] = maxi;
}
static int ninjaTraining(int n, int[][] points) {
    int dp[][] = new int[n][4];
    for (int[] row: dp) Arrays.fill(row, -1);
    return f(n - 1, 3, points, dp);
}