package march;

/**
 * Queue with two stacks
 */
public class QueueWithTwoStacks {

    private StackWithMaxValue firstStack = new StackWithMaxValue();
    private StackWithMaxValue secondStack = new StackWithMaxValue();

    public void push(Integer value) {
        firstStack.push(value);
    }

    public Integer pop() {

        Integer valueForPop;

        if (firstStack.getSize() > 1) {

            int firstSize = firstStack.getSize() - 1;
            for (int i = 0; i < firstSize; i++) {
                secondStack.push(firstStack.pop());
            }

            valueForPop = firstStack.pop();

            int secondSize = secondStack.getSize();
            for (int i = 0; i < secondSize; i++) {
                firstStack.push(secondStack.pop());
            }

        } else {
            valueForPop = firstStack.pop();
        }

        return valueForPop;
    }
}
