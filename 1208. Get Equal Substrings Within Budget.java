class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] cost = new int[n];
        
       
        for (int i = 0; i < n; i++) {
            cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        
        int maxLength = 0;
        int currentCost = 0;
        int start = 0;
        
       
        for (int end = 0; end < n; end++) {
            currentCost += cost[end];
            
            
            while (currentCost > maxCost) {
                currentCost -= cost[start];
                start++;
            }
            
          
            maxLength = Math.max(maxLength, end - start + 1);
        }
        
        return maxLength;
    }
}
