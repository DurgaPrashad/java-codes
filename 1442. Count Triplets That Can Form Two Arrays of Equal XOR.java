class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int xor = 0;
            for (int k = i; k < n; k++) {
                xor ^= arr[k];
                if (xor == 0) {
                    count += (k - i);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr1 = {2, 3, 1, 6, 7};
        int[] arr2 = {1, 1, 1, 1, 1};

        System.out.println(sol.countTriplets(arr1));  // Output: 4
        System.out.println(sol.countTriplets(arr2));  // Output: 10
    }
}
