public class Solution {
    public int trap(int[] height) {
        int[] lefts = new int[height.length];
        int[] rights = new int[height.length];
        int ans = 0;
        
        for(int i=0; i<height.length; i++) {
            if( i == 0)
                lefts[0] = height[0];
            lefts[i] = Math.max(lefts[Math.max(i-1, 0)], height[i]);
        }
        for(int i=height.length-1; i>=0; i--) {
            if( i == height.length-1 )
                rights[i] = height[i];
            rights[i] = Math.max(rights[Math.min(i+1, height.length-1)], height[i]);
            int amount = Math.min(lefts[i], rights[i]) - height[i];
            ans += ((amount > 0)? amount: 0);
        }
        return ans;
    }
}