/**
Sum Pair closest to target
Difficulty: EasyAccuracy: 44.75%Submissions: 44K+Points: 2
Given an array arr[] and a number target, find a pair of elements (a, b) in arr[], where a<=b whose sum is closest to target.
Note: Return the pair in sorted order and if there are multiple such pairs return the pair with maximum absolute difference. If no such pair exists return an empty array.

Examples:

Input: arr[] = [10, 30, 20, 5], target = 25
Output: [5, 20]
Explanation: As 5 + 20 = 25 is closest to 25.
Input: arr[] = [5, 2, 7, 1, 4], target = 10
Output: [2, 7]
Explanation: As (4, 7) and (2, 7) both are closest to 10, but absolute difference of (2, 7) is 5 and (4, 7) is 3. Hence, [2, 7] has maximum absolute difference and closest to target. 
Input: arr[] = [10], target = 10
Output: []
Explanation: As the input array has only 1 element, return an empty array.
Constraints:
1 <= arr.size() <= 2*105
0 <= target<= 2*105
0 <= arr[i] <= 105

Company Tags
Ola Cabs
Topic Tags
Related Articles
Expected Complexities
If you are facing any issue on this page. Please let us know.

**/

class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
    Arrays.sort(arr);
    List<Integer> A=new ArrayList<>();
    int start=0;
    int  end=arr.length-1;
    int close=Integer.MAX_VALUE;
    while(start<end){
        int sum=arr[start]+arr[end];
        if(Math.abs(target-sum)<close){
            close=Math.abs(target-sum);
            A.clear();
            A.add(arr[start]);
            A.add(arr[end]);
        }
        
        if(sum<target)
         start++;
         else if(sum>target)
          end--;
          else
           return A;
    }
    return A;
    }
}