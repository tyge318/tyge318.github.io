public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int ans = 0;
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++) {
            int left = i+1, right = nums.length-1;
            while( left < right ) {
                if( nums[left]+nums[right] >= target - nums[i] )
                    right--;
                else {
                    ans += (right - left);
                    left++;
                }
            }
        }
        return ans;
    }
}