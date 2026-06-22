class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;

        if(n < 2){
            return 0;
        }

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        int eraseCount = 0;
        int prevEnd = intervals[0][1];
        for(int i = 1; i < n; i++){
            // if they overlap
            if(prevEnd > intervals[i][0]){
                prevEnd = Math.min(prevEnd, intervals[i][1]);
                eraseCount++;
            }else{
                prevEnd = intervals[i][1];
            }
        }

        return eraseCount;
    }
}
