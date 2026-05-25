class Solution:
    def getConcatenation(self, nums: List[int]) -> List[int]:
        '''
            - capture the length of the existing array say 'n'
            - create a new array (ans) with size 2 * n
            - do a loop i = 0 to 2n with %n (iterates twice the size) & copy over elements twice
            - return the final ans

            Space Complexity: O(n)
            Time Complexity: O(n)

            Edge case:
             - input nums length (n) = 0

            Test case:
            1. [1,4,1,2]
        '''
        

        n = len(nums) # 4

        if n == 0: # 4 > 0
            return []
        
        ans = [0] * (2*n) # len(ans) = 8, ans = [1,4,1,2,1,4,1,2]

        for i in range(2*n): # 0 -> 7
            ans[i] = nums[i%n] # 0 = 0%4 = 0
        

        return ans
        