class Solution {

    // a: input array
    // n: size of array
    // Function to find maximum circular subarray sum.
    public int circularSubarraySum(int arr[]) {

        // Your code here
         int maxsub=Integer.MIN_VALUE;
       int tms=0;
       int minsub=Integer.MAX_VALUE;
       int tmis=0;
       int sum=0;
       for(int i=0;i<arr.length;i++){
           sum+=arr[i];
           tms+=arr[i];
           if(tms<0)
              tms=0;
            maxsub=Math.max(maxsub,tms);
          tmis+=arr[i];
           if(tmis>0)
              tmis=0;
            minsub=Math.min(minsub,tmis);    
            }
            if (maxsub < 0) {
            return maxsub;
        }
        
                return Math.max(maxsub,sum-minsub);
            
    }
}
