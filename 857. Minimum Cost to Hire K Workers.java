import java.util.*;

class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double[][] ratio = new double[n][2]; // [quality, wage/quality]
        
        for (int i = 0; i < n; i++) {
            ratio[i][0] = (double) quality[i];
            ratio[i][1] = (double) wage[i] / quality[i];
        }
        
        Arrays.sort(ratio, (a, b) -> Double.compare(a[1], b[1]));
        
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        double qualitySum = 0.0;
        double minCost = Double.MAX_VALUE;
        
        for (double[] r : ratio) {
            qualitySum += r[0];
            maxHeap.offer(r[0]);
            
            if (maxHeap.size() > k) {
                qualitySum -= maxHeap.poll();
            }
            
            if (maxHeap.size() == k) {
                minCost = Math.min(minCost, qualitySum * r[1]);
            }
        }
        
        return minCost;
    }
}
