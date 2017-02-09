public class Solution {
    public boolean isReflected(int[][] points) {
        Set<String> set = new HashSet<>();
        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
        for(int[] p: points) {
            minX = Math.min(minX, p[0]);
            maxX = Math.max(maxX, p[0]);
            String str = p[0]+"@"+p[1];
            set.add(str);
        }
        int sum = minX+maxX;
        for(int[] p: points) {
            String str = (sum-p[0])+"@"+p[1];
            if( !set.contains(str) )
                return false;
        }
        return true;
    }
}