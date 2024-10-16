//poskušal sem, ampak nisem mogel najti rešitev. upam da je to dovolj vsaj za nekaj točk

public class LinkedHeapPQ<T extends Comparable> implements PriorityQueue<T> {
    private Node root;
    private int size;
    private int comparisons;
    private int moves;

    class Node {
        T item;
        Node left, right, parent;

        Node(T item) {
            this.item = item;
            this.left = null;
            this.right = null;
            this.parent = null;
        }
    }

    public LinkedHeapPQ() {
        root = null;
        size = 0;
        comparisons = 0;
        moves = 0;
    }

    public int getMoves() {
        return moves;
    }

    public int getComparisons() {
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

    private Node lastNode(int index) {
        String indexBin = Integer.toBinaryString(index);
        for (int i = 1; i < indexBin.length() - 1; i++) {
            char dir = indexBin.charAt(i);
            if (dir == '0') root = root.left;
            else root = root.right;
        }
        return root;
    }

    void siftUp(Node node) {
        while ((node.parent != null) && (node.item.compareTo(node.parent.item) > 0)) {
            comparisons++;
            T temp = node.item;
            node.item = node.parent.item;
            node.parent.item = temp;
            node = node.parent;
            moves++;
        }
    }

    void siftDown(Node node) {
        while (node.left != null) {
            Node max = node.left;
            if (node.right != null && node.right.item.compareTo(node.left.item) > 0) {
                comparisons++;
                max = node.right;
                moves++;
            }
            if (max.item.compareTo(node.item) > 0) {
                comparisons++;
                T temp = node.item;
                node.item = max.item;
                max.item = temp;
                node = max;
                moves++;
            } else break;
        }
    }

    @Override
    public T front() throws CollectionException {
        if (isEmpty())
            throw new CollectionException(ERR_MSG_EMPTY);
        return root.item;
    }

    @Override
    public void enqueue(T x) {
        Node node = new Node(x);
        if (isEmpty()) root = node;
        else {
            Node lastNode = lastNode(size + 1);
            if (lastNode.parent.left == null)
                lastNode.parent.left = node;
            else lastNode.parent.right = node;
            node.parent = lastNode.parent;
            moves++;
            siftUp(node);
        }
        size++;
    }

    @Override
    public T dequeue() throws CollectionException {
        if (isEmpty())
            throw new CollectionException(ERR_MSG_EMPTY);
        T max = root.item;
        Node lastNode = lastNode(size);
        if (lastNode.parent != null) {
            T temp = root.item;
            root.item = lastNode.item;
            lastNode.item = temp;
            moves++;
            siftDown(root);
        } else root = null;
        size--;
        return max;
    }
}