package stanford.edu;

public class LinkedList<T> {
    private Node<T> head;
    private int count;

    public LinkedList() {
        head = null;
        count = 0;
    }

    public LinkedList(Node<T> head) {
        this.head = head;
        count = 0;
        Node<T> temp = head;
        while(temp != null) {
            temp = temp.next;
            count++;
        }
    }

    public void printList() {
        Node<T> node = head;
        while(node != null) {
            System.out.print(node.data);
            if(node.next != null) {
                System.out.print(" -> ");
            }
            node = node.next;
        }
        System.out.println();
    }

    public int getCount() {
        return count;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        if(head == null) {
            return null;
        }
        Node<T> tail = head;
        while(tail.next != null) {
            tail = tail.next;
        }
        return tail;
    }

    public Node<T> getMiddle() {
        if(head == null) {
            return null;
        }
        Node<T> middle = head;
        for(int i = 0; i < count/2 -1; i++) {
            middle = middle.next;
        }
        return middle;
    }

    public void insertItemAtEnd(T data) {
        if(head == null) {
            head = new Node<T>(data);
        }
        else {
            Node<T> tail = getTail();
            Node<T> node = new Node<T>(data);
            tail.next = node;
        }
        count++;
    }


}
