class Solution {
  public void sortColors(int[] nums) {
    int low = 0, high = nums.length - 1, mid = 0;
    while (mid <= high) {
      switch (nums[mid]) {
        case 0:
          swap(nums, low++, mid++);
          break;
        case 2:
          swap(nums, high--, mid);
          break;
        default:
          mid++;
      }
    }
  }

  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
