public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        return work(nums, 0, nums.length-1);
    }
    public List<List<Integer>> work(int[] nums, int begin, int end) {
        Set<List<Integer>> ans = new HashSet<List<Integer>>();
        if( begin == end ) {
            ans.add(new ArrayList<Integer>(Arrays.asList(nums[begin])) );
            return (new ArrayList<List<Integer>>(ans));
        }
        if( begin == end-1) {
            List<Integer> case1 = new ArrayList<Integer>(Arrays.asList(nums[begin], nums[end]));
            List<Integer> case2 = new ArrayList<Integer>(Arrays.asList(nums[end], nums[begin]));
            ans.add(case1);
            ans.add(case2);
            return (new ArrayList<List<Integer>>(ans));
        }
        List<List<Integer>> subAns = work(nums, begin+1, end);
        for(int i=0; i<subAns.size(); i++) {
            List<Integer> subCase = subAns.get(i);
            for(int j=0; j<=subCase.size(); j++) {
                List<Integer> temp = new ArrayList<Integer>(subCase);
                temp.add(j, nums[begin]);
                ans.add(temp);
            }
        }
        return (new ArrayList<List<Integer>>(ans));
    }
}