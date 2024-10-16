import java.util.Arrays;

@SuppressWarnings({"unchecked", "DataFlowIssue"})
public class ArrayHeapPQ<T extends Comparable> implements PriorityQueue<T>{
    private static int CAPACITY = 64;
    private int size;
    private T[] array;
    private int moves;
    private int comparisons;


    ArrayHeapPQ(){
        size = 0;
        moves = 0;
        comparisons = 0;
        array = (T[]) new Comparable[CAPACITY];
    }

    public int getComparisons(){
        return comparisons;
    }

    public int getMoves(){
        return moves;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T front() throws CollectionException {
        if (isEmpty())
            throw new CollectionException(ERR_MSG_EMPTY);
        return array[0];
    }

    @Override
    public void enqueue(T x) {
        if (size() == array.length)
            resize();
        array[size++] = x;
        moves++;
        int index = size() - 1;
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (array[parent].compareTo(array[index]) > 0) {
                comparisons++;
                break;
            }
            T temp = array[index];
            array[index] = array[parent];
            array[parent] = temp;
            index = parent;
            moves+=3;
        }
    }

    @Override
    public T dequeue() throws CollectionException {
        if (isEmpty())
            throw new CollectionException(ERR_MSG_EMPTY);
        T max = array[0];
        array[0] = array[size-1];
        moves++;
        size--;
        int index = 0;
        while (true){
            int leftChild = 2*index + 1;
            int rightChild = 2*index + 2;
            if (leftChild < size && rightChild < size && array[leftChild].compareTo(array[rightChild]) > 0) {
                T temp = array[index];
                array[index] = array[leftChild];
                array[leftChild] = temp;
                index = leftChild;
                comparisons++;
                moves+=3;
            } else if (leftChild < size && rightChild < size && array[leftChild].compareTo(array[rightChild]) < 0){
                T temp = array[index];
                array[index] = array[rightChild];
                array[rightChild] = temp;
                index = rightChild;
                comparisons++;
                moves+=3;
            } else break;
        }
        return max;
    }

    public void resize(){
        array = Arrays.copyOf(array, 2*CAPACITY);
        CAPACITY *= 2;
    }
}