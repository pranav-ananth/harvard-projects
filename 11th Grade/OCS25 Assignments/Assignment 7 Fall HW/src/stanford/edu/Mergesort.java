package stanford.edu;

public class Mergesort<T extends Comparable<T>> {


    public Node<T> merge(Node<T> a, Node<T> b) {
        Node<T> result = null;
        if (a == null) return b;
        if (b == null) return a;

        if (a.data.compareTo(b.data) <= 0) {
            result = a;
            result.next = merge(a.next, b);
        } else {
            result = b;
            result.next = merge(a, b.next);
        }
        return result;
    }

    public LinkedList<T> sort(LinkedList<T> list) {


        Node<T> head = list.getHead();
        if(head == null || head.next == null) {
            return list;
        }
        Node<T> middle = list.getMiddle();
        Node<T> nextOfMiddle = middle.next;
        middle.next = null;

        Node<T> sortedLeft = sort(new LinkedList<T>(head)).getHead();
        Node<T> sortedRight = sort(new LinkedList<T>(nextOfMiddle)).getHead();

        return new LinkedList<T>(merge(sortedLeft, sortedRight));
    }
}
