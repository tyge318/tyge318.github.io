public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        /*
        for(int i=0; i<gas.length; i++) {
            int remain = 0, current = i;
            boolean prune = false;
            do{
                if( (remain = (remain + gas[current] - cost[current])) >= 0 )
                    current = (current + 1) % gas.length;
                else {
                    prune = true;
                    break;
                }
            }while( current != i);
            if( prune ) continue;
            return i;
        }
        return -1; */
        int sum = 0;
        for(int i=0; i<gas.length; i++)
            sum += (gas[i] - cost[i]);
        
        if( sum < 0 )
            return -1;

        int start = 0, remain = 0;
        for(int i=0; i<gas.length; i++) {
            if( remain + (gas[i] - cost[i]) < 0 ) {
                start = i+1;
                remain = 0;
            }
            else
                remain += (gas[i] - cost[i]);
        }
        return start;
    }
}