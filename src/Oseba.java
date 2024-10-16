import java.util.Random;

public class Oseba implements Comparable<Oseba> {
    private final static String[] IMENA = {"Ana", "Aleksandar", "Bor", "Cvetka", "Dusan", "Ema", "Filip", "Greta", "Halid", "Ivan", "Jernej", "Klemenc"};
    private final static String[] PRIIMKI = {"Novak", "Rozman", "Horvat", "Kovacic", "Zupancic", "Potocnik", "Krajnc", "Mlakar", "Zupan", "Bizjak", "Kovac", "Kralj"};
    private final static int[] LETA = {1910, 2001, 2011, 2003, 1958, 1943, 1986, 1999, 2000, 1919, 1950, 1969, 1915, 2010, 2023, 1975, 1944, 1938, 1920};
    private static int smer = 0;
    private static int atr = 0;

    String ime, priimek;
    int letoR;

    Oseba(){
        int imenaPriimki = new Random().nextInt(IMENA.length);
        int letaIndex = new Random().nextInt(IMENA.length);
        this.ime = IMENA[imenaPriimki];
        this.priimek = PRIIMKI[imenaPriimki];
        this.letoR = LETA[letaIndex];
    }

    public static void setSmer(int smer) {
        Oseba.smer = smer;
    }

    public static void setAtr(int atr) {
        Oseba.atr = atr;
    }

    @Override
    public int compareTo(Oseba o) {
        switch (atr) {
            case 0 -> {
                return this.ime.compareTo(o.ime);
            }
            case 1 -> {
                return this.priimek.compareTo(o.priimek);
            }
            case 2 -> {
                return this.letoR - o.letoR;
            }
        }
        return -1;
    }

    @Override
    public String toString(){
        switch (atr) {
            case 0 -> {
                return ime;
            }
            case 1 -> {
                return priimek;
            }
            case 2 -> {
                return Integer.toString(letoR);
            }
        }
        return "Error";
    }
}
