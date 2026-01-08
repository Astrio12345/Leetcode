import java.util.*;
class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int totApples = 0;
        for (int a : apple) {
            totApples += a;
        }
        Arrays.sort(capacity);
        int CC = 0;
        int Used = 0;

        for (int i = capacity.length - 1; i >= 0; i--) {
            CC += capacity[i];
            Used++;
            if (CC >= totApples) {
                return Used;
            }
        }
        return Used;
    }
}
