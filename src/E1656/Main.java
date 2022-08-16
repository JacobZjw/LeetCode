package E1656;

/**
 * @author JwZheng
 * @since 2022/8/16 21:26
 */
public class Main {
    public static void main(String[] args) {
        OrderedStream stream = new OrderedStream(5);
        System.out.println(stream.insert(3,"ccccc"));
        System.out.println(stream.insert(1,"aaaaa"));
        System.out.println(stream.insert(2,"bbbbb"));
        System.out.println(stream.insert(5,"eeeee"));
        System.out.println(stream.insert(4,"ddddd"));
    }
}
