class MovingAverage {
public:
    /** Initialize your data structure here. */
    int avgSize, sum;
    queue<int> q;
    MovingAverage(int size): avgSize(size), sum(0) {
    }
    
    double next(int val) {
        q.push(val);
        sum += val;
        if( q.size() <= avgSize )
            return ((double)sum/q.size());
        sum -= q.front();
        q.pop();
        return ((double)sum/avgSize);
    }
};

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */