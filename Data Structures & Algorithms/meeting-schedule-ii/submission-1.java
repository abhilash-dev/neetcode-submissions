/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();

        if(n < 2){
            return n;
        }

        PriorityQueue<Interval> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.end, b.end));
        int minRooms = 1;
        Collections.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));
        for(Interval interval: intervals){
            while(!pq.isEmpty() && pq.peek().end <= interval.start){
                pq.poll();
            }

            pq.offer(interval);
            minRooms = Math.max(minRooms, pq.size());
        }

        return minRooms;
    }
}
