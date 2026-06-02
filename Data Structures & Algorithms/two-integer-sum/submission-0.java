class Solution {
    /*
     - Since we need the indices, we can't really mess with the ordering. Else, we could sort & use a 2 pointer approach 
     - Do a forward pass, and keep track of seen values & corresponding index in a map
     - At every index, we check to see if we've seen the complement of the current index value before
      - If yes, we return the corresponding index & the current index (i, j)
      - Else, we add the current value & index into the map & continue
    - If we reach the end and still not found, then return [-1, -1] (However, constraints say they do!)

    Time: O(n) where n is the length of the nums array
    Space: O(n) where n is the length of the nums array i.e., we could end up storing almost all elements
    */
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        if(n < 2){
            return new int[]{-1, -1};
        }

        Map<Integer, Integer> seen = new HashMap<>();

        for(int i = 0; i < n; i++){
            int complement = target - nums[i];

            if(seen.containsKey(complement)){
                return new int[]{seen.get(complement), i};
            }else{
                seen.put(nums[i], i);
            }
        }

        return new int[]{-1, -1};
    }
}
