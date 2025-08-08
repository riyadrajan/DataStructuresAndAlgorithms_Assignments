package A3;
import java.io.*;
import java.util.*;

public class A3_4 {
    public static void main(String[] args) {
        File inputFile = new File("DandV.txt");
        File outputFile = new File("SortedDandV.txt"); // New file for sorted output

        // Create the input file if it doesn't exist
        // Code from W3 schools with exceptions etc.
        try {
            if (inputFile.createNewFile()) {
                System.out.println("File created: " + inputFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("Error creating the file.");
            e.printStackTrace();
        }

        // Array of date-volume entries
        DateWithVolume[] dataEntries = {
            new DateWithVolume(1, "Oct", 28, 3500000),
            new DateWithVolume(30, "Dec", 99, 554680000),
            new DateWithVolume(2, "Oct", 28, 3850000),
            new DateWithVolume(4, "Oct", 28, 4330000),
            new DateWithVolume(4, "Jan", 00, 1009000000),
            new DateWithVolume(5, "Oct", 28, 4360000),
            new DateWithVolume(3, "Oct", 28, 4060000),
            new DateWithVolume(31, "Dec", 99, 374049984),
            new DateWithVolume(3, "Jan", 00, 931800000),
            new DateWithVolume(5, "Jan", 00, 1085500032)
        };

        // Write original data to input file
        try (FileWriter writer = new FileWriter(inputFile)) {
            for (DateWithVolume entry : dataEntries) {
                writer.write(entry + "\n");
            }
            System.out.println("Unsorted data written to file.");
        } catch (IOException e) {
            System.out.println("Error writing to input file.");
            e.printStackTrace();
        }
        
        try (Scanner scanner = new Scanner(inputFile)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading input file.");
            e.printStackTrace();
        }
        System.out.println();

        // Sort the array using HeapSort
        Heap.sort(dataEntries);

        // Write sorted data to the output file
        try (FileWriter writer = new FileWriter(outputFile)) {
            for (DateWithVolume entry : dataEntries) {
                writer.write(entry + "\n");
            }
            System.out.println("Sorted data written to " + outputFile.getName());
        } catch (IOException e) {
            System.out.println("Error writing to sorted file.");
            e.printStackTrace();
        }

       
        // Read and print sorted data from the output file
        System.out.println("\nSorted File Contents:");
        try (Scanner scanner = new Scanner(outputFile)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading sorted file.");
            e.printStackTrace();
        }
    }
}

class Heap {
    public static void sort(Comparable[] a) {
        int n = a.length;

        // Heapify (build max heap)
        for (int k = n / 2 - 1; k >= 0; k--) {
            sink(a, k, n);
        }

        // Sortdown phase
        while (n > 1) {
            exch(a, 0, --n); // Move max to the end
            sink(a, 0, n);
        }
    }

    private static void sink(Comparable[] a, int k, int n) {
        while (2 * k + 1 < n) { // 0-based indexing
            int j = 2 * k + 1; // Left child
            if (j + 1 < n && less(a, j, j + 1)) j++; // Right child is larger
            if (!less(a, k, j)) break; // If parent is larger, stop
            exch(a, k, j);
            k = j;
        }
    }

    private static boolean less(Comparable[] a, int i, int j) {
        return a[i].compareTo(a[j]) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}

class DateWithVolume implements Comparable<DateWithVolume> {
    private int day;
    private String month;
    private int year;
    private int volume;

    public DateWithVolume(int day, String month, int year, int volume) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.volume = volume;
    }

    public String getDate() {
        return day + "-" + month + "-" + String.format("%02d", year);
    }

    public int getVolume() {
        return volume;
    }

    @Override
    public int compareTo(DateWithVolume other) {
        return Integer.compare(this.volume, other.volume); // Sort by volume
    }

    @Override
    public String toString() {
        return String.format("%-12s %d", getDate(), volume);
    }
}
