package E155;

/**
 * @author JwZheng
 */
public class Main {
    public static void main(String[] args) {
        MinStack2 minStack = new MinStack2();
        minStack.push(Integer.MAX_VALUE - 1);
        minStack.push(Integer.MAX_VALUE - 1);
        minStack.push(Integer.MAX_VALUE);
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.push(Integer.MAX_VALUE);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.push(Integer.MIN_VALUE);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());


    }
}
