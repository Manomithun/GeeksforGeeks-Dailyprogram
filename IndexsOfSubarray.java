
/***Given an unsorted array arr containing only non-negative integers, your task is to find a continuous subarray (a contiguous sequence of elements) whose sum equals a specified value target. You need to return the 1-based indices of the leftmost and rightmost elements of this subarray.

Examples:

Input: arr[] = [1,2,3,7,5], target = 12
Output: [2, 4]
Explanation: The sum of elements from 2nd to 4th position is 12.
Input: arr[] = [1,2,3,4,5,6,7,8,9,10], target = 15,
Output: [1, 5]
Explanation: The sum of elements from 1st to 5th position is 15.
Input: arr[] = [7,2,1], target = 2
Output: [2, 2]
Explanation: The sum of elements from 2nd to 2nd position is 2.
Input: arr[] = [5,3,4], target = 2
Output: [-1]
Explanation: There is no subarray with sum 2.***/

class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
        
        int sum=0;
        boolean b=true;
        boolean a=true;
        ArrayList<Integer> A=new ArrayList<>();
         ArrayList<Integer> B=new ArrayList<>();
        for(int j=0;j<arr.length;j++){
            if(arr[j]==target){
                B.add(j+1);
                a=false;
                B.add(j+1);
                
            }
        }
    
           int i=0;
           int j=0;
        while(i<arr.length && j<arr.length){
            if(sum+arr[j]<=target){
                sum+=arr[j++];
               
                if(sum==target){
                A.add(i+1);
                 b=false;
                A.add(j);
                break;
                }
                
            }
            else if(sum+arr[j]>target){
                sum-=arr[i++];
            }
            
        }
        if(b==true && a==true){
            A.add(-1);
        }
        if(b==true && a==false){
            return B;
        }
        return A;
    }
}
