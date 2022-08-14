package WC135;

import ListNode.ListNode;

/**
 * @author JwZheng
 * @since 2021/9/20 14:00
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.addInList(ListNode.getList("5,9,2,3,7,4,9,9,0,2,6,6,1,3,8,3,2,1,9,8,4,3,1,3,3,7,5,3,9,3,1,3,1"), ListNode.getList("4,2,8,3,5,1,0,5,7,4,5,0,2,5,0,3,9,7,3,6,8,4,4,9,7,1")));
        System.out.println(s.addInList(ListNode.getList("4,6,0,2,6,6,3,6,3,0,7,8,0,4,1,7,0,5,6,5,2,4,9,9,1,5,1,5"), ListNode.getList("6,2,7,8,6,4,7,0,9,3,0,3,6,2,5,6,0,9,6,2,7,4,2,7,1,0,9,0,5,6,5,4,9,1,8,9,3,4,0,2,1,8,8,2,2,0")));
    }
}
