/*
lower <= sum(nums[i to j]) <= upper
acc_sum[i] = sum(nums[0 to i])
=> target = acc_sum[j] - acc_sum[i-1];
count the number of targets that meet the condition
number of targets in [0 to n] = number of targets in [0 to n/2] + number of targets in [n/2+1 to n]
*/
public class Solution {
    long[] acc_sum;
    int lower, upper;
    public int countRangeSum(int[] nums, int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
        acc_sum = new long[nums.length];
        if( nums.length == 0)
            return 0;
        for(int i=0; i<nums.length; i++)
            acc_sum[i] = ((i-1) < 0 ? 0 : acc_sum[i-1]) + nums[i];
        
        return countValid(nums, 0, nums.length-1);
    }
    public int countValid(int[] nums, int begin, int end) {
        if( begin == end ) {
            //if the only number left satisfies the condition
            if( nums[begin] >= lower && nums[end] <= upper)
                return 1;
            return 0;
        } 
        int mid = (begin+end)/2;
        int ans = 0;
        for(int i=begin; i<=mid; i++) {
            for(int j=mid+1; j<=end; j++) {
                long target = acc_sum[j] - ((i-1 >= 0) ? acc_sum[i-1]: 0);
                if( target >= lower && target <= upper)
                    ans++;
            }
        }
        ans += (countValid(nums, begin, mid) + countValid(nums, mid+1, end));
        return ans;
    }
}