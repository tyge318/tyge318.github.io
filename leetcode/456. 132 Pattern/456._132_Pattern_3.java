public class Solution {
    public boolean find132pattern(int[] nums) {
        int a3 = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<>();
        for(int i=nums.length-1; i>=0; i--) {
            if( nums[i] < a3 )
                return true;
            while( !st.empty() && nums[i] > st.peek() ) {
                a3 = Math.max(a3, st.pop() );
            }
            st.push(nums[i]);
        }
        return false;
    }
}