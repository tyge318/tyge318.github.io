public class MedianFinder {
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(); //for those greater than or equal to median
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(); //for those less than median
    double currentMedian;
    // Adds a number into the data structure.
    public void addNum(int num) {
        if( minHeap.size() == 0 && maxHeap.size() == 0) {
            minHeap.add(num);
            currentMedian = num;
        }
        else {
            if( num < currentMedian ) {
                maxHeap.add(-num);  
                if( minHeap.size() == maxHeap.size() )  //previously currentMedian = root of minHeap
                    currentMedian = (minHeap.peek() + (-1)*maxHeap.peek())/2.0;
                else { //maxHeap.size() == minHeap.size()+1, previously currentMedian = avg of two heaps
                    minHeap.add((-1)*maxHeap.poll() );
                    currentMedian = minHeap.peek();
                }
            }
            else {
                minHeap.add(num);
                if( minHeap.size() - maxHeap.size() == 2 ) { //previously currentMedian = root of minHeap
                    maxHeap.add((-1)*minHeap.poll() );
                    currentMedian = (minHeap.peek() + (-1)*maxHeap.peek())/2.0;
                }
                else {  //minHeap.size() == maxHeap.size()+1, previously currentMedian = avg of two heaps
                    currentMedian = minHeap.peek();
                }
            }
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        return currentMedian;
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();