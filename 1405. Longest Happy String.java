class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder result = new StringBuilder();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x, y) -> y[1] - x[1]);

        if (a > 0) maxHeap.add(new int[] { 'a', a });
        if (b > 0) maxHeap.add(new int[] { 'b', b });
        if (c > 0) maxHeap.add(new int[] { 'c', c });

        while (!maxHeap.isEmpty()) {
            int[] first = maxHeap.poll();
            char ch1 = (char) first[0];
            int count1 = first[1];

            if (result.length() >= 2 && result.charAt(result.length() - 1) == ch1 && result.charAt(result.length() - 2) == ch1) {
                if (maxHeap.isEmpty()) {
                    break;
                }
                int[] second = maxHeap.poll();
                char ch2 = (char) second[0];
                int count2 = second[1];

                result.append(ch2);
                count2--;

                if (count2 > 0) {
                    maxHeap.add(new int[] { ch2, count2 });
                }
                
                maxHeap.add(first);
            } else {
                result.append(ch1);
                count1--;

                if (count1 > 0) {
                    maxHeap.add(new int[] { ch1, count1 });
                }
            }
        }
        
        return result.toString();
    }
}
