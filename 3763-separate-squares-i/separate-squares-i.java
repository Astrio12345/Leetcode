class Solution {
    public double separateSquares(int[][] squares) {
        double totalArea = 0;
        double minY = Double.MAX_VALUE;
        double maxY = Double.MIN_VALUE;
        for (int[] sq : squares) {
            double y = sq[1];
            double l = sq[2];
            totalArea += l * l;
            minY = Math.min(minY, y);
            maxY = Math.max(maxY, y + l);
        }
        double target = totalArea / 2.0;
        double low = minY, high = maxY;
        // Binary search
        for (int iter = 0; iter < 60; iter++) {
            double mid = (low + high) / 2.0;
            if (areaBelow(squares, mid) < target) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return low;
    }
    private double areaBelow(int[][] squares, double h) {
        double area = 0;
        for (int[] sq : squares) {
            double y = sq[1];
            double l = sq[2];
            if (h <= y) {
                continue;
            } else if (h >= y + l) {
                area += l * l;
            } else {
                area += (h - y) * l;
            }
        }
        return area;
    }
}
