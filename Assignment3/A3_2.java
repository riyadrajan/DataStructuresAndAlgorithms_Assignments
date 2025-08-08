package A3;

public class A3_2 {
    
    private static void sort(Comparable[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;

        Comparable v = a[lo]; // Choose pivot
        int p = lo, q = hi; // Equal elements will be placed here
        int i = lo, j = hi; // Scanning pointers

        // Partitioning loop 
        while (i <= j) {
            while (i <= j && a[i].compareTo(v) < 0) i++;  // Move i forward if a[i] < v 
            while (i <= j && a[j].compareTo(v) > 0) j--;  // Move j backward if a[j] > v
            
            if (i <= j) {
                exch(a, i, j);
                
                // Handle equal elements *after* swapping
                if (a[i].compareTo(v) == 0) exch(a, p++, i);
                if (a[j].compareTo(v) == 0) exch(a, q--, j);
                
                i++;
                j--;
            }
            printArray(a);
            System.out.println();
        }

        // Move equal elements back to the middle
        for (int k = lo; k < p && j >= lo; k++, j--) {
            exch(a, k, j);
        }
        for (int k = hi; k > q && i <= hi; k--, i++) {
            exch(a, k, i);
        }

        // Recursive sorting
        sort(a, lo, j);
        sort(a, i, hi);
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void main(String[] args) {
        String[] array = { "B", "A", "B", "A", "B", "A", "B", "A",
                "C", "A", "D", "A", "B", "R", "A" };

        System.out.println("Before Sorting:");
        printArray(array);

        sort(array);

        System.out.println("\nAfter Sorting:");
        printArray(array);
    }

    private static void printArray(Comparable[] array) {
        for (Comparable element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
