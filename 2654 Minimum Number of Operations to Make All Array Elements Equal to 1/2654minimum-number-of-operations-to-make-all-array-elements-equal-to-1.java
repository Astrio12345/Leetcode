class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int g = nums[0];
        for (int num : nums) g = gcd(g, num);
        if (g > 1) return -1;
        int ones = 0;
        for (int num : nums) if (num == 1) ones++;
        if (ones > 0) return n - ones;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int currGcd = nums[i];
            for (int j = i + 1; j < n; j++) {
                currGcd = gcd(currGcd, nums[j]);
                if (currGcd == 1) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }
        return (minLen - 1) + (n - 1);
    }
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
