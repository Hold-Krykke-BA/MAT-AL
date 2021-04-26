package Datastructures.Stack.Impl;

public class Test {
    public static void main(String[] args) {
        System.out.println("\n******** STACK STRING ********");
        StackImpl<String> strStack = new StackImpl<>(2);
        //System.out.println(strStack.pop());
        strStack.push("teststring1");
        strStack.push("teststring2");
        System.out.println("Stack capacity: " + strStack.getCapacity());
        strStack.push("teststring3");
        System.out.println("Stack capacity: " + strStack.getCapacity());
        System.out.println("Pop: " + strStack.pop());
        System.out.println("Peek: " + strStack.peek());
        System.out.println("Pop: " + strStack.pop());
        System.out.println(" ");
        
        System.out.println("\n******** STACK INTEGER ********");
        StackImpl<Integer> intStack = new StackImpl<>(2);
        intStack.push(7);
        intStack.push(2);
        System.out.println("Stack capacity: " + intStack.getCapacity());
        System.out.println("Peek: " + intStack.peek());
        System.out.println("Pop: " + intStack.pop());
        intStack.push(3);
        intStack.push(4);
        System.out.println("Stack capacity: " + intStack.getCapacity());
    }
}
