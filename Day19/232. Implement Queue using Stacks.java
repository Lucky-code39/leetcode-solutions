class MyQueue {

    private ArrayDeque<Integer> stack;
    private ArrayDeque<Integer> queue;

    public MyQueue() {
        stack = new ArrayDeque<>();
        queue = new ArrayDeque<>();
    }
    
    public void push(int x) {
        
       stack.push(x);
      
    }
    
    public int pop() {
     peek();
    return queue.pop();
        
    }
    
    public int peek() {
        if(queue.isEmpty()){
            while(!stack.isEmpty()){
                queue.push(stack.pop());
            }

        }
       return queue.peek();
       
    }
    
    public boolean empty() {
        return stack.isEmpty() && queue.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
