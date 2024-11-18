class Solution {
    public int getSecondLargest(int[] arr) {
        // Code Here
        int n = arr.length;

        int l = -1, secondL = -1;

    
        for (int i = 0; i < n; i++) {

           
            if(arr[i] > l) {
                secondL = l;
                l = arr[i];
            }
          
            else if(arr[i] < l && arr[i] > secondL) {
                secondL = arr[i];
            }
        }
        return secondL;
    }
}