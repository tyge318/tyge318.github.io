public class Solution {
    public int findMinStep(String board, String hand) {
        Map<Character, Integer> handBalls = getHandBalls(hand);
        return helper(board, handBalls);
    }
    public Map<Character, Integer> getHandBalls(String hand) {
        Map<Character, Integer> handBalls = new HashMap<>();
        for(char c: hand.toCharArray()) {
            if( handBalls.containsKey(c) )
                handBalls.put(c, handBalls.get(c)+1);
            else
                handBalls.put(c, 1);
        }
        return handBalls;
    }
    public int helper(String board, Map<Character, Integer> hand) {
        if( !board.isEmpty() && hand.isEmpty() )    return -1;
        if( board.isEmpty() )   return 0;
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<board.length(); i++) {
            boolean flag = (i == 0) ? false: (board.charAt(i) == board.charAt(i-1));
            char useBall = board.charAt(i);
            String newBoard = flag ? removeBall(board, i-1, i+1) : (new StringBuilder(board)).insert(i+1, useBall).toString();
            if( !hand.containsKey(useBall) )    continue;
            hand.put(useBall, hand.get(useBall)-1);
            if( hand.get(useBall) == 0) hand.remove(useBall);
            int step = helper(newBoard, hand);
            if( !hand.containsKey(useBall) )
                hand.put(useBall, 1);
            else
                hand.put(useBall, hand.get(useBall)+1);
            if( step < 0 )  continue;
            ans = Math.min(ans, 1+step);
        }
        return (ans == Integer.MAX_VALUE) ? -1: ans;
    }
    public String removeBall(String board, int begin, int end) {
        String remain = (new StringBuilder(board)).delete(begin, end).toString();
        return removeHelper(remain);
    }
    public String removeHelper(String remain) {
        int acc = 0;
        boolean flag = false;
        for(int i=0; i<remain.length(); i++) {
            char c = remain.charAt(i);
            acc++;
            if( i == remain.length()-1 || remain.charAt(i+1) != c ) {
                if( acc >= 3) {
                    remain = (new StringBuilder(remain)).delete(i+1-acc, i+1).toString();
                    flag = true;
                    break;
                }
                acc = 0;
            }
        }
        if( flag )
            remain = removeHelper(remain);
        return remain;
    }
}