public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] ans = new int[length];
        for(int[] update: updates) {
            int begin = update[0], end = update[1], inc = update[2];
            ans[begin] += inc;
            if( end+1 < length )
                ans[end+1] -= inc;
        }
        
        for(int i=1; i<length; i++) {
            ans[i] += ans[i-1];
        }
        return ans;
    }
}