/*  According to the problem definition, ans = max of m subarray sums.
    => ans >= sum_1, ans >= sum_2, ..., ans >= sum_m
    => m*ans >= sum_1+sum_2+...+sum_m = sum of array
    => ans >= (sum of array)/m
*/
public class Solution {
    public int splitArray(int[] nums, int m) {
        long min = 0, max = 0;
        for(int i: nums) {
            max += i;
            min = Math.max(min, i);
        }
        while( min <= max ) {
            long mid = (min+max)/2;
            if( eachGreaterThanMid(mid, nums, m) )
                max = mid-1;
            else
                min = mid+1;
        }
        return (int)min;
    }
    /* Whether we can divide nums[] into no more than m parts, where sum of each parts is at lest mid. */
    public boolean eachGreaterThanMid(long mid, int[] nums, int m) {
        int count = 1;
        long sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            if( sum > mid) {
                sum = nums[i];
                count++;
                if( count > m)
                    return false;
            }
        }
        return true;
    }
}