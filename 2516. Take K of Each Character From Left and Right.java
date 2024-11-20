class Solution {
    public int takeCharacters(String s, int k) {
        if (k == 0) return 0;

        // Count the total occurrences of 'a', 'b', 'c'
        int[] totalCount = new int[3];
        for (char ch : s.toCharArray()) {
            totalCount[ch - 'a']++;
        }

        for (int count : totalCount) {
            if (count < k) return -1;
        }

     
        int n = s.length();
        int[] count = new int[3];
        int maxMiddleLength = 0, left = 0;

        for (int right = 0; right < n; right++) {
            count[s.charAt(right) - 'a']++;

        
            while (count[0] > totalCount[0] - k || count[1] > totalCount[1] - k || count[2] > totalCount[2] - k) {
                count[s.charAt(left) - 'a']--;
                left++;
            }

            // Update the maximum middle length
            maxMiddleLength = Math.max(maxMiddleLength, right - left + 1);
        }
        return n - maxMiddleLength;
    }
}
