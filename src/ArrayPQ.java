import java.util.Arrays;

@SuppressWarnings({"unchecked", "DataFlowIssue"})
public class ArrayPQ<T extends Comparable> implements PriorityQueue<T> {
    private static int CAPACITY = 64;
    private int size;
    private T[] array;
    private int moves;
    private int comparisons;


    ArrayPQ(){
        size = 0;
        moves = 0;
        comparisons = 0;
        array = (T[]) new Comparable[CAPACITY];
    }

    public int getMoves(){
        return moves;
    }

    public int getComparisons(){
        return comparisons;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T front() throws CollectionException {
        if (isEmpty())
            throw new CollectionException(ERR_MSG_EMPTY);
        T max = array[0];
        for (int i = 1; i < size(); i++) {
            if (array[i].compareTo(max) > 0) {
                comparisons++;
                max = array[i];
                moves++;
            }
        }
        return max;
    }

    @Override
    public void enqueue(T x) {
        if (size() == array.length)
            resize();
        array[size++] = x;
        moves++;
    }

    @Override
    public T dequeue() throws CollectionException {
        if (isEmpty())
            throw new CollectionException(ERR_MSG_EMPTY);
        T max = array[0];
        int index = 0;
        for (int i = 1; i < size(); i++) {
            if (array[i].compareTo(max) > 0) {
                comparisons++;
                max = array[i];
                moves++;
                index = i;
            }
        }
        array[index] = array[size-1];
        size--;
        moves++;
        return max;
    }

    public void resize(){
        array = Arrays.copyOf(array, 2*CAPACITY);
        CAPACITY *= 2;
    }
}
