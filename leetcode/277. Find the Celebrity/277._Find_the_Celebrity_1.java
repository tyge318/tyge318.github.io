/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int ans = 0;
        for(int i=1; i<n; i++) {
            if( knows(ans, i) ) //if ans knows i, then i could be the celebrity
                ans = i;
        }
        for(int i=0; i<n; i++) {
            //only check relation with others.
            //if ans knows i then ans won't be celebrity
            //if i doesn't know ans then ans won't be celebrity
            if( ans != i && (knows(ans, i) || !knows(i, ans)) )
                return -1;
        }
        return ans;
    }
}