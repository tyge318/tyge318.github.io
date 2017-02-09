public class MovingAverage {
    int ptr, size, sum;
    int[] array;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        array = new int[size];
        this.size = 0;
        ptr = 0;
        sum = 0;
    }
    
    public double next(int val) {
        sum -= array[ptr];
        array[ptr] = val;
        sum += array[ptr];
        ptr = (ptr+1) % array.length;
        size = (size >= array.length) ? array.length: size+1;
        return (double)sum/size;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */