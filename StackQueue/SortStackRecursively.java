// 2. Given a stack, sort its elements in ascending order using recursion.
import java.util.Stack;
public class SortStackRecursively{
    public static void sortStack(Stack<Integer> stack){
        if(!stack.isEmpty()){           //Recursion continues until stack is empty
            int top = stack.pop();      //Pop the top element
            sortStack(stack);           //Sort the rest stack
            insertInSortedOrder(stack,top); //Insert the popped element
        }
    }
    private static void insertInSortedOrder(Stack<Integer> stack,int value){
        if(stack.isEmpty() || stack.peek() <= value){
            stack.push(value);              // Insert if stack is empty and element is greater than top
            return;
        }
        int top = stack.pop();              //remove top element and store it into top variable
        insertInSortedOrder(stack, value);
        stack.push(top);                    //add the removed top element
    }

    public static void printStack(Stack<Integer> stack){
        System.out.println(stack);
    }
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.push(50);
        stack.push(20);
        stack.push(15);
        stack.push(48);

        System.out.println("Original Stack: ");
        printStack(stack);

        sortStack(stack);

        System.out.println("\n Sorted Stack (ascending order)");
        printStack(stack);
    }
}
