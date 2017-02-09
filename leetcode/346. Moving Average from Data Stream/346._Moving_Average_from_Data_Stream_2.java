public class MovingAverage {
    /** Initialize your data structure here. */
    int n, sum;
    Deque<Integer> q;
    public MovingAverage(int size) {
        n = size;
        sum = 0;
        q = new LinkedList<>();
    }
    
    public double next(int val) {
        int remove = 0;
        if( q.size() >= n )
            remove = q.poll();
        q.add(val);
        sum += val;
        sum -= remove;
        return (double)sum/q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */