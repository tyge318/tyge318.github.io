public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0)
            return 0;
        List<Integer> opt = new ArrayList<Integer>();    //opt[i] = solution for subarray nums[0:i]
        for(int i=0; i<nums.length; i++)
            opt.add(1);
            
        for(int i=0; i<nums.length; i++) {
            for(int j=0; j<i; j++) {
                if( nums[i] > nums[j] ) {
                    int opt_i = Math.max( opt.get(i), opt.get(j)+1 );
                    opt.set(i, opt_i);
                }
            }
        }
        return Collections.max(opt);
    }
}