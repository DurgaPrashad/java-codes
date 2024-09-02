class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        // Step 1: Calculate the total chalk consumption in one cycle
        long totalChalk = 0;
        for (int c : chalk) {
            totalChalk += c;
        }

        // Step 2: Reduce k by modulo of the total chalk consumption
        k %= totalChalk;

        // Step 3: Find the student who will replace the chalk
        for (int i = 0; i < chalk.length; i++) {
            if (k < chalk[i]) {
                return i;
            }
            k -= chalk[i];
        }

        // This point should never be reached because one student will always replace the chalk
        return -1;
    }
}
