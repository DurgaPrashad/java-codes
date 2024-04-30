class Solution {
    public long wonderfulSubstrings(String word) {
        long[] count = new long[1024]; // Count of wonderful substrings for each possible bitmask
        
        int bitmask = 0; // Bitmask to keep track of the parity of characters
        
        // Initialize the count array with the count of empty string as 1
        count[0] = 1;
        
        long result = 0; // Initialize the result
        
        for (char ch : word.toCharArray()) {
            int index = ch - 'a'; // Get the index of the character
            
            // Toggle the bit corresponding to the character's index
            bitmask ^= 1 << index;
            
            // Add the count of substrings with even parity of all characters
            result += count[bitmask];
            
            // Add the count of substrings with odd parity of exactly one character
            for (int i = 0; i < 10; i++) {
                result += count[bitmask ^ (1 << i)];
            }
            
            // Increment the count of substrings with the current bitmask
            count[bitmask]++;
        }
        
        return result;
    }
}
