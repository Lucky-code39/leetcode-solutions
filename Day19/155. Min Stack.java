class MinStack {
  private ArrayDeque<Integer> dq ;
  private ArrayDeque<Integer> minStack;


    public MinStack() {
        dq = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        dq.addLast(val);
        if(minStack.isEmpty()){
            minStack.addLast(val);
        }
        else{
            minStack.addLast(Math.min(val, minStack.getLast()));
        }
        
    }
    
    public void pop() {
        dq.removeLast();
        minStack.removeLast();

    }
    
    public int top() {
       return dq.getLast();
    }
    
    public int getMin() {
       return minStack.getLast();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
