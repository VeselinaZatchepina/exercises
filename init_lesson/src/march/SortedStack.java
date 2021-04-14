package march;

import java.util.ArrayList;

/**
 * Sorted Stack (when insert)
 */
public class SortedStack {

    private ArrayList<Integer> list = new ArrayList<>();

    public void push(Integer value) {

        if (!list.isEmpty()) {

            for (int i = 0; i < list.size(); i++) {
                if (value <= list.get(i)) {
                    if (i == 0) {
                        list.add(i, value);
                    } else {
                        list.add(i - 1, value);
                    }
                    return;
                }
            }
        }

        list.add(value);
    }

    public Integer pop() {

        if (list.isEmpty()) return null;

        Integer popValue = list.get(list.size() - 1);

        list.remove(popValue);

        return popValue;
    }

    public void print() {
        for (int value : list) {
            System.out.println(value);
        }
    }
}
