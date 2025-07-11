import java.util.Arrays;
import java.util.*;
import java.io.*;


public class Q1 {

    public static void rearrangeScores(int[] scores, int left, int right) {
        if (left >= right) return; 

        if (scores[left] % 2 == 0) {
            int temp = scores[left];
            scores[left] = scores[right];
            scores[right] = temp;
            rearrangeScores(scores, left, right - 1);
        } else {
            rearrangeScores(scores, left + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] scores = {85, 72, 91, 88, 77, 64, 95, 90, 81, 66}; // Unsorted score array
        System.out.println("Before Sorting: " + Arrays.toString(scores));

        rearrangeScores(scores, 0, scores.length - 1);

        System.out.println("After Sorting: " + Arrays.toString(scores));
    }
}