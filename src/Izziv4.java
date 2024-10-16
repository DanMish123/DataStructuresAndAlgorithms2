import java.util.Random;

class CollectionException extends Exception {
    public CollectionException(String msg) {
        super(msg);
    }
}

interface Collection {
    static final String ERR_MSG_EMPTY = "Collection is empty.";

    boolean isEmpty();
    int size();
    String toString();
}

interface Queue<T> extends Collection {
    T front() throws CollectionException;
    void enqueue(T x);
    T dequeue() throws CollectionException;
}

interface PriorityQueue<T extends Comparable> extends Queue<T> {
}

public class Izziv4 {
    public static void main(String[] args) throws CollectionException {
        ArrayHeapPQ<Integer> ahpq = new ArrayHeapPQ<>();
        LinkedHeapPQ<Integer> lhpq = new LinkedHeapPQ<>();
        ArrayPQ<Integer> apq = new ArrayPQ<>();

        System.out.print("""
                Objekti: Integer
                Operacije: 1000 enqueue + 1000 (dequeue+enqueue+front)
                Implementacija                     Čas [ms]           Premikov             Primerjav
                --------------------------------------------------------------------------------------\n""");
        PQtest("Neurejeno polje  (64,2x)", apq);
        AHPQtest("Implicitna koplica  (64,2x)", ahpq);
        LHPQtest("Eksplicitna kopica", lhpq);
    }

    public static void PQtest(String tip, ArrayPQ<Integer> apq) throws CollectionException {
            Random rnd = new Random();
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < 1000; i++)
                apq.enqueue(rnd.nextInt());
            for (int i = 0; i < 1000; i++) {
                apq.dequeue();
                apq.enqueue(rnd.nextInt());
                apq.front();
            }
            long executionTime = System.currentTimeMillis() - startTime;
            int premikov = apq.getMoves();
            int primerjav = apq.getComparisons();
            System.out.printf("%s\t\t\t%d\t\t\t\t\t%d\t\t\t\t%d\n",tip, executionTime, premikov, primerjav);
    }

    public static void AHPQtest(String tip, ArrayHeapPQ<Integer> ahpq) throws CollectionException {
        Random rnd = new Random();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++)
            ahpq.enqueue(rnd.nextInt());
        for (int i = 0; i < 1000; i++) {
            ahpq.dequeue();
            ahpq.enqueue(rnd.nextInt());
            ahpq.front();
        }
        long executionTime = System.currentTimeMillis() - startTime;
        int premikov = ahpq.getMoves();
        int primerjav = ahpq.getComparisons();
        System.out.printf("%s\t\t\t%d\t\t\t\t\t%d\t\t\t\t%d\n",tip, executionTime, premikov, primerjav);
    }

    public static void LHPQtest(String tip, LinkedHeapPQ<Integer> lhpq) throws CollectionException {
        Random rnd = new Random();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++)
            lhpq.enqueue(rnd.nextInt());
        for (int i = 0; i < 1000; i++) {
            lhpq.dequeue();
            lhpq.enqueue(rnd.nextInt());
            lhpq.front();
        }
        long executionTime = System.currentTimeMillis() - startTime;
        int premikov = lhpq.getMoves();
        int primerjav = lhpq.getComparisons();
        System.out.printf("%s\t\t\t\t\t%d\t\t\t\t\t%d\t\t\t\t%d\n",tip, executionTime, premikov, primerjav);
    }
}
