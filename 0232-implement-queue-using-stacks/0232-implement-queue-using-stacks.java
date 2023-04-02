class MyQueue {
Stack<Integer> s1,s2;
    public MyQueue() {
        s1=new Stack<>();
        s2=new Stack<>();
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        // if(isEmpty())
        //     return -1;
        // return s1.pop;
        while (s1.size() > 1) {
            s2.push(s1.pop());
        }
        int data = s1.pop();
        while (!s2.isEmpty())
            s1.push(s2.pop());
        return data;
    }
    
    public int peek() {
        // if(isEmpty())
        //     return -1;
        // return s1.peek;
        while (s1.size() > 1) {
            s2.push(s1.pop());
        }
        int data = s1.peek();
        while (!s2.isEmpty())
            s1.push(s2.pop());
        return data;
    }
    
    public boolean empty() {
        return s1.isEmpty();
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