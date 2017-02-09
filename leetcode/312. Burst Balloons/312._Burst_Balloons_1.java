public class Solution {
    public int maxCoins(int[] nums) {
        int[] array = new int[nums.length+2];
        array[0] = 1;
        array[array.length-1] = 1;
        for(int i=0; i<nums.length; i++)
            array[i+1] = nums[i];
        
        int[][] opt = new int[array.length][array.length];
        //opt[i][j] = max gain for balloon i to j
        for(int j=1; j<array.length-1; j++) {
            for(int i=j; i>=1; i--) {
                //choose one from balloons i to j as the last one
                for(int k=i; k<=j; k++)
                    opt[i][j] = Math.max(array[i-1]*array[k]*array[j+1]+opt[i][k-1]+opt[k+1][j], opt[i][j]);
            }
        }
        return opt[1][array.length-2];
    }
    public int recursion(int[] nums) {
        List<Integer> current = new ArrayList<Integer>();
        for(Integer i: nums)
            current.add(i);
        return maxCoinsList(current);
    }
    public int maxCoinsList(List<Integer> nums) {
        int ans = 0;
        for(int i=0; i<nums.size(); i++) {
            int current = nums.get(i);
            int left = (i-1 < 0) ? 1: nums.get(i-1);
            int right = (i+1 >= nums.size()) ? 1: nums.get(i+1);
            nums.remove(i);
            ans = Math.max(ans, left*current*right+maxCoinsList(nums));
            nums.add(i, current);
        }        
        return ans;
    }
}