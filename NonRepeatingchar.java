/*Given a string s consisting of lowercase Latin Letters. Return the first non-repeating character in s. If there is no non-repeating character, return '$'.
Note: When you return '$' driver code will output -1.

Examples:

Input: s = "geeksforgeeks"
Output: 'f'
Explanation: In the given string, 'f' is the first character in the string which does not repeat.*/


class Solution {
    // Function to find the first non-repeating character in a string.
    static char nonRepeatingChar(String s) {
        // Your code here
      HashMap<Character,Integer> m=new HashMap<>();
     
     
     for(char c:s.toCharArray()){
         m.put(c,m.getOrDefault(c,0)+1);
     }
     for(char c:s.toCharArray()){
         if(m.get(c)==1)
         return c;
     }
      return '$';
    }
}
