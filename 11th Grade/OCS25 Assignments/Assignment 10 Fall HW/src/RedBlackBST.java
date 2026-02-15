public class RedBlackBST<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private class Node {
        Key key;
        Value val;
        Node left, right;
        boolean color; // color of link from parent to this node
        int N;         // subtree size

        Node(Key key, Value val, int N, boolean color) {
            this.key = key;
            this.val = val;
            this.N = N;
            this.color = color;
        }
    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    private int size(Node x) {
        return x == null ? 0 : x.N;
    }

    public int size() {
        return size(root);
    }

    public boolean isEmpty() {
        return root == null;
    }

    // rotate left
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    // rotate right
    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    // flip colors of node and its two children
    private void flipColors(Node h) {
        h.color = !h.color;
        if (h.left != null)  h.left.color  = !h.left.color;
        if (h.right != null) h.right.color = !h.right.color;
    }

    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("key is null");
        root = put(root, key, val);
        root.color = BLACK;
    }

    private Node put(Node h, Key key, Value val) {
        if (h == null)
            return new Node(key, val, 1, RED);

        int cmp = key.compareTo(h.key);
        if (cmp < 0) h.left  = put(h.left,  key, val);
        else if (cmp > 0) h.right = put(h.right, key, val);
        else h.val = val;

        // fix right-leaning links and 4-nodes on the way up
        if (isRed(h.right) && !isRed(h.left))    h = rotateLeft(h);
        if (isRed(h.left)  && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left)  && isRed(h.right))     flipColors(h);

        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (key == null) throw new IllegalArgumentException("key is null");
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.val;
        }
        return null;
    }

    // return node with minimum key in subtree
    private Node min(Node x) {
        if (x == null) return null;
        while (x.left != null) x = x.left;
        return x;
    }

    public Key min() {
        if (isEmpty()) return null;
        return min(root).key;
    }

    private Node balance(Node h) {
        if (isRed(h.right))                     h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right))     flipColors(h);

        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

    private Node moveRedLeft(Node h) {
        // Assuming that h is red and both h.left and h.left.left are black,
        // make h.left or one of its children red.
        flipColors(h);
        if (isRed(h.right.left)) {
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
        }
        return h;
    }

    private Node moveRedRight(Node h) {
        // Assuming that h is red and both h.right and h.right.left are black,
        // make h.right or one of its children red.
        flipColors(h);
        if (isRed(h.left.left))
            h = rotateRight(h);
        return h;
    }

    public void deleteMin() {
        if (isEmpty()) return;
        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;
        root = deleteMin(root);
        if (!isEmpty()) root.color = BLACK;
    }

    private Node deleteMin(Node h) {
        if (h.left == null)
            return null;
        if (!isRed(h.left) && !isRed(h.left.left))
            h = moveRedLeft(h);
        h.left = deleteMin(h.left);
        return balance(h);
    }

    public void deleteMax() {
        if (isEmpty()) return;
        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;
        root = deleteMax(root);
        if (!isEmpty()) root.color = BLACK;
    }

    private Node deleteMax(Node h) {
        if (isRed(h.left))
            h = rotateRight(h);
        if (h.right == null)
            return null;
        if (!isRed(h.right) && !isRed(h.right.left))
            h = moveRedRight(h);
        h.right = deleteMax(h.right);
        return balance(h);
    }

    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("key is null");
        if (isEmpty()) return;
        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;
        root = delete(root, key);
        if (!isEmpty()) root.color = BLACK;
    }

    private Node delete(Node h, Key key) {
        if (h == null) return null; // key not found
        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            if (h.left != null) {
                if (!isRed(h.left) && !isRed(h.left.left))
                    h = moveRedLeft(h);
                h.left = delete(h.left, key);
            }
        } else {
            if (isRed(h.left))
                h = rotateRight(h);
            if (cmp == 0 && (h.right == null))
                return null;
            if (h.right != null) {
                if (!isRed(h.right) && !isRed(h.right.left))
                    h = moveRedRight(h);
                if (cmp == 0) {
                    Node m = min(h.right);
                    h.key = m.key;
                    h.val = m.val;
                    h.right = deleteMin(h.right);
                } else {
                    h.right = delete(h.right, key);
                }
            }
        }
        return balance(h);
    }

    public void printTree() {
        if (root == null) return;

        java.util.Queue<Node> q = new java.util.LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node x = q.remove();

            // Print key(Color)
            System.out.print(x.key + "(" + (x.color == RED ? "R" : "B") + ") ");

            if (x.left != null) q.add(x.left);
            if (x.right != null) q.add(x.right);
        }

        System.out.println();
    }
}