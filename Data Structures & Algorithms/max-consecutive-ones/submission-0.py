class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        '''
            - imagine a 2 pointer window, we are trying maximize the window with 1's
            - start with l = r = 0 and run the r until l != r & r < n, if l = 0, then update ans else return max

            Time: O(n)
            Space: O(1)

        '''    

        n = len(nums)

        if n == 0:
            return 0
        
        if n == 1:
            return 1 if nums[0] == 1 else 0
        
        max_count = 0
        count = 0
        for i in range(n):
            if nums[i] == 1:
                count += 1
            else:
                max_count = max(count, max_count)
                count = 0
        
        max_count = max(count, max_count)
        return max_count