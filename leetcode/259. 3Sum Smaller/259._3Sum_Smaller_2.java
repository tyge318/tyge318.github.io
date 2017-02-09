public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if( nums.length < 3)
            return 0;
        Arrays.sort(nums);
        int ans = 0;
        for(int i=0; i<nums.length-2; i++) {
            int first = nums[i], ctarget = target - first;
            int left = i+1, right = nums.length-1;
            while(left < right) {
                if( nums[left]+nums[right] < ctarget) {
                    ans += (right -left);
                    left++;
                }
                else
                    right--;
            }
        }
        return ans;
    }
}