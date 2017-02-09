public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if(nums.length < 3)
            return output;
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<List<Integer>>();
        for(int i=0; i<nums.length; i++) {
            if( i>0 && nums[i] == nums[i-1] && nums[i] != 0)
                continue;
            List<List<Integer>> subList = twoSum(nums, i, (0-nums[i]) );
            ans.addAll(subList);
        }
        output = new ArrayList<List<Integer>>(ans);
        return output;
    }
    public List<List<Integer>> twoSum(int[] nums, int skip, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int head = 0, tail = nums.length-1;
        while( head < tail) {
            if( head == skip || (head>0 && nums[head] == nums[head-1] && nums[head] != 0) ) {
                head++;
                continue;
            }
            if( tail == skip || (tail<nums.length-1 && nums[tail] == nums[tail+1] && nums[tail] != 0) ) {
                tail--;
                continue;
            }
            int a = nums[head], b = nums[tail];
            if( a+b < target) {
                head++;
            }
            else if( a+b > target) {
                tail--;
            }
            else {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                if( skip != head && skip != tail && head != tail) {
                    temp.add(nums[skip]);
                    temp.add(a);
                    temp.add(b);
                    Collections.sort(temp);
                    ans.add(temp);
                }
                head++;
                tail--;
            }
        }
        return ans;
    }
}