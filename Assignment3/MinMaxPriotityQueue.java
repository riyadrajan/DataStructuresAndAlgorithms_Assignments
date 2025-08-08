package A3;
import java.util.*;
/*
 * Use a min-oriented heap for removing the minimum -> O(logn) time
 * Use a max_oriented heap for removing the maximum -> O(logn) time
 */
public class MinMaxPriotityQueue {
    public static class MinMaxPQ<Key extends Comparable<Key>> {
        private Key[] minPQ; //first heap
        private Key[] maxPQ; //second heap
        private int n;
        
        //According to the implementation from pg 23 in the PQ slides
        public MinMaxPQ(int capacity) {
            minPQ = (Key[]) new Comparable[capacity + 1];
            maxPQ = (Key[]) new Comparable[capacity + 1];
            n = 0;
        }
        
        //All the following functions are implementation from the slides
        public boolean isEmpty() {
            return n == 0;
        }
        
        
        public void insert(Key key) {
            minPQ[++n] = key;
            maxPQ[n] = key;
            swimMin(n);
            swimMax(n);
        }

        public Key findMin() {
            return minPQ[1];
        }

        public Key findMax() {
            return maxPQ[1];
        }

        public Key delMin() {
            Key min = minPQ[1];
            exch(minPQ, 1, n--);
            sinkMin(1);
            return min;
        }

        public Key delMax() {
            Key max = maxPQ[1];
            exch(maxPQ, 1, n--);
            sinkMax(1);
            return max;
        }

        private void swimMin(int k) {
            while (k > 1 && greater(k / 2, k, minPQ)) {
                exch(minPQ, k, k / 2);
                k = k / 2;
            }
        }

        private void swimMax(int k) {
            while (k > 1 && less(k / 2, k, maxPQ)) {
                exch(maxPQ, k, k / 2);
                k = k / 2;
            }
        }

        private void sinkMin(int k) {
            while (2 * k <= n) {
                int j = 2 * k;
                if (j < n && greater(j, j + 1, minPQ)) j++;
                if (!greater(k, j, minPQ)) break;
                exch(minPQ, k, j);
                k = j;
            }
        }

        private void sinkMax(int k) {
            while (2 * k <= n) {
                int j = 2 * k;
                if (j < n && less(j, j + 1, maxPQ)) j++;
                if (!less(k, j, maxPQ)) break;
                exch(maxPQ, k, j);
                k = j;
            }
        }

        private boolean greater(int i, int j, Key[] pq) {
            return pq[i].compareTo(pq[j]) > 0;
        }

        private boolean less(int i, int j, Key[] pq) {
            return pq[i].compareTo(pq[j]) < 0;
        }

        private void exch(Key[] pq, int i, int j) {
            Key t = pq[i];
            pq[i] = pq[j];
            pq[j] = t;
        }
    }

    public static void main(String[] args) {
        MinMaxPQ<Integer> pq = new MinMaxPQ<>(10);
        pq.insert(10);
        pq.insert(20);
        pq.insert(5);
        pq.insert(7);
        pq.insert(2);
        pq.insert(9);
        pq.insert(3);

        System.out.println("Min: " + pq.findMin()); // 2
        System.out.println("Max: " + pq.findMax()); // 20

        pq.delMin();
        System.out.println("Min after deletion: " + pq.findMin()); // 3

        pq.delMax();
        System.out.println("Max after deletion: " + pq.findMax()); // 10
    }
}
