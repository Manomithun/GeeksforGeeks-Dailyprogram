
//Rotate the array d times
class Solution {
    // Function to rotate an array by d elements in counter-clockwise direction.
    static void rotateArr(int arr[], int d) {
        // add your code here
        d=d%arr.length;
        int ar[]=new int[d];
        for(int i=0;i<d;i++){
           ar[i]=arr[i];
        }
        int k=0;
        for(int i=d;i<arr.length;i++){
            arr[i-d]=arr[i];
        }
        for(int i=arr.length-d;i<arr.length;i++){
            arr[i]=ar[k++];
        }
    }
}