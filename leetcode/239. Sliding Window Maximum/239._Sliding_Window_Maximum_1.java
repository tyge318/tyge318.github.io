public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if( nums == null || nums.length == 0 || k <= 0)
            return new int[0];
        int n = nums.length;
        int[] ans = new int[n-k+1];
        int ai = 0;
        Deque<Integer> liveIndexQ = new LinkedList<>();
        for(int i=0; i<nums.length; i++) {
            while( !liveIndexQ.isEmpty() && i - liveIndexQ.peek() + 1 > k ) //remove elements too old (k away from current)
                liveIndexQ.poll();
            while( !liveIndexQ.isEmpty() && nums[liveIndexQ.peekLast()] < nums[i] ) //remove new elements too small
                liveIndexQ.pollLast();
            liveIndexQ.offer(i);
            if( i >= k-1 )
                ans[ai++] = nums[liveIndexQ.peek()];
        }
        return ans;
    }
}