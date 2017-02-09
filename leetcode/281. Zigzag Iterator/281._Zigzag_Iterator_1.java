public class ZigzagIterator {
    Deque<Iterator> list;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        list = new LinkedList<>();
        if(!v1.isEmpty())   list.add(v1.iterator());
        if(!v2.isEmpty())   list.add(v2.iterator());
    }

    public int next() {
        Iterator current = list.poll();
        int ans = (Integer)current.next();
        if( current.hasNext())
            list.add(current);
        return ans;
    }

    public boolean hasNext() {
        return (!list.isEmpty());
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */