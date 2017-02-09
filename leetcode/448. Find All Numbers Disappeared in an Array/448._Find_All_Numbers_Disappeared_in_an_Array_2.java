public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        int n = nums.length;
        for(int i=0; i<n; i++)
            nums[(nums[i]-1)%n] += n;
        for(int i=0; i<n; i++)
            if( nums[i] <= n)
                ans.add(i+1);
        return ans;
    }
}