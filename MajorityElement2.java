/*You are given an array of integer arr[] where each number represents a vote to a candidate. Return the candidates that have votes greater than one-third of the total votes, If there's not a majority vote, return an empty array. 

Note: The answer should be returned in an increasing format.*/
class Solution {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(int[] nums) {
        // Your code goes here.
        List<Integer>a=new ArrayList<>();
        Arrays.sort(nums);
		int n=nums.length/3;
		int t=nums[0]-1;
		int t1=-1;
	    int count=1;
	    if(n==0){
	        for (int num:nums) {
            a.add(num);
            
        }
        return a;
	    }
	    
	    for(int i=0;i<nums.length;i++){
	        if(t==nums[i]){
	            count++;
	            if(count>=n && t1!=nums[i]){
	                t1=nums[i];
	               a.add(t);
	            }
	        }
	        else{
	            t=nums[i];
	            count=1;
	        }
	    }
	    Collections.sort(a);
	    return a;
    }
}
