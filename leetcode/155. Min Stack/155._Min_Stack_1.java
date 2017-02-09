public class MinStack {
        PriorityQueue<Integer> pq;
        List<Integer> st;
    /** initialize your data structure here. */
    public MinStack() {
        pq = new PriorityQueue<Integer>();
        st = new ArrayList<Integer>();
    }
    
    public void push(int x) {
        pq.add(x);
        st.add(x);
    }
    
    public void pop() {
        Integer rm = st.remove(st.size()-1);
        pq.remove(rm);
    }
    
    public int top() {
        return st.get(st.size()-1);
    }
    
    public int getMin() {
        return pq.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */