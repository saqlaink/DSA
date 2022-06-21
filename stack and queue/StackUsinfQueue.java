import java.util.*;

class Main {
	public static void main(String args[]) {
    Stack s = new Stack();
        s.push(3);
        s.push(2);
        s.push(4);
        s.push(1);
        System.out.println("Top of the stack: " + s.top());
        System.out.println("Size of the stack before removing element: " + s.size());
        System.out.println("The deleted element is: " + s.pop());
        System.out.println("Top of the stack after removing element: " + s.top());
        System.out.println("Size of the stack after removing element: " + s.size());
    }
}
class Stack{
	Queue<Integer> q = new LinkedList<>();
	void push(int x){
		q.add(x);
		for(int i=0;i<q.size()-1;i++){
			q.add(q.remove());
		}
	}
	int pop(){
		if(!q.isEmpty()){
      return q.remove();
    }
    return -1;
	}
	int top(){
		if(!q.isEmpty()){
      return q.peek();
    }
    return -1;
	}
	int size(){
		return q.size();
	}
}