class Solution {
    public boolean isAnagram(String s, String t) {
        // check if string length's are different
        int m = s.length();
        int n = t.length();

        if (m != n){
            return false;
        }

        Map<Character, Integer> a = new HashMap<>();
        Map<Character, Integer> b = new HashMap<>();

        for(char c: s.toCharArray()){
            a.put(c, a.getOrDefault(c, 0)+1);
        }

        for(char c: t.toCharArray()){
            b.put(c, b.getOrDefault(c, 0)+1);
        }

        // check if unique char's are different
        if (a.size() != b.size()){
            return false;
        }

        // check if the char count is same across the strings
        for(Map.Entry<Character, Integer> e: a.entrySet()){
            if(!Objects.equals(e.getValue(), b.get(e.getKey()))){
                return false;
            }
        }

        // if all else fails, it is an Anagram
        return true;
    }
}
