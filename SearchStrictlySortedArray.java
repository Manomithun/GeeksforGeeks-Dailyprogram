
/***Given a strictly sorted 2D matrix mat[][] of size n x m and a number x. Find whether the number x is present in the matrix or not.
Note: In a strictly sorted matrix, each row is sorted in strictly increasing order, and the first element of the ith row (i!=0) is greater than the last element of the (i-1)th row.

Examples:

Input: mat[][] = [[1, 5, 9], [14, 20, 21], [30, 34, 43]], x = 14
Output: true
Explanation: 14 is present in the matrix, so output is true.***/


class Solution {
    // Function to search a given number in row-column sorted matrix.
    public boolean searchMatrix(int[][] mat, int x) {
        // code here
        int row=mat.length-1;
        int col=mat[0].length-1;
        while(row>=0 && col>=0){
            if(mat[row][0]==x) return true;
            
          else{
              if(mat[row][col]==x) return true;
              if(mat[row][0]>x){
                  col=mat[0].length-1;
                  row--;
              } 
              else if(mat[row][0]<=x && mat[row][col]>=x){
                  col--;
              }
              else
               break;
          }
        }
        return false;
    }
}