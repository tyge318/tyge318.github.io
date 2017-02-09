public class Solution {
    public int magicalString(int n) {
        if( n <= 0) return 0;
        if( n <= 3) return 1;
        
        int[] trace = new int[n+1];
        trace[0] = 1;
        trace[1] = 2;
        trace[2] = 2;
        int head = 2, tail = 3, num = 1, ans = 1;
        
        while( tail < n) {
            for(int i=0; i<trace[head]; i++) {
                trace[tail] = num;
                if( num == 1 && tail < n)  
                    ans++;
                tail++;
            }
            num = num ^ 3;
            head++;
        }
        return ans;
    }
}