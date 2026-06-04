class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;

        if(n < 2){
            return new int[]{-1, -1};
        }

        int l = 0;
        int r = n-1;

        while(l < r){
            int sum = numbers[l] + numbers[r];
            
            if(sum == target){
                return new int[]{l+1, r+1};
            }

            if(sum > target){
                r--;
            }

            if(sum < target){
                l++;
            }
        }

        return new int[]{-1, -1};
    }
}
