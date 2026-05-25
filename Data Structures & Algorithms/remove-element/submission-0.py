class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        '''
            - keep a 2nd pointer at the end of the array (say j) and j-=1 until nums[j] == val and i <= j
            - loop through the array from left -> right (i <= j)
                - if nums[i] == val, swap nums[i] with nums[j], increment the swap counter (k), j-=1
                - return k (swap counter)
            Time: O(n)
            Space: O(1)

            Edge Cases:
             - val isn't in nums
             - val is the last element
             - nums is already arranged in a way that all vals are at the end
             - all of nums are just vals
        '''

        n = len(nums)

        if n == 0:
            return 0
        
        if n == 1:
            if nums[0] == val:
                return 0
            else:
                return 1
        i = 0
        j = n - 1
        while(i <= j):
            if nums[i] == val:
                nums[i], nums[j] = nums[j], nums[i]
                j-=1
            else:
                i+=1

        return i