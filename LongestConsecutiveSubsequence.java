/**
Longest Consecutive Subsequence
Difficulty: MediumAccuracy: 33.0%Submissions: 339K+Points: 4
Given an array arr[] of non-negative integers. Find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.

Examples:

Input: arr[] = [2, 6, 1, 9, 4, 5, 3]
Output: 6
Explanation: The consecutive numbers here are 1, 2, 3, 4, 5, 6. These 6 numbers form the longest consecutive subsquence.
Input: arr[] = [1, 9, 3, 10, 4, 20, 2]
Output: 4
Explanation: 1, 2, 3, 4 is the longest consecutive subsequence.
Input: arr[] = [15, 13, 12, 14, 11, 10, 9]
Output: 7
Explanation: The longest consecutive subsequence is 9, 10, 11, 12, 13, 14, 15, which has a length of 7.
**/

class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        // code here
        Set<Integer> s=new HashSet<>();
        for(int a:arr){
            s.add(a);
        }
        int max=0;
        for(int a:s){
            if(!s.contains(a-1)){
                int j=a;
                while(s.contains(j)){
                    j++;
                }
                max=Math.max(max,j-a);
            }
            
        }
        return max;
    }
}