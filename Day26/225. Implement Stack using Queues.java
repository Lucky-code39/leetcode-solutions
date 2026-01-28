class MyStack {
    ArrayDeque<Integer> q1;
    ArrayDeque<Integer> q2;

    public MyStack() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        q2.addLast(x);
        while(!q1.isEmpty()){
            q2.addLast(q1.pollFirst());

        }
        ArrayDeque<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    
    public int pop() {
      return q1.pollFirst();
    }
    
    public int top() {
        return q1.peekFirst();
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
