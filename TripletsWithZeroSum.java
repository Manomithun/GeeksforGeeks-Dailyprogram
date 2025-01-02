/**
Find All Triplets with Zero Sum
Difficulty: MediumAccuracy: 50.36%Submissions: 52K+Points: 4
Given an array arr[], find all possible triplets i, j, k in the arr[] whose sum of elements is equals to zero. 
Returned triplet should also be internally sorted i.e. i<j<k.

Examples:

Input: arr[] = [0, -1, 2, -3, 1]
Output: [[0, 1, 4], [2, 3, 4]]
Explanation: Triplets with sum 0 are:
arr[0] + arr[1] + arr[4] = 0 + (-1) + 1 = 0
arr[2] + arr[3] + arr[4] = 2 + (-3) + 1 = 0
Input: arr[] = [1, -2, 1, 0, 5]
Output: [[0, 1, 2]]
Explanation: Only triplet which satisfies the condition is arr[0] + arr[1] + arr[2] = 1 + (-2) + 1 = 0
Input: arr[] = [2, 3, 1, 0, 5]
Output: [[]]
Explanation: There is no triplet with sum 0.**/

class Solution {
    public List<List<Integer>> findTriplets(int[] arr) {
        // Your code here
        Set<ArrayList<Integer>> res=new HashSet<>();
        Map<Integer,List<int []>> twosum=new HashMap<>();
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
    twosum.computeIfAbsent(arr[i]+arr[j],k->new ArrayList<>()).add(new int[] {i,j});
            }
        }
      for(int i=0;i<arr.length;i++){
          int r=-arr[i];
          if(twosum.containsKey(r)){
              List<int[]> pair=twosum.get(r);
              for(int[] p: pair){
                  if(p[0]!=i && p[1]!=i){
                      ArrayList<Integer> cur=new ArrayList<>(Arrays.asList(i,p[0],p[1]));
                      Collections.sort(cur);
                      res.add(cur);
                  }
              }
          }
      }
      return new ArrayList<>(res);
    }
}