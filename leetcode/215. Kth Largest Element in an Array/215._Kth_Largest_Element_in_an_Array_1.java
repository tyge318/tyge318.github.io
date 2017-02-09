public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i=0; i<nums.length; i++) {
            if( pq.size() >= k ) {
                if( nums[i] < pq.peek() )
                    continue;
                pq.poll();
            }
            pq.add(nums[i]);
        }
        //System.out.println("pq = " + pq.toString());
        return pq.poll();
    }
}