class Solution {

    // arr: input array
    // Function to find the sum of contiguous subarray with maximum sum.
    int maxSubarraySum(int[] arr) {

      int max = Integer.MIN_VALUE;  
      int max1 = 0;            
        for (int i = 0; i < arr.length; i++) {
            max1 += arr[i];

             if (max < max1) {
                max = max1;
            }

             if (max1 < 0) {
                max1 = 0;
            }
        }
        return max;
    }
}
