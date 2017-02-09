class MyStack {
    Queue<Integer> q = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        q.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        Queue<Integer> hold = new LinkedList<Integer>();
        while( q.size() > 1 ) {
            hold.add(q.poll());
        }
        int ans = q.poll();
        q.addAll(hold);
    }

    // Get the top element.
    public int top() {
        Queue<Integer> hold = new LinkedList<Integer>();
        while( q.size() > 1 ) {
            hold.add(q.poll());
        }
        int ans = q.poll();
        q.addAll(hold);
        q.add(ans);
        return ans;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }
}