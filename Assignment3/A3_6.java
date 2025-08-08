package A3;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class A3_6<Key extends Comparable<Key>, Value> implements Iterable<Key> {
    private Node first;
    private int size;

    private class Node {
        Key key;
        Value value;
        Node next;

        Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public A3_6() {
        first = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Value get(Key key) {
        Node x = first;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp == 0) return x.value;  // Key found
            if (cmp < 0) break;  // Key not in the table
            x = x.next;
        }
        return null;
    }

    public void put(Key key, Value value) {
        if (first == null || key.compareTo(first.key) < 0) {
            first = new Node(key, value, first);
            size++;
            return;
        }

        Node prev = null, x = first;
        while (x != null && key.compareTo(x.key) > 0) {
            prev = x;
            x = x.next;
        }

        if (x != null && key.compareTo(x.key) == 0) {
            x.value = value;  // Update existing key
        } else {
            prev.next = new Node(key, value, x);  // Insert new node
            size++;
        }
    }

    public void delete(Key key) {
        if (first == null) return;

        if (key.compareTo(first.key) == 0) {
            first = first.next;
            size--;
            return;
        }

        Node prev = first, x = first.next;
        while (x != null) {
            if (key.compareTo(x.key) == 0) {
                prev.next = x.next;
                size--;
                return;
            }
            prev = x;
            x = x.next;
        }
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Iterable<Key> keys() {
        return this;
    }

    @Override
    public Iterator<Key> iterator() {
        return new Iterator<Key>() {
            private Node current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Key next() {
                if (!hasNext()) throw new NoSuchElementException();
                Key key = current.key;
                current = current.next;
                return key;
            }
        };
    }

    public static void main(String[] args) {
        A3_6<String, Integer> st = new A3_6<>();
        st.put("A", 1);
        st.put("B", 2);
        st.put("C", 3);

        System.out.println("Value for B: " + st.get("B"));
        System.out.println("Contains A? " + st.contains("A"));
        st.delete("A");
        System.out.println("Contains A after deletion? " + st.contains("A"));
        
        System.out.println("Keys in symbol table:");
        for (String key : st.keys()) {
            System.out.println(key);
        }
    }
}
