class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int[] prefixB = new int[n];
        int[] suffixA = new int[n];
        
     
        prefixB[0] = (s.charAt(0) == 'b') ? 1 : 0;
        for (int i = 1; i < n; i++) {
            prefixB[i] = prefixB[i - 1] + ((s.charAt(i) == 'b') ? 1 : 0);
        }


        suffixA[n - 1] = (s.charAt(n - 1) == 'a') ? 1 : 0;
        for (int i = n - 2; i >= 0; i--) {
            suffixA[i] = suffixA[i + 1] + ((s.charAt(i) == 'a') ? 1 : 0);
        }

     
        int minDeletions = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            minDeletions = Math.min(minDeletions, prefixB[i] + suffixA[i + 1]);
        }

        
        minDeletions = Math.min(minDeletions, prefixB[n - 1]);
        minDeletions = Math.min(minDeletions, suffixA[0]);

        return minDeletions;
    }
}
