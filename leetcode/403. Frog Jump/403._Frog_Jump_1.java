public class Solution {
    public boolean canCross(int[] stones) {
        //each stone records from which position it jumped from
        Map<Integer, Set<Integer>> jumps = new HashMap<Integer, Set<Integer>>();
        int target = stones[stones.length-1];
        
        //first jump: 0 => 1
        jumps.put(1, new HashSet<Integer>(Arrays.asList(0)));
        
        for(int i=1; i<stones.length; i++) {
            if( !jumps.containsKey(stones[i]) )
                return false;
            for(Integer begin: jumps.get(stones[i]) ) {
                int k = stones[i]-begin;
                for(int j=-1; j<2; j++) {
                    int nextStone = stones[i]+k+j;
                    if( nextStone == target)
                        return true;
                    if( nextStone == stones[i])
                        continue;
                    Set<Integer> nextStoneFrom;
                    if( jumps.containsKey(nextStone) )
                        nextStoneFrom = jumps.get(nextStone);
                    else
                        nextStoneFrom = new HashSet<Integer>();
                    nextStoneFrom.add(stones[i]);
                    jumps.put(nextStone, nextStoneFrom);
                }
            }
        }
        return false;
    }
}