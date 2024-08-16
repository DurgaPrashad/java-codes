import java.util.List;

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int globalMin = arrays.get(0).get(0);
        int globalMax = arrays.get(0).get(arrays.get(0).size() - 1);
        int maxDistance = 0;

        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> currentArray = arrays.get(i);
            int localMin = currentArray.get(0);
            int localMax = currentArray.get(currentArray.size() - 1);

            // Calculate the maximum distance considering the global min and max
            maxDistance = Math.max(maxDistance, Math.abs(localMax - globalMin));
            maxDistance = Math.max(maxDistance, Math.abs(localMin - globalMax));

            // Update the global min and max
            globalMin = Math.min(globalMin, localMin);
            globalMax = Math.max(globalMax, localMax);
        }

        return maxDistance;
    }
}
