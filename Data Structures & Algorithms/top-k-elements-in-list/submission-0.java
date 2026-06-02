class Solution {
    /*
        Intuition
        - Create a frequency map by looping through nums
        - Have a min-heap while iterating over the distinct vals & sorted by the freq while keeping atmost k items
        - return the k remaining values as output

        Edge cases:
        - k > n (total no. of elements)
        - k > n (distinct values in nums)

        Time: O (m + n log k) ~ O(m log k) where m is the total num of elements, n is the total distinct values & k is the reqested frequent elements
        Space: O (n + k) ~ O(m) where m is the total no. of elements, all unique and freq-map >> minHeap
    */
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        if(k > n){
            return new int[]{};
        }

        Map<Integer, Integer> freq = new HashMap<>();
        for(int i: nums){
            freq.put(i, freq.getOrDefault(i, 0)+1);
        }

        if(k > freq.size()){
            return new int[]{};
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(freq.get(a),freq.get(b)));

        for(Map.Entry<Integer, Integer>e : freq.entrySet()){
            pq.add(e.getKey());

            if(pq.size() > k){
                pq.poll();
            }
        }

        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = pq.poll();
        }

        return res;
    }
}
