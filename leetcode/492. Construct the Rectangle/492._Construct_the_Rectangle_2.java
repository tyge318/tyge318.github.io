public class Solution {
    public int[] constructRectangle(int area) {
        int L = (int)Math.ceil(Math.sqrt(area)), W;
        while( area % L != 0 ) {
            L++;
        } 
        W = area/L;
        return (new int[]{L, W});
    }
}