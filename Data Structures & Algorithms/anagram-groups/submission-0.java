class Solution {
    /*
        - finding anagram itself is trivial, i.e., char frequency of both strs are same
        - We need to know if 2 strings are anagrams of each other and group them efficiently
         - one way is if we can figure out a hash of all strings, then we can just map hash -> list of matching anagram strings
         - iterate over this map & extract the List of lists i.e., groups and return
        
        Time: O(m + n) where m is the avg length of the string and n is the total no. of strings
        Space: O(m + n) where m is the avg length of the string and n is the total no. of strings
    */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        
        for(String s: strs){
            String sHash = getHash(s);
            groups.computeIfAbsent(sHash, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(groups.values());
    }

    /*
        return a sorted concatenated c{freq} as a hash given a string input

        Time: O(m) where m is the length of the input string
        Space: O(m)  where m is the length of the input string
    */
    public String getHash(String s){
        int[] freq = new int[26];
        int n = s.length();

        for(int i = 0; i < n; i++){
            freq[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++){
            char c = (char) ('a' + i);
            sb.append(c);
            sb.append(freq[i]);
        }

        return sb.toString();
    }
}