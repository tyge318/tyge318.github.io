public class Solution {
    public void rotate(int[] nums, int k) {
        if( k >= nums.length )
            k %= nums.length;
        if( k == 0 )
            return;
        int temp[] = new int[nums.length*2];
        for(int i=0; i<nums.length; i++)
            temp[i] = nums[i];
        for(int i=nums.length; i<2*nums.length; i++)
            temp[i] = nums[i-nums.length];
        //System.out.println(Arrays.toString(temp));
        System.arraycopy(temp, (nums.length-k), nums, 0, nums.length);
        //System.out.println(Arrays.toString(nums));
        return;
    }
}