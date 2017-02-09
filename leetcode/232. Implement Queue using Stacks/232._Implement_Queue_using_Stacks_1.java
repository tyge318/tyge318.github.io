class MyQueue {
    Stack<Integer> st = new Stack<Integer>();
    boolean stackOrder = true;
    // Push element x to the back of queue.
    public void push(int x) {
        if( !stackOrder ) {
            reverse();
            stackOrder = true;
        }
        st.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if( stackOrder ) {
            reverse();
            stackOrder = false;
        }
        st.pop();
    }

    // Get the front element.
    public int peek() {
        if( stackOrder ) {
            reverse();
            stackOrder = false;
        }
        return st.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return st.isEmpty();
    }
    
    public void reverse() {
        Stack<Integer> temp = new Stack<Integer>();
        while( !st.isEmpty() ) {
            temp.push(st.pop());
        }
        st.addAll(temp);
    }
}