import java.util.Arrays;
import java.util.LinkedList;

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        
        LinkedList<Integer> indexQueue = new LinkedList<>();
        for (int i = 0; i < deck.length; i++) {
            indexQueue.add(i);
        }
        
        int[] result = new int[deck.length];
        
        for (int card : deck) {
            int position = indexQueue.poll();
            result[position] = card;
            
            if (!indexQueue.isEmpty()) {
                indexQueue.add(indexQueue.poll());
            }
        }
        
        return result;
    }
}
