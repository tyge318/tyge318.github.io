public class NumArray {
    int[] accNums;
    int n;
    public NumArray(int[] nums) {
        n = (nums == null) ? 0: nums.length;
        accNums = new int[n];
        if( n > 0) 
            accNums[0] = nums[0];
        for(int i=1; i<nums.length; i++)
            accNums[i] = accNums[i-1]+nums[i];
    }

    public int sumRange(int i, int j) {
        if( i <= n && j <= n && i <= j)
            return (accNums[j] - ((i == 0) ? 0 : accNums[i-1]) );
        else
            return 0;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);