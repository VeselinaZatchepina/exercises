package march;

import java.util.ArrayList;

/**
 * Get Max value from stack
 */
public class StackWithMaxValue {

    private ArrayList<Integer> list = new ArrayList<>();
    private Integer maxValue = null;

    public void push(Integer value) {

        if (maxValue == null || value > maxValue) maxValue = value;

        list.add(value);
    }

    public Integer pop() {

        if (list.isEmpty()) return null;

        Integer popValue = list.get(list.size() - 1);
        list.remove(popValue);

        return popValue;
    }

    public Integer getMaxValue() {
        return maxValue;
    }

    public Integer getSize() {
        if (list.isEmpty()) return 0;
        return list.size();
    }

    public void print() {
        for (int value : list) {
            System.out.println(value);
        }
    }
}
