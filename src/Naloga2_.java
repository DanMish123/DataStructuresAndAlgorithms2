import java.util.*;

public class Naloga2_ {
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
                case "merge":
                    if (trace_count.equals("count")) {
                        String s1 = mergeSortCount(array, "up");
                        String s2 = mergeSortCount(array, "up");
                        String s3 = mergeSortCount(array, "down");
                        System.out.println(s1 + s2 + s3.substring(0, s3.length() - 3));
                    } else if (trace_count.equals("trace")) {
                        for (int j : array) System.out.print(j + " ");
                        System.out.println();
                        mergeSortTrace(array, 0, array.length - 1, direction);
                    }
                    break;
                case "radix":
                    if (trace_count.equals("count")) {
                        String s1 = radixSortCountDescending(array);
                        String s2 = radixSortCountDescending(array);
                        String s3 = radixSortCountDescending(array);
                        System.out.println(s1 + s2 + s3.substring(0, s3.length() - 3));
                    } else if (trace_count.equals("trace")) {
                        radixSortTrace(array);
                    }
                    break;
                case "quick":
                    if (trace_count.equals("count")) {
                        String s1 = quickSortCount(array, true);
                        String s2 = quickSortCount(array, true);
                        String s3 = quickSortCount(array, false);
                        System.out.println(s1 + s2 + s3.substring(0, s3.length() - 3));
                    } else if (trace_count.equals("trace")) {
                        printArrayWithoutBrackets(array);
                        quickSortTrace(array, 0, array.length - 1, true);
                        printArrayWithoutBrackets(array);
                    }
                    break;
                case "bucket":
                    if (trace_count.equals("count")) {
                        String s1 = bucketSortCount(array, false);
                        String s2 = bucketSortCount(array, false);
                        String s3 = bucketSortCount(array, true);
                        System.out.println(s1 + s2 + s3.substring(0, s3.length() - 3));
                    } else if (trace_count.equals("trace")) {
                        bucketSort(array, true);
                        printArrayWithoutBrackets(array);
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
                case "merge":
                    if (trace_count.equals("count")) {
                        String s1 = mergeSortCount(array, "down");
                        String s2 = mergeSortCount(array, "down");
                        String s3 = mergeSortCount(array, "up");
                        System.out.println(s1 + s2 + s3.substring(0, s3.length() - 3));
                    } else if (trace_count.equals("trace")) {
                        for (int j : array) System.out.print(j + " ");
                        System.out.println();
                        mergeSortTrace(array, 0, array.length - 1, direction);
                    }
                    break;
                case "radix":
                    if (trace_count.equals("count")) {
                        String s1 = radixSortCountDescending(array);
                        String s2 = radixSortCountDescending(array);
                        String s3 = radixSortCountDescending(array);
                        System.out.println(s1 + s2 + s3.substring(0, s3.length() - 3));
                    } else if (trace_count.equals("trace")) {
                        radixSortTraceDescending(array);
                    }
                    break;
                case "quick":
                    if (trace_count.equals("count")) {
                        String s1 = quickSortCount(array, false);
                        String s2 = quickSortCount(array, false);
                        String s3 = quickSortCount(array, true);
                        System.out.println(s1 + s2 + s3.substring(0, s3.length() - 3));
                    } else if (trace_count.equals("trace")) {
                        printArrayWithoutBrackets(array);
                        quickSortTrace(array, 0, array.length - 1, false);
                        printArrayWithoutBrackets(array);
                    }
                    break;
                case "bucket":
                    if (trace_count.equals("count")) {
                        String s1 = bucketSortCount(array, false);
                        String s2 = bucketSortCount(array, false);
                        String s3 = bucketSortCount(array, true);
                        System.out.println(s1 + s2 + s3.substring(0, s3.length() - 3));
                    } else if (trace_count.equals("trace")) {
                        bucketSort(array, false);
                        printArrayWithoutBrackets(array);
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

    static String mergeSortCount(int[] array, String direction) {
        m = 0;
        c = 0;
        int[] auxiliary = new int[array.length];
        mergeSortHelperCount(array, auxiliary, 0, array.length - 1, direction.equals("up"));
        return String.format("%d %d | ", m, c);
    }

    static void mergeSortHelperCount(int[] array, int[] auxiliary, int left, int right, boolean ascending) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSortHelperCount(array, auxiliary, left, mid, ascending);
            mergeSortHelperCount(array, auxiliary, mid + 1, right, ascending);
            mergeCount(array, auxiliary, left, mid, right, ascending);
        }
    }

