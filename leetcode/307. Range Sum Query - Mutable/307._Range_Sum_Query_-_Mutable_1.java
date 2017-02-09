public class NumArray {
    int[] nums;
    int[] btree;
    public NumArray(int[] nums) {
        this.nums = nums;
        btree = new int[nums.length+1];
        for(int i=0; i<nums.length; i++)
            add(i+1, nums[i]);
    }
    void add(int i, int value) {
        for(int j=i; j<btree.length; j += (j & -j) )
            btree[j] += value;
    } 
    void update(int i, int val) {
        add(i+1, val-nums[i]);
        nums[i] = val;
    }
    int sum(int i) {
        int sum = 0;
        for(int j=i; j>0; j -=(j & -j) )
            sum += btree[j];
        return sum;
    }
    public int sumRange(int i, int j) {
        return sum(j+1)-sum(i);
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);