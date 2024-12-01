/*Given two strings s1 and s2 consisting of lowercase characters. The task is to check whether two given strings are an anagram of each other or not. An anagram of a string is another string that contains the same characters, only the order of characters can be different. For example, act and tac are an anagram of each other. Strings s1 and s2 can only contain lowercase alphabets.

Note: You can assume both the strings s1 & s2 are non-empty.

Examples :

Input: s1 = "geeks", s2 = "kseeg"
Output: true
Explanation: Both the string have same characters with same frequency. So, they are anagrams.*/



class Solution {
    public int myAtoi(String s) {
        // Your code here
        int i=0 ,n=s.length();
        while(i<n && s.charAt(i)==' '){
            i++;
        }
        int a =1;
        if(i<n && (s.charAt(i)=='-' || s.charAt(i)=='+')){
        a=s.charAt(i)=='-'?-1:1;
        i++;
        }
        long r=0;
        while(i<n && Character.isDigit(s.charAt(i))){
            r=r*10+(s.charAt(i) - '0');
            
        
        if(a*r>Integer.MAX_VALUE)
         return Integer.MAX_VALUE;
        if(a*r<Integer.MIN_VALUE)
        return Integer.MIN_VALUE;
        i++;
        }
        
        return (int)(a*r);

    }
}