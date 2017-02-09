public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<List<Integer>>();
        int n = nums.length;
        for(int i=0; i<=n; i++) {
            ans.addAll(combine(nums, i));
        }
        return (new ArrayList<List<Integer>>(ans) );
    }
    public List<List<Integer>> combine(int[] nums, int k) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if( nums.length == k) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(int i=0; i<nums.length; i++)
                temp.add(nums[i]);
            ans.add(temp);
            return ans;
        }
        else if( k == 0 ) {
            ans.add(Arrays.asList());
            return ans;
        }
        else if( k == 1) {
            for(int i=0; i<nums.length; i++)
                ans.add(new ArrayList<Integer>(Arrays.asList(nums[i])) );
            return ans;
        }
        int[] subArray = Arrays.copyOfRange(nums, 0, nums.length-1);
        List<List<Integer>> sub1 = combine(subArray, k-1);
        Iterator<List<Integer>> itr = sub1.iterator();
        while( itr.hasNext() ) {
            List<Integer> current = itr.next();
            current.add(nums[nums.length-1]);
            ans.add(current);
        }
        ans.addAll(combine(subArray, k));
        return ans;
    }
}