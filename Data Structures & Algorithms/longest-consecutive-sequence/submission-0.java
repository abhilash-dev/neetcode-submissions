class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        if(n <= 1){
            return n;
        }

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            set.add(nums[i]);
        }

        int lcs = 1;
        int clcs = 1;
        for(int i = 0; i < n; i++){
            if(set.contains(nums[i]-1)){
                continue;
            }

            int j = nums[i];
            clcs=1;
            while(set.contains(++j)){
                clcs++;
            }
            lcs = Math.max(lcs, clcs);
        }

        return lcs;
    }
}
