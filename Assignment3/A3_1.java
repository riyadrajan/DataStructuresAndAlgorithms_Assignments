package A3;

public class A3_1 {
    private static int iteration = 0;
    private static int pass = 1;
    private static void sort(Comparable[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, gt = hi;
        Comparable v = a[lo];
        int i = lo;
        
        System.out.println("Pass number " + pass);
        System.out.println("It  lt  i  gt   a[]");
        System.out.println("---------------------------");

        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) exch(a, lt++, i++);
            else if (cmp > 0) exch(a, i, gt--);
            else i++;

            print(a, lt, iteration++, i, gt); // Prints the trace after each iteration
            
        }
        System.out.println();
                pass++;

        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static void print(Comparable[] a, int lt, int it, int i, int gt) {
        System.out.printf("%2d %2d %2d %3d  ", it, lt, i, gt);
        for (Comparable val : a) {
            System.out.printf("%3s", val);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String array[] = {"B", "A", "B", "A", "B", "A", "B", "A",
                "C", "A", "D", "A", "B", "R", "A"};

        sort(array);
    }
}
