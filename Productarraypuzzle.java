/**Product array puzzle
Difficulty: EasyAccuracy: 33.46%Submissions: 272K+Points: 2
Given an array, arr[] construct a product array, res[] where each element in res[i] is the product of all elements in arr[] except arr[i]. Return this resultant array, res[].
Note: Each element is res[] lies inside the 32-bit integer range.

Examples:

Input: arr[] = [10, 3, 5, 6, 2]
Output: [180, 600, 360, 300, 900]
Explanation: For i=0, res[i] = 3 * 5 * 6 * 2 is 180.
For i = 1, res[i] = 10 * 5 * 6 * 2 is 600.
For i = 2, res[i] = 10 * 3 * 6 * 2 is 360.
For i = 3, res[i] = 10 * 3 * 5 * 2 is 300.
For i = 4, res[i] = 10 * 3 * 5 * 6 is 900.
Input: arr[] = [12, 0]
Output: [0, 12]
Explanation: For i = 0, res[i] is 0.
For i = 1, res[i] is 12.
Constraints:
2 <= arr.size() <= 105
-100 <= arr[i] <= 100

**/


//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob = new Solution();
            int[] ans = new int[n];
            ans = ob.productExceptSelf(arr);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            System.out.println("~");
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int[] productExceptSelf(int arr[]) {
        // code here
        int brr[]=new int[arr.length];
        boolean a=false;
    int p=1;
        int c=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                c++;
                a=true;
            }
        }
        if(c>1){
        for(int i=0;i<arr.length;i++)
        brr[i]=0;
        return brr;
        }
        else if(c==0 ||c==1){
            for(int i=0;i<arr.length;i++){
                if(arr[i]==0)p*=1;
                else p*=arr[i];
            }
            for(int i=0;i<arr.length;i++){
                if(arr[i]==0) brr[i]=p;
                else if(a) brr[i]=0;
                else brr[i]=p/arr[i];
            }
        }
        return brr;
        
    }
}
