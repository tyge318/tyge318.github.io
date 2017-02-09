public class Solution {
    public int removeDuplicates(int[] nums) {
        if( nums.length <= 2)
            return nums.length;
        ArrayList<Integer> pos = new ArrayList<Integer>(0);
        pos.add(0);
        for(int i=1; i<nums.length; i++) {
            if(nums[i] != nums[i-1] )
                pos.add(i);
        }
        pos.add(nums.length);
        int index = 1;
        for(int i=1; i<pos.size(); i++) {
            if( pos.get(i)-pos.get(i-1) == 1) {
                if( pos.get(i) != nums.length )
                    nums[index++] = nums[pos.get(i)];
            }
            else {
                nums[index++] = nums[pos.get(i-1)];
                if( index < nums.length) {
                    nums[index++] = ((pos.get(i) == nums.length) ? Integer.MIN_VALUE : nums[pos.get(i)]);
                }
            }
        }
        if(nums[index-1] == Integer.MIN_VALUE) index--;
        return index;
    }
}