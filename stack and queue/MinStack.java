// 13. Implement Min Stack : O(2N) and O(N) Space Complexity
    
// Problem Statement: Implement Min Stack | O(2N) and O(N) Space Complexity. Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
// Time Complexity: O(1)
// Space Complexity: O(2N)



class Pair {
    int x, y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class MinStack {
    Stack < Pair > st;
    public MinStack() {
        st = new Stack < > ();
    }

    public void push(int x) {
        int min;
        if (st.isEmpty()) {
            min = x;
        } else {
            min = Math.min(st.peek().y, x);
        }
        st.push(new Pair(x, min));
    }

    public void pop() {
        st.pop();
    }

    public int top() {
        return st.peek().x;
    }

    public int getMin() {
        return st.peek().y;
    }
}

// - [ ] Solution 2: 
// Time Complexity: O(1)
// Space Complexity: O(N)

class MinStack {
    Stack < Long > st = new Stack < Long > ();
    Long mini;
    /** initialize your data structure here. */
    public MinStack() {
        mini = Long.MAX_VALUE;
    }
    public void push(int value) {
        Long val = Long.valueOf(value);
        if (st.isEmpty()) {
            mini = val;
            st.push(val);
        } else {
            if (val < mini) {
                st.push(2 * val - mini);
                mini = val;
            } else {
                st.push(val);
            }
        }
    }
    public void pop() {
        if (st.isEmpty()) return;
        Long val = st.pop();
        if (val < mini) {
            mini = 2 * mini - val;
        }
    }
    public int top() {
        Long val = st.peek();
        if (val < mini) {
            return mini.intValue();
        }
        return val.intValue();
    }
    public int getMin() {
        return mini.intValue();
    }
}
