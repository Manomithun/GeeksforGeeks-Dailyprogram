class Solution {
    public int getSecondLargest(int[] arr) {
        // Code Here
        Arrays.sort(arr);
        int t=-1;
        int t1=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>t){
                t1=t;
                t=arr[i];
                
            }
        }
       return t1;
    }
}