    static void mergeCount(int[] array, int[] auxiliary, int left, int mid, int right, boolean ascending) {
        for (int i = left; i <= right; i++) {
            auxiliary[i] = array[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            c++; // Increment comparison count
            if ((ascending && auxiliary[i] <= auxiliary[j]) || (!ascending && auxiliary[i] > auxiliary[j])) {
                m += 2; // Increment movement count by 2 for each merge action
                array[k] = auxiliary[i];
                i++;
            } else {
                m += 2; // Increment movement count by 2 for each merge action
                array[k] = auxiliary[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            m += 2; // Increment movement count by 2 for the rest of the left side
            array[k] = auxiliary[i];
            k++;
            i++;
        }

        while (j <= right) {
            m += 2; // Increment movement count by 2 for the rest of the right side
            array[k] = auxiliary[j];
            k++;
            j++;
        }
    }

    static void printArrayWithoutBrackets2(int[] array, int left, int right, int mid) {
        for (int i = left; i <= right; i++) {
            if (i > left) {
                System.out.print(" ");
            }
            System.out.print(array[i]);
            if (i == mid) {
                System.out.print(" |");
            }
        }
        System.out.println();
    }

    static void mergeSortTrace(int[] array, int left, int right, String direction) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            printArrayWithoutBrackets2(array, left, right, mid);
            mergeSortTrace(array, left, mid, direction);
            mergeSortTrace(array, mid + 1, right, direction);
            mergeAndPrintTrace(array, left, mid, right, direction.equals("up"));
        }
    }

    static void mergeAndPrintTrace(int[] array, int left, int mid, int right, boolean ascending) {
        int[] auxiliary = new int[array.length];
        System.arraycopy(array, left, auxiliary, left, right - left + 1);

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if ((ascending && auxiliary[i] <= auxiliary[j]) || (!ascending && auxiliary[i] > auxiliary[j])) {
                array[k] = auxiliary[i];
                i++;
            } else {
                array[k] = auxiliary[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            array[k] = auxiliary[i];
            i++;
            k++;
        }

        while (j <= right) {
            array[k] = auxiliary[j];
            j++;
            k++;
        }

        printArrayWithoutBrackets(Arrays.copyOfRange(array, left, right + 1));
    }

    static void radixSortTrace(int[] array) {
        int max = findMax(array);

        printArrayWithoutBrackets(array);

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSortByDigitTrace(array, exp);
            printArrayWithoutBrackets(array);
        }
    }
    static void countSortByDigitTrace(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++) {
            c++;
            count[(array[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            c++;
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        for (int i = 0; i < n; i++) {
            array[i] = output[i];
        }
    }

    static int findMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
    static void countSortByDigitDescending(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n]; 
        int[] count = new int[10];

        
        for (int i = 0; i < n; i++) {
            c++;
            count[9 - (array[i] / exp) % 10]++;
        }

        
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        
        for (int i = n - 1; i >= 0; i--) {
            output[count[9 - (array[i] / exp) % 10] - 1] = array[i];
            count[9 - (array[i] / exp) % 10]--;
            m++; 
            c++;
        }

        for (int i = 0; i < n; i++) {
            array[i] = output[i];
            m++; 
        }
    }
    static String radixSortCountDescending(int[] array) {
        m = 0; 
        c = 0; 

        int max = findMax(array);

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSortByDigitDescending(array, exp);
        }

        return String.format("%d %d | ", m, c);
    }
    static void radixSortTraceDescending(int[] array) {
        int max = findMax(array);

        printArrayWithoutBrackets(array);

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSortByDigitTraceDescending(array, exp);
            printArrayWithoutBrackets(array);
        }
    }
    static void countSortByDigitTraceDescending(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n];
        int[] count = new int[10];

    
        for (int i = 0; i < n; i++) {
            c++;
            count[9 - (array[i] / exp) % 10]++;
        }

        
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        
        for (int i = n - 1; i >= 0; i--) {
            output[count[9 - (array[i] / exp) % 10] - 1] = array[i];
            count[9 - (array[i] / exp) % 10]--;
        }

        for (int i = 0; i < n; i++) {
            array[i] = output[i];
        }
    }
    static void printArrayWithoutBrackets(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + (i < array.length - 1 ? " " : ""));
        }
        System.out.println();
    }

    static String quickSortCount(int[] array, boolean ascending) {
        m = 0; c = 0;
        quickSortCountHelper(array, 0, array.length - 1, ascending);
        return String.format("%d %d | ", m, c);
    }

    static void quickSortCountHelper(int[] array, int left, int right, boolean ascending) {
        if (left < right) {
            int pi = partition(array, left, right, ascending);
            quickSortCountHelper(array, left, pi - 1, ascending);
            quickSortCountHelper(array, pi + 1, right, ascending);
        }
    }

    public static int partition(int[] array, int left, int right, boolean ascending) {
        if (ascending) {
            int pivot = array[left];
            m++;
            int l = left;
            int r = right + 1;

            while (true) {
                do {
                    c++;
                    l++;
                } while (l < right && array[l] < pivot);

                do {
                    c++;
                    r--;
                } while (array[r] > pivot);

                if (l >= r) {
                    break;
                }
                swap(array, l, r);
                m+=3;
            }

            swap(array, left, r);
            m+=3;
            return r;
        } else {
            int pivot = array[left];
            m++;
            int l = left;
            int r = right + 1;
            while (true) {
                do {
                    c++;
                    l++;
                } while (l < right && array[l] > pivot);

                do {
                    c++;
                    r--;
                } while (array[r] < pivot);

                if (l >= r) {
                    break;
                }
                swap(array, l, r);
                m+=3;
            }
            swap(array, left, r);
            m+=3;
            return r;
        }
    }

    static void quickSortTrace(int[] array, int left, int right, boolean ascending) {
        if (left < right) {
            int pi = partition(array, left, right, ascending);
            printArrayWithPivot(array, left, right, pi);
            quickSortTrace(array, left, pi - 1, ascending);
            quickSortTrace(array, pi + 1, right, ascending);
        }
    }
    static void printArrayWithPivot(int[] array, int left, int right, int pivotIndex) {
        for (int i = left; i <= right; i++) {
            if (i == pivotIndex) {
                System.out.print("| " + array[i] + " | ");
            } else {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println();
    }

    static void printArrayWithoutBrackets2(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    static int printSeparator(int currentIndex, int arrayLength) {
        if (currentIndex+1 < arrayLength) {
            System.out.println("|");
        }
        return currentIndex+1;
    }

    static void bucketSort(int[] array, boolean ascending) {
        int max = findMax(array);
        int min = findMin(array);
        int bucketCount = array.length / 2; 
        int bucketRange = (max - min + 1) / bucketCount; 

        
        if (bucketRange * bucketCount < (max - min + 1)) {
            bucketRange++;
        }

        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        
        for (int num : array) {
            int bucketIndex = (num - min) / bucketRange;
            if (bucketIndex >= bucketCount) {
                bucketIndex = bucketCount - 1;
            }
            buckets.get(bucketIndex).add(num);
        }

        for (List<Integer> bucket : buckets) {
            int[] bucketArray = bucket.stream().mapToInt(i -> i).toArray();
            insertionSort(bucketArray, ascending);
        }

        int index = 0;
        for (List<Integer> bucket : buckets) {
            int[] bucketArray = bucket.stream().mapToInt(Integer::intValue).toArray();
            insertionSort(bucketArray, ascending);
            for (int i = 0; i < bucketArray.length; i++) {
                array[index] = bucketArray[i];
                if (i < bucketArray.length - 1) {
                    System.out.print(bucketArray[i] + " ");
                } else {
                    System.out.print(bucketArray[i]);
                }
            }
            index = printSeparator(index, array.length);
        }
        printArrayWithoutBrackets2(array);
    }


    static void insertionSort(int[] bucket, boolean ascending) {
        for (int i = 1; i < bucket.length; i++) {
            int current = bucket[i];
            int j = i;
            while (j > 0) {
                c++; 
                if ((ascending && bucket[j-1] > current) || (!ascending && bucket[j-1] < current)) {
                    bucket[j] = bucket[j-1];
                    j--;
                    m++; 
                } else {
                    break;
                }
            }
            bucket[j] = current;
            if (i != j + 1) {
                m++; 
            }
        }
    }


    static int findMin(int[] array) {
        int min = array[0];
        for (int num : array) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }
    static String bucketSortCount(int[] array, boolean ascending) {
        m = 0; 
        c = 0; 

        int max = findMax(array);
        int min = findMin(array);
        int bucketCount = array.length / 2; 
        int bucketRange = (max - min + 1) / bucketCount; 

        
        if (bucketRange * bucketCount < (max - min + 1)) {
            bucketRange++;
        }

        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        
        for (int num : array) {
            int bucketIndex = (num - min) / bucketRange;
            if (bucketIndex >= bucketCount) {
                bucketIndex = bucketCount - 1;
            }
            buckets.get(bucketIndex).add(num);
            c++; 
        }

        
        int index = 0;
        for (List<Integer> bucket : buckets) {
            int[] bucketArray = bucket.stream().mapToInt(i -> i).toArray();
            insertionSort(bucketArray, ascending); 
            for (int num : bucketArray) {
                array[index++] = num;
                m++; 
            }
        }
        return String.format("%d %d | ", m, c);
    }
}