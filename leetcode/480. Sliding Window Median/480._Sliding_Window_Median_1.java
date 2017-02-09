public class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        Queue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return -Integer.compare(a, b);
            }    
        });
        Queue<Integer> minHeap = new PriorityQueue<>();
        double[] ans = new double[nums.length-k+1];
        
        //intitialize
        for(int i=0; i<k; i++) {
            maxHeap.add(nums[i]);
            minHeap.add(nums[i]);
            if( k % 2 == 0) {
                if( maxHeap.size() > k/2)   maxHeap.poll();
                if( minHeap.size() > k/2)   minHeap.poll();
            }
            else {
                if( maxHeap.size() > k/2+1) maxHeap.poll();
                if( minHeap.size() > k/2)   minHeap.poll();
            }
        }
        //System.out.println("maxHeap = " + maxHeap.toString() + "; minHeap = " + minHeap.toString());
        int index = 0;
        ans[index++] = (k%2 == 0) ? ((double)maxHeap.peek()+(double)minHeap.peek())/2 : maxHeap.peek();
        for(int i=k; i<nums.length; i++) {
            double currentMedian = ans[index-1];
            Integer tosser = nums[i-k];
            Integer adder = nums[i];
            
            if( tosser <= currentMedian) {
                maxHeap.remove(tosser);
                if( !minHeap.isEmpty() && adder >= minHeap.peek() ) {
                    maxHeap.add(minHeap.poll());
                    minHeap.add(adder);
                }
                else
                    maxHeap.add(adder);
            }
            else {
                minHeap.remove(tosser);
                if( adder < maxHeap.peek()) {
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(adder);
                }
                else
                    minHeap.add(adder);
            }
            //System.out.println("maxHeap = " + maxHeap.toString() + "; minHeap = " + minHeap.toString());
            ans[index++] = (k%2 == 0) ? ((double)maxHeap.peek()+(double)minHeap.peek())/2 : maxHeap.peek();
        }
        return ans;
    }
}