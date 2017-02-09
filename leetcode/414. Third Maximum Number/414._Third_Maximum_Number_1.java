public class Solution {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        
        for(int i=0; i<nums.length; i++) {
            int current = nums[i];
            if( minHeap.contains(new Integer(current)) )
                continue;
            if( minHeap.size() == 3) {
                minHeap.add(current);
                minHeap.poll();
            }
            else    
                minHeap.add(current);
        }
        int ans = minHeap.peek();
        if( minHeap.size() == 3)
            return ans;
        else {
            while( !minHeap.isEmpty() )
                ans = minHeap.poll();
            return ans;
        }
    }
}