public class HeapsortTester {
    public static void main(String[] args) {
        TernaryHeap<Integer> heap = new TernaryHeap<Integer>(100);
        randomize(heap);
        System.out.println("Sorting this array:");
        heap.printHeap();
        heap.heapsort();
        System.out.println("The result:");
        heap.printHeap();
    }
    public static void randomize(TernaryHeap<Integer> t){
        //fill heap of length 100 with numbers 1 through 100
        for(int i = 1; i<=t.getN(); i++){
            t.modify(i, i);
        }
        //shuffle them around
        for(int i = 1; i<t.getN(); i++){
            int index1 = (int)(Math.random()*(t.getN()))+1;
            int index2 = (int)(Math.random()*(t.getN()))+1;
            t.exchange(index1,index2);
        }
    }
}
