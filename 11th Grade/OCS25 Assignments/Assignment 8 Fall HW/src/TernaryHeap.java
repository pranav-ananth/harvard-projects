public class TernaryHeap<T extends Comparable<T>> {

    private T[] heap;
    private int N;

    public TernaryHeap(int capacity) {
        heap = (T[]) new Comparable[capacity + 1]; // 1-indexed
        N = capacity;
    }

    public int getN() {
        return N;
    }

    public void modify(int i, T value) {
        if (i < 1 || i > N) return;
        heap[i] = value;
    }

    public void exchange(int i, int j) {
        T temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void printHeap() {
        for (int i = 1; i <= N; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public void heapsort() {
        int n = N;

        for (int k = n / 3; k >= 1; k--) {
            sink(k, n);
        }

        while (n > 1) {
            exchange(1, n--);
            sink(1, n);
        }
    }

    private void sink(int k, int n) {
        while (true) {
            int c1 = 3 * k - 1;
            int c2 = 3 * k;
            int c3 = 3 * k + 1;
            int largest = k;

            if (c1 <= n && less(heap[largest], heap[c1])) largest = c1;
            if (c2 <= n && less(heap[largest], heap[c2])) largest = c2;
            if (c3 <= n && less(heap[largest], heap[c3])) largest = c3;

            if (largest != k) {
                exchange(k, largest);
                k = largest;
            } else {
                break;
            }
        }
    }

    private boolean less(T a, T b) {
        return a.compareTo(b) < 0;
    }
}
