/**Create a spiral matrix of N*M size from given array
Difficulty: MediumAccuracy: 79.85%Submissions: 962+Points: 4
You are given two positive integers n and m, and an integer array arr[] containing total (n*m) elements. Return a 2D matrix of dimensions n x m by filling it in a clockwise spiral order using the elements from the given array.

Examples:

Input: n = 4, m = 4, arr[] = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]
Output: [[1, 2, 3, 4],
        [12, 13, 14, 5],
        [11, 16, 15, 6],
        [10, 9, 8, 7]]
Input: n = 3, m = 4, arr[] =[1, 8, 6, 3, 8, 6, 1, 6, 3, 2, 5, 3]
Output: [[1, 8, 6, 3],
        [2, 5, 3, 8],
        [3, 6, 1, 6]]**/

class Solution {
    public int[][] spiralFill(int n, int m, int[] arr) {
        // code here
        int a=0;
        int brr[][]=new int[n][m];
        int l=0;
        int r=m-1;
        int top=0;
        int bot=n-1;
        while(l<=r && top<=bot){
            for(int i=l;i<=r;i++){
                brr[top][i]=arr[a++];
            }
            top++;
            for(int i=top;i<=bot;i++){
                brr[i][r]=arr[a++];
            }
            r--;
            if(top<=bot)
                for(int i=r;i>=l;i--){
                    brr[bot][i]=arr[a++];
                }
                bot--;
            
        if(l<=r)
                for(int i=bot;i>=top;i--){
                    brr[i][l]=arr[a++];
                }
                l++;
            
            
        }
        return brr;
    }
}
