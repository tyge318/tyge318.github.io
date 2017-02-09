public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int ans = 0;
        for(int house: houses) {
            int index = Arrays.binarySearch(heaters, house);
            if( index < 0 ) {
                index = ~index;
                int dToLeft = index-1 >= 0 ? house - heaters[index-1]: Integer.MAX_VALUE;
                int dToRight = index < heaters.length ? heaters[index] - house: Integer.MAX_VALUE;
                ans = Math.max(ans, Math.min(dToLeft, dToRight));
            }
        }
        return ans;
    }
}