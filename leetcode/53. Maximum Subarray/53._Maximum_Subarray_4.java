public class Solution {
    public int maxSubArray(int[] nums) {
        List<Integer> opt = new ArrayList<Integer>(); //max from 0 to i;
        opt.add(nums[0]);
        for(int i=1; i<nums.length; i++) {
            opt.add( Math.max(opt.get(i-1)+nums[i], nums[i]) );
        }
        return Collections.max(opt);
    }
}