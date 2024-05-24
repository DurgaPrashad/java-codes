import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        Map<Character, Integer> letterCount = new HashMap<>();
        for (char letter : letters) {
            letterCount.put(letter, letterCount.getOrDefault(letter, 0) + 1);
        }
        return backtrack(words, letterCount, score, 0);
    }
    
    private int backtrack(String[] words, Map<Character, Integer> letterCount, int[] score, int index) {
        if (index == words.length) {
            return 0;
        }
        
        int maxScore = backtrack(words, letterCount, score, index + 1);
        
        String word = words[index];
        boolean canForm = true;
        int currentScore = 0;
        
        Map<Character, Integer> usedLetters = new HashMap<>();
        for (char ch : word.toCharArray()) {
            int remaining = letterCount.getOrDefault(ch, 0) - usedLetters.getOrDefault(ch, 0);
            if (remaining <= 0) {
                canForm = false;
                break;
            }
            usedLetters.put(ch, usedLetters.getOrDefault(ch, 0) + 1);
            currentScore += score[ch - 'a'];
        }
        
        if (canForm) {
            for (char ch : word.toCharArray()) {
                letterCount.put(ch, letterCount.get(ch) - 1);
            }
            
            maxScore = Math.max(maxScore, currentScore + backtrack(words, letterCount, score, index + 1));
            
            for (char ch : word.toCharArray()) {
                letterCount.put(ch, letterCount.get(ch) + 1);
            }
        }
        
        return maxScore;
    }
}
