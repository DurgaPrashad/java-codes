import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> minCapitalHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> maxProfitHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (int i = 0; i < profits.length; i++) {
            minCapitalHeap.offer(new int[]{capital[i], profits[i]});
        }

        for (int i = 0; i < k; i++) {
            while (!minCapitalHeap.isEmpty() && minCapitalHeap.peek()[0] <= w) {
                maxProfitHeap.offer(minCapitalHeap.poll());
            }

            if (maxProfitHeap.isEmpty()) {
                break;
            }

            w += maxProfitHeap.poll()[1];
        }

        return w;
    }
}
