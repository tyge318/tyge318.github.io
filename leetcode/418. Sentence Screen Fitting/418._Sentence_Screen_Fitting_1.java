public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int n = sentence.length, ptr = 0, ans = 0;
        int multiple = 0;
        for(int i=0; i<rows; i++) {
            if( ptr == 0 && i != 0 ) {
                multiple = i;
                i = (rows/multiple)*multiple;
                ans *= (rows/multiple);
                if( i >= rows )
                    break;
            }
            int remain = cols - sentence[ptr].length();
            if( remain < 0 )
                continue;
            ptr++;
            if( ptr == n ) {
                ans++;
                ptr = 0;
            }
            while( remain >= (1+sentence[ptr].length()) ) {
                remain -= (1+sentence[ptr].length());
                ptr++;
                if( ptr == n ) {
                    ans++;
                    ptr = 0;
                }
            }
        }
        return ans;
    }
}