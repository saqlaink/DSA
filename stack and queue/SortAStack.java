// Problem Statement
// You’re given a stack consisting of 'N' integers. Your task is to sort this stack in descending order using recursion.


import java.util.*;
public class Solution {
    public static void sortStack(Stack<Integer> stack) {
        if(!stack.isEmpty()){
            int x = stack.pop();
            sortStack(stack);
            sortedInsert(stack,x);
        }
    }
    static void sortedInsert(Stack<Integer> s,int x){
        if(s.isEmpty() || x>s.peek()){
            s.push(x);
            return;
        }
        int temp = s.pop();
        sortedInsert(s,x);
        s.push(temp);
    }
}
