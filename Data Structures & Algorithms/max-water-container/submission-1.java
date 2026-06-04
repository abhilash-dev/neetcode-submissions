class Solution {
    public int maxArea(int[] heights) {
        int maxContainer = 0;

        int n = heights.length;

        if(n < 2){
            return 0;
        }

        int l = 0;
        int r = n-1;
        while(l < r){
            int area = (Math.min(heights[l], heights[r])) * (r-l);
            maxContainer = Math.max(maxContainer, area);

            if(heights[l] < heights[r]){
                l++;
            }else{
                r--;
            }
        }

        return maxContainer;
    }
}
