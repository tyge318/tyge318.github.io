public class HitCounter {
    int[] times;
    int[] counts;
    /** Initialize your data structure here. */
    public HitCounter() {
        times = new int[300];
        counts = new int[300];
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int index = timestamp % 300;
        if( times[index] != timestamp ) {   //300 seconds ago, we can just reset
            times[index] = timestamp;
            counts[index] = 1;
        }
        else
            counts[index]++;
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int ans = 0;
        for(int i=0; i<300; i++) {
            if(timestamp - times[i] < 300) {
                ans += counts[i];
            }
        }
        return ans;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */