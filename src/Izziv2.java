public class Izziv2 {

    static int[] generateTable(int n) {
        int[] tabela = new int[n];
        for (int i = 0; i < n; i++)
            tabela[i] = i+1;
        return tabela;
    }

    static int findLinear(int[] a, int v){
        for (int i = 0; i < a.length; i++)
            if (a[i] == v)
                return i;
        return -1;
    }

    static int findBinary(int[] a, int l, int r, int v){
        while (l <= r){
            int mid = l + (r - l) / 2;
            if (v < a[mid])
                r = mid - 1;
            else if (v > a[mid])
                l = mid + 1;
            else return mid;
        }
        return -1;
    }

    static long timeLinear(int n){
        int[] tabela = generateTable(n);
        long totalTime = 0;
        for (int i = 0; i < 1000; i++) {
            int rnd = (int) (Math.random() * n + 1);
            long startTime = System.nanoTime();
            findLinear(tabela, rnd);
            long executionTime = System.nanoTime() - startTime;
            totalTime += executionTime;
        }
        return totalTime / 1000;
    }

    static long timeBinary(int n){
        int[] tabela = generateTable(n);
        long totalTime = 0;
        for (int i = 0; i < 1000; i++) {
            int rnd = (int) (Math.random() * n + 1);
            long startTime = System.nanoTime();
            findBinary(tabela, 0, n-1, rnd);
            long executionTime = System.nanoTime() - startTime;
            totalTime += executionTime;
        }
        return totalTime / 1000;
    }

    static void izpisi(){
        System.out.printf("   n       |     linearno  |   dvojisko  |\n");
        System.out.printf("---------+--------------+------------------\n");
        for (int n = (int) Math.pow(10, 5); n <= Math.pow(10, 6); n+=Math.pow(10, 4))
            System.out.printf("    %d |         %d |           %d\n", n, timeLinear(n), timeBinary(n));
    }

    public static void main(String[] args) {
        izpisi();
    }
}
