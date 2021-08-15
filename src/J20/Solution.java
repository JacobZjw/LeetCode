package J20;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JwZheng
 * @date 2021/3/30 10:45
 */
public class Solution {
    public boolean isNumber(String s) {
        Map[] maps = new Map[]{
                new HashMap<Status, Integer>() {{
                    put(Status.OPERATOR, 1);
                    put(Status.DIGIT, 2);
                    put(Status.DOT, 4);
                }},//0
                new HashMap<Status, Integer>() {{
                    put(Status.DIGIT, 2);
                    put(Status.DOT, 4);
                }},//1
                new HashMap<Status, Integer>() {{
                    put(Status.DOT, 3);
                    put(Status.DIGIT, 2);
                    put(Status.E, 5);
                    put(Status.END, null);
                }},//2
                new HashMap<Status, Integer>() {{
                    put(Status.E, 5);
                    put(Status.DIGIT, 3);
                    put(Status.END, null);
                }},//3
                new HashMap<Status, Integer>() {{
                    put(Status.DIGIT, 3);
                }},//4
                new HashMap<Status, Integer>() {{
                    put(Status.DIGIT, 7);
                    put(Status.OPERATOR, 6);
                }},//5
                new HashMap<Status, Integer>() {{
                    put(Status.DIGIT, 7);
                }},//6
                new HashMap<Status, Integer>() {{
                    put(Status.DIGIT, 7);
                    put(Status.END, null);
                }}//7
        };

        Integer index = 0;
        for (char c : s.trim().toCharArray()) {
            Status status = get(c);
            if (status == null || !maps[index].containsKey(status)) {
                return false;
            }
            index = (Integer) maps[index].get(status);
        }
        return maps[index].containsKey(Status.END);
    }

    private Status get(char ch) {
        if (Character.isDigit(ch)) {
            return Status.DIGIT;
        }
        switch (ch) {
            case '.':
                return Status.DOT;
            case 'e':
            case 'E':
                return Status.E;
            case '+':
            case '-':
                return Status.OPERATOR;
            default:
                break;
        }
        return null;
    }

    enum Status {
        DIGIT, E, DOT, OPERATOR, END
    }

}
