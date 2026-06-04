class Solution {
    /*
        - We have two pointers(l, r) from either corners and we compare them as they move towards each other
        - at every step,
         - we skip until it's an alpha-numeric character
         - we compare it with lower case to ignore the case
         - we return eagerly at the very first mis-match
         - if they go over each other ie.., (l > r) then it's a valid palindrome
        - A single character is also a valid palindrome? Empty (ignoring non alpha-numeric?)

        time: O(n) where n is the length of the string
        Space: O(1) just constants

        Test cases:
        - empty string
        - string with one character
         - alphanumeric
         - non-alphanumeric
        - string with multiple characters
         - all non-alphanumeric
         - all non-alphanumeric with only one valid char
         - all alphanumeric but not palindrome
         - all alphanumeric and palindrome
         - mixture of alpha & non-alpha numeric and palindrome
         - mixture of alpha & non-alpha numeric and not palindrome  
    
    */
    public boolean isPalindrome(String s) {
        int n = s.length();

        if(n == 1){
            return true;
        }

        int l = 0;
        int r = n-1;

        while(l <= r){
            while(l <= r && !Character.isLetterOrDigit(s.charAt(l))){
                l++;
            }

            if(l > r){
                return true;
            }

            while(l <= r && !Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }

            if(l > r){
                return true;
            }

            if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
                return false;
            }

            l++;
            r--;

        }

        return true;
    }
}
