public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<>(), nums, 0);
        return ans;
    }
    public void dfs(List<List<Integer>> ans, List<Integer> current, int[] nums, int index) {
        if( current.size() > 1) ans.add(new ArrayList<Integer>(current));
        Set<Integer> unique = new HashSet<Integer>();
        for(int i=index; i<nums.length; i++) {
            if( index > 0 && nums[i] < nums[index-1]) 
                continue;
            if( unique.contains(nums[i]) )
                continue;
            unique.add(nums[i]);
            current.add(nums[i]);
            dfs(ans, current, nums, i+1);
            current.remove(current.size()-1);
        }
    }
}