public class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        if( n < 2)  return 0;
        int[] bitMap = new int[n];
        for(int i=0; i<n; i++) {
            String current = words[i];
            for(int j=0; j<current.length(); j++) {
                bitMap[i] |= (1 << (current.charAt(j) - 'a') );
            }
        }
        int ans = 0;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if( (bitMap[i] & bitMap[j]) == 0 && words[i].length()*words[j].length() > ans)
                    ans = words[i].length()*words[j].length();
            }
        }
        return ans;
    }
}