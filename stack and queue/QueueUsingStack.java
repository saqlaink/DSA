// Using two Stacks where push operation is O(N)

import java.util.*;

class Main {
    public static void main(String args[]) {
        Queue q = new Queue();
        q.push(3);
        q.push(4);
        System.out.println("The element poped is " + q.pop());
        q.push(5);
        System.out.println("The top element is " + q.peek());
        System.out.println("The size of the queue is " + q.size());
    }
}
class Queue{
	Stack<Integer> input;
	Stack<Integer> output;
	public Queue(){
		input = new Stack<>();
		output = new Stack<>();
	}
	void push(int ele){
		while(!input.empty()){
			output.push(input.pop());
		}
        System.out.println("The element pushed is " + ele);
		input.push(ele);
		while(!output.empty()){
			input.push(output.pop());
		}
	}
	int pop(){
		if (input.empty()) {
            System.out.println("Stack is empty");

        }
		return input.pop();
	}
	int peek(){
		if (input.empty()) {
            System.out.println("Stack is empty");
        }
		return input.peek();
	}
	int size(){
		return input.size();
	}
}



//Using two Stacks where push operation is O(1)

import java.util.*;

class Main {
    public static void main(String args[]) {
        Queue q = new Queue();
        q.push(3);
        q.push(4);
        System.out.println("The element poped is " + q.pop());
        q.push(5);
        System.out.println("The top element is " + q.peek());
        System.out.println("The size of the queue is " + q.size());
    }
}
class Queue{
	Stack<Integer> input;
	Stack<Integer> output;
	public Queue(){
		input = new Stack<>();
		output = new Stack<>();
	}
	void push(int ele){
        System.out.println("The element pushed is " + ele);
		input.push(ele);
	}
	int pop(){
		if (output.empty()) {
            while(!input.empty()){
				output.push(input.pop());
			}
        }
		return output.pop();
	}
	int peek(){
		if (output.empty()) {
            while(!input.empty()){
				output.push(input.pop());
			}
        }
		return output.peek();
	}
	int size(){
		return input.size() + output.size();
	}
}