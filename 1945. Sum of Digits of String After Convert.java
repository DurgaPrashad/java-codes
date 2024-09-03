class Solution {
    public int getLucky(String s, int k) {
        StringBuilder numberString = new StringBuilder();
        for (char c : s.toCharArray()) {
            int value = c - 'a' + 1;
            numberString.append(value);
        }

        String num = numberString.toString();
        while (k-- > 0) {
            int sum = 0;
            for (char c : num.toCharArray()) {
                sum += c - '0';
            }
            num = String.valueOf(sum);
        }

        return Integer.parseInt(num);
    }
}
