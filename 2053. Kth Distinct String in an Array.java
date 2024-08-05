import java.util.*;

class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        List<String> distinctStrings = new ArrayList<>();

       
        for (String s : arr) {
            frequencyMap.put(s, frequencyMap.getOrDefault(s, 0) + 1);
        }

        
        for (String s : arr) {
            if (frequencyMap.get(s) == 1) {
                distinctStrings.add(s);
            }
        }

        
        return (k <= distinctStrings.size()) ? distinctStrings.get(k - 1) : "";
    }
}
