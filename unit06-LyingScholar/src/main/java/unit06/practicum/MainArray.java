package unit06.practicum;

public class MainArray {
    public static void main(String[] args) {
        ArrayStack<String> stack = new ArrayStack<>();
        stack.push("hello");
        stack.push("world");
        stack.push("how");
        stack.push("you");
        stack.push("doin");
        
                
        System.out.println("Stack: " + stack.toString());
        
        
        
        System.out.println("Top element: " + stack.top());

        System.out.println("Size before pop: " + stack.size());
        stack.pop();        
        System.out.println("Size after pop: " + stack.size());
        


        stack.pop();        
        stack.pop();        
        stack.pop();    
        System.out.println("After 3 more pops, Stack: " + stack.toString());    
        
        // for (String s : stack) {
        //     System.out.println(s);
        //     System.out.println("Stack: " + stack.toString());
        // }
    }
}
