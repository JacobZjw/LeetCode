package J59;

/**
 * @author JwZheng
 */
public class Main {
    public static void main(String[] args) {
//        Solution solution = new Solution();
//        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
//        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3)));
//        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{9, 10, 9, -7, -4, -8, 2, -6}, 5)));
//        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{9, 11}, 1)));


        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        maxQueue.push_back(1);
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());


    }
}
