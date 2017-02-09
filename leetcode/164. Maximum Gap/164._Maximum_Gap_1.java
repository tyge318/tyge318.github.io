public class Solution {
    public int maximumGap(int[] nums) {
        if( nums == null || nums.length < 2)
            return 0;
            
        int bucketSize = nums.length-1;
        int minBucket[] = new int[bucketSize];
        int maxBucket[] = new int[bucketSize];
        int max = nums[0], min = nums[0];
        for(int i=0; i<nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        int gap = (int)Math.ceil((double)(max-min)/bucketSize);
        Arrays.fill(minBucket, Integer.MAX_VALUE);
        Arrays.fill(maxBucket, Integer.MIN_VALUE);
        
        for(int i: nums) {
            if( i == min || i == max )  continue;
            int id = (i-min)/gap;
            minBucket[id] = Math.min(i, minBucket[id]);
            maxBucket[id] = Math.max(i, maxBucket[id]);
        }
        
        //System.out.println("minBucket = " + Arrays.toString(minBucket) );
        //System.out.println("maxBucket = " + Arrays.toString(maxBucket) );
        
        int ans = 0;
        int prev = min;
        for(int i=0; i<bucketSize; i++) {
            if( minBucket[i] == Integer.MAX_VALUE && maxBucket[i] == Integer.MIN_VALUE)
                continue;
            ans = Math.max(ans, minBucket[i]-prev);
            prev = maxBucket[i];
        }
        ans = Math.max(ans, max - prev);
        return ans;
    }
}