class Solution:
    def replaceElements(self, arr: List[int]) -> List[int]:
        '''
            - This is the easy version of class prefix / suffix array based problem
            - The core idea here is to start from the right side of the array, at evey index,
            i'm keeping track of the what's the max. num to my right
             - Naive way: to have an additional array that say at any given index, the max. no. to my right
             - Optimized: we only need to check the next item with the max. so far & update if necessary

            time: O(n) where n is the size of the array
            space: O(1) in the optimized approach

            Test cases:
            - 0 elements in the array
            - all elements are equal
            - Descending ordered array
            - Ascending ordered array
        '''


        n = len(arr)

        if n == 0:
            return arr
        
        if n == 1:
            return [-1]

        max_num = arr[n-1]
        res = [-1] * n
        i = n-2
        while(i >= 0):
            res[i] = max_num
            max_num = max(arr[i], max_num)
            i-=1
        
        return res