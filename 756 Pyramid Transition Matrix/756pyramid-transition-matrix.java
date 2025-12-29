import java.util.*;

class Solution {

    private Map<String, List<Character>> map = new HashMap<>();

    public boolean pyramidTransition(String bottom, List<String> allowed) {

        // Build mapping: "AB" -> [C, D, ...]
        for (String s : allowed) {
            String key = s.substring(0, 2);
            char top = s.charAt(2);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(top);
        }

        return canBuild(bottom);
    }

    private boolean canBuild(String row) {
        if (row.length() == 1) return true;

        List<String> nextRows = new ArrayList<>();
        buildNextRows(row, 0, new StringBuilder(), nextRows);

        for (String next : nextRows) {
            if (canBuild(next)) return true;
        }
        return false;
    }

    private void buildNextRows(String row, int index,
                               StringBuilder current,
                               List<String> result) {

        if (index == row.length() - 1) {
            result.add(current.toString());
            return;
        }

        String key = row.substring(index, index + 2);
        if (!map.containsKey(key)) return;

        for (char c : map.get(key)) {
            current.append(c);
            buildNextRows(row, index + 1, current, result);
            current.deleteCharAt(current.length() - 1); // backtrack
        }
    }
}