class Solution {
    public int divide(int dividend, int divisor) {
        int INT_MAX = Integer.MAX_VALUE;
        int INT_MIN = Integer.MIN_VALUE;
        if (dividend == INT_MIN && divisor == -1) {
            return INT_MAX;
        }
        boolean negative = (dividend < 0) ^ (divisor < 0);
        long lDividend = Math.abs((long) dividend);
        long lDivisor = Math.abs((long) divisor);
        int result = 0;
        while (lDividend >= lDivisor) {
            long temp = lDivisor;
            int multiple = 1;
            while (lDividend >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            lDividend -= temp;
            result += multiple;
        }
        return negative ? -result : result;
    }
}