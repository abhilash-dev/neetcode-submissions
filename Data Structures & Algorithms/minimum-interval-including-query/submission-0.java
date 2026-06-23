class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        // 1. sort the intervals by start time i.e., intervals[i][0]
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // 2. Make a copy of queries & sort the queries copy in asc order
        int[] sortedDistinctQueries = Arrays.stream(queries).distinct().sorted().toArray();

        // 3. Initialize a minHeap based on the interval size order
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[2], b[2]));

        // 4. Iterate through sorted queries copy (while skipping duplicates)
        int i = 0;
        int j = 0;
        int n = sortedDistinctQueries.length;
        Map<Integer, Integer> queryToShortestIntervalLength = new HashMap<>();
        while(j < n){
            // 5. for every distinct query, insert all intervals which start on / before the query
            while(i < intervals.length && intervals[i][0] <= sortedDistinctQueries[j]){
                int start = intervals[i][0];
                int end = intervals[i][1];
                int len = end - start + 1;
                pq.offer(new int[]{start, end , len});
                i++;
            }

            // 6. The pq's top should now hold the interval with shortest length, save this to map {query: shortest interval length} (this later helps with duplicates)
            // 7. Before step 6, we should pop() the top until it's a valid interval / empty (i.e., start <= query <= end)
            // 8. if pq is empty then record {query: -1} in the map
            while(!pq.isEmpty() && pq.peek()[1] < sortedDistinctQueries[j]){
                pq.poll();
            }

            if(pq.isEmpty()){
                queryToShortestIntervalLength.put(sortedDistinctQueries[j],-1);
            }else{
                queryToShortestIntervalLength.put(sortedDistinctQueries[j], pq.peek()[2]);
            }

            j++;
        }
        
        // 9. initialize a result array of size queries and while iterating queries, fill result = map[query] and return result
        int[] res = new int[queries.length];
        for(int k = 0; k < queries.length; k++){
            res[k] = queryToShortestIntervalLength.get(queries[k]);
        }

        return res;
    }
}
