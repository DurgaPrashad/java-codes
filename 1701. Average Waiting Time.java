class Solution {
    public double averageWaitingTime(int[][] customers) {
        long totalWaitingTime = 0;
        int currentTime = 0;
        
        for (int[] customer : customers) {
            int arrival = customer[0];
            int time = customer[1];
            
            if (currentTime < arrival) {
                currentTime = arrival;
            }
            int waitingTime = currentTime + time - arrival;
            totalWaitingTime += waitingTime;
            currentTime += time;
        }
        
        return (double) totalWaitingTime / customers.length;
    }
}
