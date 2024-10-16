import java.util.*;

public class Naloga2 {
    private static int m = 0;
    private static int c = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] instructions = sc.nextLine().split("\\s");
        String[] numbers = sc.nextLine().split("\\s");
        String trace_count = instructions[0];
        String sort = instructions[1];
        String direction = instructions[2];
        int[] array = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++)
            array[i] = Integer.parseInt(numbers[i]);
        if (direction.equals("up")) {
            switch (sort) {
                case "insert":
                    if (trace_count.equals("count")) {
                        String s1 = insertUpCount(array);
                        String s2 = insertUpCount(array);
                        String s3 = insertDownCount(array);
                        String s4 = s1 + s2 + s3;
                        System.out.println(s4.substring(0, s4.length() - 3));
                    } else if (trace_count.equals("trace")) {
                        for (int j : array) System.out.print(j + " ");
                        System.out.println();
                        insertUpTrace(array);
                    }
                    break;
                case "select":
                    if (trace_count.equals("count")) {
                        String s1 = selectUpCount(array);
                        String s2 = selectUpCount(array);
                        String s3 = selectDownCount(array);
                        String s4 = s1 + s2 + s3;
                        System.out.println(s4.substring(0, s4.length() - 3));
                    } else if (trace_count.equals("trace")) {
                        for (int j : array) {
                            System.out.print(j + " ");
                        }
                        System.out.println();
                        selectUpTrace(array);
                    }
                    break;
                case "bubble":
                    if (trace_count.equals("count")) {
                        String s1 = bubbleUpCount(array);
                        String s2 = bubbleUpCount(array);
                        String s3 = bubbleDownCount(array);
                        String s4 = s1 + s2 + s3;
                        System.out.println(s4.substring(0, s4.length() - 3));
                    } else if (trace_count.equals("trace")) {
                        for (int j : array) System.out.print(j + " ");
                        System.out.println();
                        bubbleUpTrace(array);
                    }
                    break;
                case "heap":
                    if (trace_count.equals("count")) {
                        String s1 = heapUpCount(array);
                        String s2 = heapUpCount(array);
                        String s3 = heapDownCount(array);
                        String s4 = s1 + s2 + s3;
                        System.out.println(s4.substring(0, s4.length() - 3));
                    } else if (trace_count.equals("trace")) {
                        for (int j : array) System.out.print(j + " ");
                        System.out.println();
                        heapUpTrace(array);
                    }
                    break;
            }
        } else if (direction.equals("down")) {
            switch (sort) {
                case "insert":
                    if (trace_count.equals("count")) {
                        String s1 = insertDownCount(array);
                        String s2 = insertDownCount(array);
                        String s3 = insertUpCount(array);
                        String s4 = s1 + s2 + s3;
                        System.out.println(s4.substring(0, s4.length() - 3));
                    } else if (trace_count.equals("trace")) {
                        for (int j : array) System.out.print(j + " ");
                        System.out.println();
                        insertDownTrace(array);
                    }
                    break;
                case "select":
                    if (trace_count.equals("count")) {
                        String s1 = selectDownCount(array);
                        String s2 = selectDownCount(array);
                        String s3 = selectUpCount(array);
                        String s4 = s1 + s2 + s3;
                        System.out.println(s4.substring(0, s4.length() - 3));
                    } else if (trace_count.equals("trace")) {
                        for (int j : array) {
                            System.out.print(j + " ");
                        }
                        System.out.println();
                        selectDownTrace(array);
                    }
                    break;
                case "bubble":
                    if (trace_count.equals("count")) {
                        String s1 = bubbleDownCount(array);
                        String s2 = bubbleDownCount(array);
                        String s3 = bubbleUpCount(array);
                        String s4 = s1 + s2 + s3;
                        System.out.println(s4.substring(0, s4.length() - 3));
                    } else if (trace_count.equals("trace")) {
                        for (int j : array) System.out.print(j + " ");
                        System.out.println();
                        bubbleDownTrace(array);
                    }
                    break;
                case "heap":
                    if (trace_count.equals("count")) {
                        String s1 = heapDownCount(array);
                        String s2 = heapDownCount(array);
                        String s3 = heapUpCount(array);
                        String s4 = s1 + s2 + s3;
                        System.out.println(s4.substring(0, s4.length() - 3));
                    } else if (trace_count.equals("trace")) {
                        for (int j : array) System.out.print(j + " ");
                        System.out.println();
                        heapDownTrace(array);
                    }
                    break;
            }
        }
    }

    static void swap(int[] array, int a, int b) {
        int t = array[a];
        array[a] = array[b];
        array[b] = t;
    }

    static void izpisiTrace(int[] array, int i) {
        for (int index = 0; index < array.length; index++) {
            System.out.print(array[index]);
            if (index < i) {
                System.out.print(" ");
            } else if (index == i) {
                System.out.print(" | ");
            } else {
                System.out.print(" ");
            }
        }
    }

    static void izpisiTraceNewline(int[] array, int i) {
        for (int index = 0; index < array.length; index++) {
            System.out.print(array[index]);
            if (index < i) {
                System.out.print(" ");
            } else if (index == i) {
                System.out.print(" | ");
            } else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    static String insertUpCount(int[] array) {
        m = 0;
        c = 0;
        for (int i = 1; i < array.length; i++) {
            int k = array[i];
            m++;
            int j = i;
            while (j > 0) {
                c++;
                if (array[j - 1] > k) {
                    array[j] = array[j - 1];
                    j = j - 1;
                    m++;
                } else break;
            }
            array[j] = k;
            m++;
        }
        return String.format("%d %d | ", m, c);
    }

    static String insertDownCount(int[] array) {
        m = 0;
        c = 0;
        for (int i = 1; i < array.length; i++) {
            int k = array[i];
            m++;
            int j = i;
            while (j > 0) {
                c++;
                if (array[j - 1] < k) {
                    array[j] = array[j - 1];
                    j = j - 1;
                    m++;
                } else break;
            }
            array[j] = k;
            m++;
        }
        return String.format("%d %d | ", m, c);
    }

    static void insertUpTrace(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int k = array[i];
            int j = i;
            while (j > 0 && array[j - 1] > k) {
                array[j] = array[j - 1];
                j = j - 1;
            }
            array[j] = k;
            izpisiTrace(array, i);
            System.out.println();
        }
    }

    static void insertDownTrace(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int k = array[i];
            int j = i;
            while (j > 0 && array[j - 1] < k) {
                array[j] = array[j - 1];
                j = j - 1;
            }
            array[j] = k;
            izpisiTrace(array, i);
            System.out.println();
        }
    }

    static String selectUpCount(int[] array) {
        m = 0;
        c = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int n = i;
            for (int j = i + 1; j < array.length; j++) {
                c++;
                if (array[j] < array[n])
                    n = j;
            }
            swap(array, i, n);
            m += 3;
        }
        return String.format("%d %d | ", m, c);
    }

    static String selectDownCount(int[] array) {
        m = 0;
        c = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int n = i;
            for (int j = i + 1; j < array.length; j++) {
                c++;
                if (array[j] > array[n])
                    n = j;
            }
            swap(array, i, n);
            m += 3;
        }
        return String.format("%d %d | ", m, c);
    }

    static void selectUpTrace(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int n = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[n])
                    n = j;
            }
            swap(array, i, n);
            izpisiTraceNewline(array, i);
        }
    }

    static void selectDownTrace(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int n = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > array[n])
                    n = j;
            }
            swap(array, i, n);
            izpisiTraceNewline(array, i);
        }
    }

    static String bubbleUpCount(int[] array) {
        m = 0;
        c = 0;
        for (int i = 0; i < array.length; ) {
            int lastSwap = i;
            for (int j = array.length - 1; j > i; j--) {
                c++;
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                    lastSwap = j;
                    m += 3;
                }
            }
            if (lastSwap == i)
                break;
            i = lastSwap;
        }
        return String.format("%d %d | ", m, c);
    }

    static String bubbleDownCount(int[] array) {
        m = 0;
        c = 0;
        for (int i = 0; i < array.length; ) {
            int lastSwap = i;
            for (int j = array.length - 1; j > i; j--) {
                c++;
                if (array[j] > array[j - 1]) {
                    swap(array, j, j - 1);
                    lastSwap = j;
                    m += 3;
                }
            }
            if (lastSwap == i)
                break;
            i = lastSwap;
        }
        return String.format("%d %d | ", m, c);
    }

    static void bubbleUpTrace(int[] array) {
        for (int i = 0; i < array.length; ) {
            int lastSwap = i;
            boolean x = false;
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                    lastSwap = j;
                    x = true;
                }
            }
            if (x)
                izpisiTraceNewline(array, lastSwap - 1);
            else if (lastSwap != array.length - 1) {
                izpisiTraceNewline(array, array.length - 2);
            }
            if (lastSwap == i)
                break;
            i = lastSwap;
        }
    }

    static void bubbleDownTrace(int[] array) {
        for (int i = 0; i < array.length; ) {
            int lastSwap = i;
            boolean x = false;
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] > array[j - 1]) {
                    swap(array, j, j - 1);
                    lastSwap = j;
                    x = true;
                }
            }
            if (x)
                izpisiTraceNewline(array, lastSwap - 1);
            else if (lastSwap != array.length - 1) {
                izpisiTraceNewline(array, array.length - 2);
            }
            if (lastSwap == i)
                break;
            i = lastSwap;
        }
    }

    static void heapDownTrace(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--)
            siftUp(array, array.length, i);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1)
                System.out.print(" ");
        }
        System.out.println(" | ");
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            siftUp(array, i, 0);
            izpisiTraceNewline(array, i - 1);
        }
    }

    static void heapUpTrace(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--)
            siftDown(array, array.length, i);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1)
                System.out.print(" ");
        }
        System.out.println(" | ");
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            siftDown(array, i, 0);
            izpisiTraceNewline(array, i - 1);
        }
    }

    static String heapUpCount(int[] array) {
        c = 0;
        m = 0;
        for (int i = array.length / 2 - 1; i >= 0; i--)
            siftDown(array, array.length, i);
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            m += 3;
            siftDown(array, i, 0);
        }
        return String.format("%d %d | ", m, c);
    }

    static String heapDownCount(int[] array) {
        c = 0;
        m = 0;
        for (int i = array.length / 2 - 1; i >= 0; i--)
            siftUp(array, array.length, i);
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            m += 3;
            siftUp(array, i, 0);
        }
        return String.format("%d %d | ", m, c);
    }

    static void siftUp(int[] array, int size, int i) {
        int smallest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        if (leftChild < size) {
            c++;
            if (array[leftChild] < array[smallest]) {
                smallest = leftChild;
            }
        }
        if (rightChild < size) {
            c++;
            if (array[rightChild] < array[smallest]) {
                smallest = rightChild;
            }
        }
        if (smallest != i) {
            swap(array, i, smallest);
            m += 3;
            siftUp(array, size, smallest);
        }
    }

    static void siftDown(int[] array, int size, int i) {
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        if (leftChild < size) {
            c++;
            if (array[leftChild] > array[largest]) {
                largest = leftChild;
            }
        }
        if (rightChild < size) {
            c++;
            if (array[rightChild] > array[largest]) {
                largest = rightChild;
            }
        }
        if (largest != i) {
            swap(array, i, largest);
            m += 3;
            siftDown(array, size, largest);
        }
    }
}