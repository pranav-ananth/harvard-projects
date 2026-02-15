public class Stack<T> {
    private Node<T> top;
    private int count;

    public Stack() {
        top = null;
        count = 0;
    }

    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = top;
        top = newNode;
        count++;
    }

    public T pop() {
        if (isEmpty()) throw new RuntimeException("Stack underflow");
        T item = top.data;
        top = top.next;
        count--;
        return item;
    }

    public T peek() {
        if (isEmpty()) throw new RuntimeException("Stack underflow");
        return top.data;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return top == null;
    }
}