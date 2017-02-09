public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        ArrayList<int[]> list = new ArrayList<int[]>();
        for(int i=0; i<people.length; i++)
            list.add(people[i]);
            
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2) {
                if( a1[0] != a2[0] )
                    return -Integer.compare(a1[0], a2[0]);
                else
                    return Integer.compare(a1[1], a2[1]);
            }
        });
        /* [[7,0], [7,1], [6,1], [5,0], [5,2], [4,4]] */
        List<int[]> temp = new ArrayList<int[]>();
        for(int i=0; i<list.size(); i++) {
            int insertIndex = list.get(i)[1];
            temp.add(insertIndex, list.get(i));
        }
        int[][] ans = new int[people.length][2];
        for(int i=0; i<temp.size(); i++)
            ans[i] = temp.get(i);
        return ans;
    }
}