public class Solution {
    Map<Integer, Boolean> map;
    boolean[] state;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = (1+maxChoosableInteger)*maxChoosableInteger/2;
        if( sum < desiredTotal )    return false;   //neither can win
        if( desiredTotal <= 0 ) return true;
        
        map = new HashMap<>();
        state = new boolean[maxChoosableInteger+1];
        return minMax(desiredTotal);
    }
    public int getKey(boolean[] state) {
        int ans = 0;
        for(boolean b: state) {
            ans <<= 1;
            if(b)
                ans |= 1;
        }
        return ans;
    }
    public boolean minMax(int goal) {
        if( goal <= 0 ) return false;
        int key = getKey(state);
        if( !map.containsKey(key)) {
            for(int i=1; i<state.length; i++) {
                if( state[i] )  continue;
                state[i] = true;    //try choose number i
                if( !minMax(goal-i) ) { //the other lose
                    map.put(key, true);
                    state[i] = false;   //undo change
                    return true;
                }
                state[i] = false;   //undo change
            }
            map.put(key, false);    //if reach here, it's lose
        }
        return map.get(key);
    }
}