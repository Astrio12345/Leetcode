class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int max = costs[0];
        for (int i = 0; i < costs.length; i++) {
            max = Math.max(costs[i], max);
        }
        int[] buckets = new int[max + 1];
        for (int p : costs) {
            buckets[p]++;
        }
        int ans = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (coins < i) {
                break;
            }
            if (buckets[i] > 0) {
                ans += Math.min(buckets[i], coins/i);
                coins -= Math.min(coins, i * buckets[i]);
            }
        }
        return ans;
    }
}