class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int lastDay = days[n - 1];
        int[] dp = new int[lastDay + 1];
        boolean[] travel = new boolean[lastDay + 1];
        for (int d : days) travel[d] = true;
        for (int i = 1; i <= lastDay; i++) {
            if (!travel[i]) {
                dp[i] = dp[i - 1];
            } else {
                int cost1 = dp[Math.max(0, i - 1)] + costs[0];
                int cost7 = dp[Math.max(0, i - 7)] + costs[1];
                int cost30 = dp[Math.max(0, i - 30)] + costs[2];
                dp[i] = Math.min(cost1, Math.min(cost7, cost30));
            }
        }
        return dp[lastDay];
    }
}
