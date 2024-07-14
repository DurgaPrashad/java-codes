import java.util.*;

class Solution {
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        Map<String, Integer> currentMap = new HashMap<>();
        int n = formula.length();
        int i = 0;

        while (i < n) {
            char c = formula.charAt(i);
            if (c == '(') {
                stack.push(currentMap);
                currentMap = new HashMap<>();
                i++;
            } else if (c == ')') {
                i++;
                int start = i;
                while (i < n && Character.isDigit(formula.charAt(i))) i++;
                int multiplier = start < i ? Integer.parseInt(formula.substring(start, i)) : 1;

                if (!stack.isEmpty()) {
                    Map<String, Integer> top = stack.pop();
                    for (String key : currentMap.keySet()) {
                        top.put(key, top.getOrDefault(key, 0) + currentMap.get(key) * multiplier);
                    }
                    currentMap = top;
                }
            } else {
                int start = i;
                i++;
                while (i < n && Character.isLowerCase(formula.charAt(i))) i++;
                String name = formula.substring(start, i);
                start = i;
                while (i < n && Character.isDigit(formula.charAt(i))) i++;
                int count = start < i ? Integer.parseInt(formula.substring(start, i)) : 1;
                currentMap.put(name, currentMap.getOrDefault(name, 0) + count);
            }
        }

        StringBuilder sb = new StringBuilder();
        List<String> keys = new ArrayList<>(currentMap.keySet());
        Collections.sort(keys);
        for (String key : keys) {
            sb.append(key);
            int count = currentMap.get(key);
            if (count > 1) sb.append(count);
        }
        return sb.toString();
    }
}
