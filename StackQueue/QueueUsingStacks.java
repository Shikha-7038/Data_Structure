// 1. Design a queue using two stacks such that enqueue and dequeue operations are performed efficiently.

import java.util.Stack;
public class QueueUsingStacks{
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int data){
        //Move all elements from stack1 to stack2
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        // Push the new element into stack1
        stack1.push(data);

        //Move all elements back from stack2 to stack1
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }
    public int dequeue(){
        if(stack1.isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        return stack1.pop();
    }

    public int peek(){
        if(stack1.isEmpty()){
            throw new RuntimeException("Queue is empty.");
        }
        return stack1.peek();
    }

    public boolean isEmpty(){
        return stack1.isEmpty();
    }

    public void display(){
        System.out.println("Queue: "+stack1);
    }

    public static void main(String[] args) {
        QueueUsingStacks q = new QueueUsingStacks();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display();

        System.out.println("Dequeued: "+q.dequeue());
        q.display();

        System.out.println("Front element: "+q.peek());
    }
}


