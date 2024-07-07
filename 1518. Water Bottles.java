class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int totalDrinks = 0;
        int emptyBottles = 0;

        while (numBottles > 0) {
           
            totalDrinks += numBottles;
            emptyBottles += numBottles;

            
            numBottles = emptyBottles / numExchange;
            emptyBottles = emptyBottles % numExchange;
        }

        return totalDrinks;
    }
}
