/**Count all triplets with given sum in sorted array
Difficulty: MediumAccuracy: 48.57%Submissions: 43K+Points: 4
Given a sorted array arr[] and a target value, the task is to count triplets (i, j, k) of valid indices, such that arr[i] + arr[j] + arr[k] = target and i < j < k.

Examples:

Input: arr[] = [-3, -1, -1, 0, 1, 2], target = -2
Output: 4
Explanation: Two triplets that add up to -2 are:
arr[0] + arr[3] + arr[4] = (-3) + 0 + (1) = -2
arr[0] + arr[1] + arr[5] = (-3) + (-1) + (2) = -2
arr[0] + arr[2] + arr[5] = (-3) + (-1) + (2) = -2
arr[1] + arr[2] + arr[3] = (-1) + (-1) + (0) = -2
Input: arr[] = [-2, 0, 1, 1, 5], target = 1
Output: 0
Explanation: There is no triplet whose sum is equal to 1. **/


class Solution {
    public int countTriplets(int[] arr, int target) {
        // Code Here
        int n=arr.length;
        int re=0;
        for(int i=0;i<n-2;i++){
            int l=i+1;
            int r=n-1;
            while(l<r){
               int sum=arr[i]+arr[l]+arr[r];
                if(sum<target)
                  l++;
                 else if(sum>target)
                   r--;
                  else if(sum==target){
                      int e1=arr[l];
                      int e2=arr[r];
                      int c1=0;
                      int c2=0;
                      while(l<=r && arr[l]==e1){
                          l++;
                          c1++;
                      }
                      while(l<=r && arr[r]==e2){
                          r--;
                          c2++;
                      }
                      if(e1==e2){
                          re+=(c1*(c1-1))/2;
                      }
                      else
                      re+=c1*c2;
                  } 
            }
        }
        return re;
    }
}