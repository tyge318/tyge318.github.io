public class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if( n == 0) return 0;
        int[] leftHeight = new int[n];
        int[] rightHeight = new int[n];
        leftHeight[0] = height[0];
        rightHeight[n-1] = height[n-1];
        for(int i=1; i<n; i++) {
            leftHeight[i] = Math.max(leftHeight[i-1], height[i]);
            rightHeight[n-1-i] = Math.max(rightHeight[n-i], height[n-1-i]);   
        }
        int ans = 0;
        for(int i=0; i<n; i++) {
            if( height[i] < leftHeight[i] && height[i] < rightHeight[i])
                ans += (Math.min(leftHeight[i], rightHeight[i]) - height[i]);
        }
        return ans;
    }
}