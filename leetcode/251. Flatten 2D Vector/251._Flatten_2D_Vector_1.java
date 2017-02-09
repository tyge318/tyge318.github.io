public class Vector2D implements Iterator<Integer> {
    List<List<Integer>> vec2d;
    Iterator<List<Integer>> rowIt;
    List<Integer> curRow;
    Iterator<Integer> colIt;
    public Vector2D(List<List<Integer>> vec2d) {
        this.vec2d = vec2d;
        rowIt = this.vec2d.iterator();
    }

    @Override
    public Integer next() {
        Integer ans = colIt.next();
        return ans;
    }

    @Override
    public boolean hasNext() {
        while( rowIt.hasNext() ) {
            if(colIt == null || !colIt.hasNext() ) {
                curRow = rowIt.next();
                //System.out.println(curRow.toString());
                colIt = curRow.iterator();
                continue;
            }
            return true;
        }
        return (colIt == null? false: colIt.hasNext());
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */