class MinStack {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();
    public void push (int x) {
        stack.push(x);
        if (min.empty() || x <= min.peek()) {
            min.push(x);
        }
    }
    public void pop() {
        //assert !stack.empty();
        int t = stack.pop();
        if (t == min.peek()) {
            min.pop();
        }
    }
    public int top() {
        //assert !stack.empty();
        return stack.peek();
    }
    public int getMin() {
        return min.peek();
    }
}