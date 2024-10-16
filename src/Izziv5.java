import java.util.Arrays;
import java.util.Scanner;

public class Izziv5 {

    static void printArray(Oseba[] array, int index) {
        for (int k = 0; k < array.length; k++) {
            if (k == index) {
                System.out.print("| ");
            }
            System.out.print(array[k] + " ");
        }
        System.out.println();
    }

    static void swap(Oseba[] array, int a, int b){
        Oseba t = array[a];
        array[a] = array[b];
        array[b] = t;
    }

    static void bubbleUp(Oseba[] array){
        for (int i = 0; i < array.length;) {
            int lastSwap = i;
            for (int j = array.length - 1; j > i; j--) {
                if (array[j].compareTo(array[j-1]) < 0) {
                    swap(array, j, j-1);
                    lastSwap = j;
                }
            }
            if (lastSwap == i)
                break;
            i = lastSwap;
            printArray(array, i - 1);
        }
    }

    static void bubbleDown(Oseba[] array){
        for (int i = 0; i < array.length;) {
            int lastSwap = i;
            for (int j = array.length - 1; j > i; j--) {
                if (array[j].compareTo(array[j-1]) > 0){
                    swap(array, j, j-1);
                    lastSwap = j;
                }
            }
            if (lastSwap == i)
                break;
            i = lastSwap;
            printArray(array, i - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vnesi velikost: ");
        int n = Integer.parseInt(sc.nextLine());
        Oseba[] tt = new Oseba[n];
        for (int i = 0; i < n; i++) {
            Oseba o = new Oseba();
            tt[i] = o;
        }
        Oseba[] t = new Oseba[n];
        while (true) {
            System.arraycopy(tt, 0, t, 0, n);
            System.out.println(Arrays.toString(t));
            Oseba.setAtr(1);
            System.out.println(Arrays.toString(t));
            Oseba.setAtr(2);
            System.out.println(Arrays.toString(t));
            System.out.println("Vnesi atribut: ");
            int atr = Integer.parseInt(sc.nextLine());
            Oseba.setAtr(atr);
            System.out.println("Vnesi smer: ");
            int smer = Integer.parseInt(sc.nextLine());
            Oseba.setSmer(smer);
            if (smer == 1)
                bubbleUp(t);
            else if (smer == -1)
                bubbleDown(t);
            System.out.println("Ponovitev ali konec? (1 ali 0)");
            int odgovor = Integer.parseInt(sc.nextLine());
            if (odgovor == 0)
                break;
        }
    }
}
