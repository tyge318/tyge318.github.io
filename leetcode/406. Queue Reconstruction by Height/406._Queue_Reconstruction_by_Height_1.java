public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        //the heighest group has the correct k order
        //so first sort reversely based on h
        //then for the same h, sort based on k
        //this is the order of "insertion"
        List<int[]> q = new LinkedList<>();
        for(int[] p: people)
            q.add(p);
        Collections.sort(q, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if( a[0] != b[0] )
                    return -Integer.compare(a[0], b[0]);
                else
                    return Integer.compare(a[1], b[1]);
            } 
        });
        List<int[]> temp = new LinkedList<>();
        for(int[] p: q) {
            temp.add(p[1], p);
        }
        int[][] ans = new int[people.length][2];
        for(int i=0; i<people.length; i++)
            ans[i] = temp.get(i);
        return ans;
    }
}