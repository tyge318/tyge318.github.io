public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for(int i: nums) {
            int index = Math.abs(i)-1;
            if( nums[index] < 0 )
                ans.add(Math.abs(index+1) );
            nums[index] *= -1;
        }
        return ans;
    }
}