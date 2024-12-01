
/*Given two strings s1 and s2 consisting of lowercase characters. The task is to check whether two given strings are an anagram of each other or not. An anagram of a string is another string that contains the same characters, only the order of characters can be different. For example, act and tac are an anagram of each other. Strings s1 and s2 can only contain lowercase alphabets.

Note: You can assume both the strings s1 & s2 are non-empty.

Examples :

Input: s1 = "geeks", s2 = "kseeg"
Output: true
Explanation: Both the string have same characters with same frequency. So, they are anagrams.*/



class Solution {
    // Function is to check whether two strings are anagram of each other or not.
    public static boolean areAnagrams(String s1, String s2) {
        if(s1.length()!=s2.length())
             return false;
       int fre[]=new int[256];
       for(int i=0;i<s1.length();i++){
           fre[s1.charAt(i)]++;
           fre[s2.charAt(i)]--;
           
       }
       for(int i:fre){
           if(i!=0)
             return false;
       }
       return true;
    }
}