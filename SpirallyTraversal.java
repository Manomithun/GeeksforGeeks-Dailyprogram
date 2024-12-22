/**
Spirally traversing a matrix

You are given a rectangular matrix mat[][] of size n x m, and your task is to return an array while traversing the matrix in spiral form.

Examples:

Input: mat[][] = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12], [13, 14, 15, 16]]
Output: [1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]
**/
class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int mat[][]) {
        // code here
        int l=0;
        int h=mat[0].length-1;
        int top=0;
        int bot=mat.length-1;
        ArrayList<Integer> A=new ArrayList<>();
        while(top<=bot && l<=h){
            for(int i=l;i<=h;i++){
                A.add(mat[top][i]);
            }
            top++;
            for(int i=top;i<=bot;i++){
                A.add(mat[i][h]);
            }
            h--;
            if(top<=bot){
            for(int i=h;i>=l;i--){
                A.add(mat[bot][i]);
            }
            bot--;
            }
            if(l<=h){
            for(int i=bot;i>=top;i--){
                A.add(mat[i][l]);
            }
            l++;
            }
        }
        return A;
    }
}
