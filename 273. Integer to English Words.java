class Solution {
    private final String[] thousands = {"", "Thousand", "Million", "Billion"};
    private final String[] belowTwenty = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] belowHundred = {"", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        return helper(num).trim();
    }
    
    private String helper(int num) {
        if (num == 0) return "";
        if (num < 20) return belowTwenty[num];
        if (num < 100) return belowHundred[num / 10 - 1] + (num % 10 != 0 ? " " + belowTwenty[num % 10] : "");
        if (num < 1000) return belowTwenty[num / 100] + " Hundred" + (num % 100 != 0 ? " " + helper(num % 100) : "");
        for (int i = 0; i < thousands.length; i++) {
            int unit = (int) Math.pow(1000, i + 1);
            if (num < unit) return helper(num / (unit / 1000)) + " " + thousands[i] + (num % (unit / 1000) != 0 ? " " + helper(num % (unit / 1000)) : "");
        }
        return "";
    }
}
