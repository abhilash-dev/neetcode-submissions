class Solution {
    /*
     - two pointers from either end, while keeping track of max heights seen as they converge
     - at every step, the core idea is to check what is the amount of water that can be trapped in this location
     - we do that by identifying the max heights on either end (which acts as outer wall)
     - we take the min. of it given this is where it can overflow
     - subtract the current elevation height from it
     - and cumulatively sum all of this as we traverse until either pointers coverge
     - the cumulative sum is the total amount of water trapped


     Time: O(n) where n is the total no. of elements in the list
     Space: O(1)
    
    Test Cases:
    - height.lenth < 3 - need atleast 3 height bars to trap any amount of water
    - height all zeros - 0 trapped water
    - heights of the form cone / triangle - 0 trapped water
    - a happy case
    */
    public int trap(int[] height) {
        int n = height.length;

        if(n < 3){
            return 0;
        }

        int maxTrappedWater = 0;
        int l = 0;
        int r = n-1;
        int lmax = height[l];
        int rmax = height[r];

        while(l <= r){
            lmax = Math.max(lmax, height[l]);
            rmax = Math.max(rmax, height[r]);

            if(height[l] < height[r]){
                maxTrappedWater += (Math.max(Math.min(lmax, rmax)-height[l],0));
                l++;
            }else{
                maxTrappedWater += (Math.max(Math.min(lmax, rmax)-height[r],0));
                r--;
            }
        }

        return maxTrappedWater;
    }
}
