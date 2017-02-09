public class ZigzagIterator {
    List<Integer> order;
    Iterator<Integer> itr;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        order = new ArrayList<Integer>();
        int index = 0;
        while( index < v1.size() && index < v2.size() ) {
            if( order.size() % 2 == 0) {
                order.add(v1.get(index));
            }
            else {
                order.add(v2.get(index));
                index++;
            }
        }
        if( index == v1.size() )
            order.addAll(v2.subList(index, v2.size()));
        else
            order.addAll(v1.subList(index, v1.size()));
        itr = order.iterator();
    }

    public int next() {
        return itr.next();
    }

    public boolean hasNext() {
        return itr.hasNext();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */