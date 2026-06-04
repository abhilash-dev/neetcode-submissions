class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        // [-1,0,1,2,-1,-4], n = 6
        if(n < 3){
            return List.of();
        }
        
        Arrays.sort(nums);
        // [-4,-1,-1,0,1,2]
        //           i j   k

        int i = 0;
        List<List<Integer>> res = new ArrayList<>(); // [(-1, -1, 2)]

        // 0+2 < 6
        while(i+2 < n){

            int j = i+1; // 3
            int k = n-1; // 5

            // 3 < 5
            while(j < k){
                
                // 2
                int sum = nums[j] + nums[k];
                // -1 +2 = -1
                if(sum + nums[i] == 0){
                    res.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while(j < k && nums[j]==nums[j-1]){
                        j++; 
                    }

                    while(j < k && nums[k+1]==nums[k]){
                        k--;
                    }
                }else if(sum > (-1 * nums[i])){
                    k--;
                }else{
                    j++; // 4
                }
            }

            while(i+2 < n && nums[i] == nums[i+1]){
                i++;
            }

            i++;
        }

        return res;
    }
}