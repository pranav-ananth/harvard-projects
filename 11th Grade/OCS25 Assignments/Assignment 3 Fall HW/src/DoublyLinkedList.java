public class DoublyLinkedList<T> {

    class DoubleNode<T> {
        T data;
        DoubleNode<T> next;
        DoubleNode<T> prev;

        DoubleNode(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    DoubleNode<T> head;

    public void printList() {
        DoubleNode<T> node = head;
        while(node != null) {
            System.out.print(node.data);
            if(node.next != null) {
                System.out.print(" -> ");
            }
            node = node.next;
        }
        System.out.println();
    }

    public void insertItemAtStart(T data) {
        if(head == null) {
            head = new DoubleNode<T>(data);
        }
        else {
            DoubleNode<T> node = new DoubleNode<T>(data);
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    private DoubleNode<T> getTail() {
        if(head == null) {
            return null;
        }
        DoubleNode<T> tail = head;
        while(tail.next != null) {
            tail = tail.next;
        }
        return tail;
    }

    public void insertItemAtEnd(T data) {
        if(head == null) {
            head = new DoubleNode<T>(data);
        }
        else {
            DoubleNode<T> tail = getTail();
            DoubleNode<T> node = new DoubleNode<T>(data);
            node.prev = tail;
            tail.next = node;

        }
    }

    public void removeStart() {
        if(head != null) {
            if(head.next != null) {
                head = head.next;
                head.prev.next = null;
                head.prev = null;
            }
            else {
                head = null;
            }
        }
    }

    public void removeEnd() {
        if(head != null) {
            DoubleNode<T> tail = getTail();
            if(head == tail) {
                head = null;
            }
            else {
                tail.prev.next = null;
                tail.prev = null;
            }
        }
    }

    private DoubleNode<T> findElement(T data) {
        DoubleNode<T> node = head;
        while(node != null) {
            if(node.data == data) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void insertBefore(T reference, T data) {
        DoubleNode<T> refNode = findElement(reference);
        if(refNode != null) {
            DoubleNode<T> newNode = new DoubleNode<T>(data);
            if(refNode.prev != null) {
                // not at head
                newNode.prev = refNode.prev;
                newNode.prev.next = newNode;
            }
            refNode.prev = newNode;
            newNode.next = refNode;

        }
        else {
            insertItemAtEnd(data);
        }
    }

    public void insertAfter(T reference, T data) {
        DoubleNode<T> refNode = findElement(reference);
        if(refNode != null) {
            DoubleNode<T> newNode = new DoubleNode<T>(data);
            if(refNode.next != null) {
                // not at tail
                newNode.next = refNode.next;
                newNode.next.prev = newNode;
            }
            refNode.next = newNode;
            newNode.prev = refNode;

        }
        else {
            insertItemAtEnd(data);
        }
    }

    public void remove(T data) {
        DoubleNode<T> node = findElement(data);
        if(node != null) {
            DoubleNode<T> prevNode = node.prev;
            DoubleNode<T> nextNode = node.next;

            if(nextNode == null) {
                if(prevNode == null) {
                    // at head
                    head = null;
                }
                else {
                    // at tail
                    node.prev = null;
                    prevNode.next = null;
                }

            }
            else {
                if(prevNode == null) {
                    // at head
                    nextNode.prev = null;
                    node.next = null;
                    head = nextNode;
                }
                else {
                    // at middle
                    prevNode.next = nextNode;
                    nextNode.prev = prevNode;
                    node.prev = null;
                    node.next = null;
                }

            }
        }
    }

    public void moveToFront(T data) {
        if(findElement(data) != null) {
            remove(data);
            insertItemAtStart(data);
        }
    }

    public void moveToEnd(T data) {
        if(findElement(data) != null) {
            remove(data);
            insertItemAtEnd(data);
        }
    }
}