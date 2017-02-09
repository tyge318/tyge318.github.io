public class Vector2D implements Iterator<Integer> {
    int x, y;
    List<List<Integer>> vec2d;
    public Vector2D(List<List<Integer>> vec2d) {
        x = 0;
        y = 0;
        this.vec2d = vec2d;
    }

    @Override
    public Integer next() {
        Integer ans = vec2d.get(x).get(y);
        y++;
        return ans;
    }

    @Override
    public boolean hasNext() {
        while( x < vec2d.size() ) {
            if( y >= vec2d.get(x).size() ) {
                x++;
                y = 0;
                continue;
            }
            return true;
        }
        return false;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */