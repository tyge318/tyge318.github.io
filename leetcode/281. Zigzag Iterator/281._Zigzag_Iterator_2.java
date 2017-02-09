public class ZigzagIterator {
    List<List<Integer>> lists;
    List<Integer> cp;
    Set<Integer> done;
    int index, k;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        k = 2;
        lists = new ArrayList<>();
        lists.add(v1);
        lists.add(v2);
        cp = new ArrayList<>();
        done = new HashSet<>();
        if( v1.isEmpty())
            done.add(0);
        cp.add(0);
        if( v2.isEmpty())
            done.add(1);
        cp.add(0);
        index = 0;
    }

    public int next() {
        while( done.contains(index) )
            index = (index+1) % k;
        //System.out.println("index = " + index + "; cp = " + cp.toString());
        int ans = lists.get(index).get(cp.get(index));
        cp.set(index, cp.get(index)+1);
        if( cp.get(index) == lists.get(index).size() )
            done.add(index);
        index = (index+1) % k;
        return ans;
    }

    public boolean hasNext() {
        return (done.size() != lists.size());
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */