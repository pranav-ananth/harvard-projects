public class RedBlackBSTMain {
    public static void main(String[] args) {
        RedBlackBST<Integer, Integer> tree = new RedBlackBST<>();

        for (int i = 1; i <= 60; i++) {
            tree.put(i, i);
        }

        System.out.println("Tree size: " + tree.size());

        System.out.println("Printed tree:\n");
        tree.printTree();
    }
}