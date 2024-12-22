/**Search in a Row-Column sorted matrix
Difficulty: EasyAccuracy: 41.62%Submissions: 146K+Points: 2
Given a 2D integer matrix mat[][] of size n x m, where every row and column is sorted in increasing order and a number x, the task is to find whether element x is present in the matrix.

Examples:

Input: mat[][] = [[3, 30, 38],[20, 52, 54],[35, 60, 69]], x = 62
Output: false
Explanation: 62 is not present in the matrix, so output is false.
Input: mat[][] = [[18, 21, 27],[38, 55, 67]], x = 55
Output: true
Explanation: 55 is present in the matrix.**/


class Solution {
    public static boolean matSearch(int mat[][], int x) {
        // your code here
        int row=0;
        int col=mat[0].length-1;
        while(col>=0 && row<mat.length){
            if(mat[row][col]==x) return true;
            else if(mat[row][col]>x) col--;
            else row++;
        }
        return false;
    }
}