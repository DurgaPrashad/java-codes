import java.util.*;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result = new String[n];
        
        // Create a map to store score and its corresponding index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(score[i], i);
        }
        
        // Sort the scores in descending order
        Arrays.sort(score);
        for (int i = n - 1, rank = 0; i >= 0; i--, rank++) {
            int index = map.get(score[i]);
            if (rank == 0) {
                result[index] = "Gold Medal";
            } else if (rank == 1) {
                result[index] = "Silver Medal";
            } else if (rank == 2) {
                result[index] = "Bronze Medal";
            } else {
                result[index] = String.valueOf(rank + 1);
            }
        }
        
        return result;
    }
}
