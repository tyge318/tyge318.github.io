public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> ans = new ArrayList<>();
        for(int i=0; i<12; i++) {
            for(int j=0; j<60; j++) {
                if( Integer.bitCount(i) + Integer.bitCount(j) == num) 
                    ans.add(String.format("%d:%02d", i, j) );
            }
        }
        return ans;
    }
}