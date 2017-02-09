public class Solution {
    int[] btree;
    int n;
    public List<Integer> countSmaller(int[] nums) {
        n = nums.length;
        btree = new int[n+1];
        List<Integer> ans = new LinkedList<Integer>();
        
        int[] orders = mapToOrder(nums);
        for(int i=orders.length-1; i>=0; i--) {
            ans.add(0, sum(orders[i]-1));
            insert(orders[i], 1);
        }
        return ans;
    }
    public int[] mapToOrder(int[] nums) {
        int[] ans = new int[nums.length];
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);
        for(int i=0; i<nums.length; i++)
            ans[i] = Arrays.binarySearch(temp, nums[i])+1;
        return ans;
    }
    public void insert(int i, int value) {
        for(; i<=n; i += (i & -i) )
            btree[i] += value;
    }
    public int sum(int i) {
        int sum = 0;
        for(; i>0; i -= (i&-i) )
            sum += btree[i];
        return sum;
    }
}