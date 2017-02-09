public class Solution {
    public int minMoves2(int[] nums) {
        int median = findKth(nums, nums.length/2+1);
        int ans = 0;
        for(int i=0; i<nums.length; i++) {
            ans += Math.abs(nums[i] - median);
        }
        return ans;
    }
    public int findKth(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i=0; i<nums.length; i++) {
            if( pq.size() >= k) {
                if( nums[i] < pq.peek() )
                    continue;
                pq.poll();
            }
            pq.add(nums[i]);
        }
        return pq.poll();
    }
}