public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int opt[] = new int[target+1];
        opt[0] = 1;
        for(int i=1; i<=target; i++) {
            for(int j=0; j<nums.length; j++) {
                if( nums[j] > i)    continue;
                opt[i] += opt[i-nums[j]];
            }
        }
        //System.out.println(Arrays.toString(opt));
        return opt[target];
    }
}