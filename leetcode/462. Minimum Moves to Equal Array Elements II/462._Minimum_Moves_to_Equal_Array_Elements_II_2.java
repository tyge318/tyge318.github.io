public class Solution {
    public int minMoves2(int[] nums) {
        int median = findKth(nums, nums.length/2+1, 0, nums.length-1);
        int ans = 0;
        for(int i=0; i<nums.length; i++) {
            ans += Math.abs(nums[i] - median);
        }
        return ans;
    }
    public int findKth(int[] nums, int k, int begin, int end) {
        int pivot = nums[end], l = begin, r = end;
        while( true ) {
            //skip those that satisfy the conditions
            while( nums[l] < pivot && l < r)    l++;
            while( nums[r] >= pivot && l < r)   r--;
            if( l == r )    break;
            //if code reaches here, it means we find a violation => need to swap
            swap(nums, l, r);
        }
        swap(nums, l, end); //update end for later use (new pivot)
        if( k == l + 1) return pivot;
        else if( k < l+1)    return findKth(nums, k, begin, l-1);    //on the left subarray
        else    return findKth(nums, k, l+1, end);  //on the right subarray;
    }
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}