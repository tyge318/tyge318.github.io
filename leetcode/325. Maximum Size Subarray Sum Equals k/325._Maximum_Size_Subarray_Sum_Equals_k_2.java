public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, max = 0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i]; //sum = sum of index 0 to i
            if( sum == k )
                max = i+1;
            else if( map.containsKey(sum-k) ) //x+k = sum, if x exists (sum of index 0 to j), then k exists (sum of j+1 to i).
                max = Math.max(max, i - map.get(sum-k) );
            if( !map.containsKey(sum))
                map.put(sum, i);
        }
        return max;
    }
}