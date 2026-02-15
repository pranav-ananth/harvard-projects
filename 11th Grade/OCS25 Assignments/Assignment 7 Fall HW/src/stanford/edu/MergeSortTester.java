package stanford.edu;



public class MergeSortTester {

    public static void main(String [] args) {

        LinkedList<Character> list = new LinkedList<Character>();
        Mergesort<Character> ms = new Mergesort<Character>();

        java.lang.String s = "MERGESORTEXAMPLE";
        for (int i =0; i < s.length(); i++)  {
            list.insertItemAtEnd(s.charAt(i));
        }

        System.out.println("Original List is :");
        list.printList();

        System.out.println("Sorted List is :");
        ms.sort(list).printList();

    }
}
