import java.util.*;

public class ThreeWayQuicksort {
    private static Random rand = new Random();

    public static void sort(Comparable[] a, String pivotType, int M) {
        sort(a, 0, a.length - 1, pivotType, M);
    }

    private static void sort(Comparable[] a, int lo, int hi, String pivotType, int M) {
        if (hi <= lo) return;
        if (hi - lo + 1 <= M) {
            insertionSort(a, lo, hi);
            return;
        }
        Comparable v = getPivot(a, lo, hi, pivotType);

        int lt = lo, i = lo+1, gt = hi;

        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0)
                exch(a, lt++, i++);
            else if (cmp > 0)
                exch(a, i, gt--);
            else
                i++;
        }  // Now a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi].
        sort(a, lo, lt - 1, pivotType, M);
        sort(a, gt + 1, hi, pivotType, M);
    }

    public static Comparable getPivot(Comparable[] a, int lo, int hi, String pivotType) {
        if(pivotType.equals("first")) {
            return a[0];
        }
        else if (pivotType.equals("random")) {
            int randomIndex = lo + rand.nextInt(hi - lo + 1);
            exch(a, lo, randomIndex);
            return a[lo];
        }
        else if(pivotType.equals("median")) {
            int mid = lo + (hi - lo) / 2;
            if (less(a[mid], a[lo]))
                exch(a, lo, mid);
            if (less(a[hi], a[lo]))
                exch(a, lo, hi);
            if (less(a[hi], a[mid]))
                exch(a, mid, hi);
            exch(a, lo, mid); // put median at lo
            return a[lo];
        }
        else if(pivotType.equals("median random")) {
            // pick 3 random distinct indices within [lo    ..hi]
            int i1 = lo + rand.nextInt(hi - lo + 1);
            int i2 = lo + rand.nextInt(hi - lo + 1);
            int i3 = lo + rand.nextInt(hi - lo + 1);
            Comparable[] three = {a[i1], a[i2], a[i3]};
            insertionSort(three, 0, 2);
            Comparable median = three[1];
            // move median to a[lo]
            for (int i = lo; i <= hi; i++) {
                if (a[i].compareTo(median) == 0) {
                    exch(a, lo, i);
                    break;
                }
            }
            return a[lo];
        }
        else {
            System.out.println("Invalid pivot type, choosing first element.");
            return a[0];
        }
    }

    public static void insertionSort(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            Comparable key = a[i];
            int j = i - 1;
            while (j >= lo && less(key, a[j])) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        // Partition into a[lo..i-1], a[i], a[i+1..hi].
        int i = lo, j = hi+1;
        // left and right scan indices
        Comparable v = a[lo];
        while (true) {
            // partitioning item
            // Scan right, scan left, check for scan complete, and exchange.
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static boolean less(Comparable v, Comparable w)
    {  return v.compareTo(w) < 0;  }

    private static void exch(Comparable[] a, int i, int j)
    {  Comparable t = a[i]; a[i] = a[j]; a[j] = t;  }
}
