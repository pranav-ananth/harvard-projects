public class ThreeWayQuicksortTester {
    public static void main(String[] args) {
        ThreeWayQuicksort sorter = new ThreeWayQuicksort();
        System.out.println("Empirically finding best value of M");
        System.out.println("Mean times (Milliseconds) | N=10^3 | N=10^4 | N=10^5 | N=10^6");
        double[] test3 = testSort(1000);
        double[] test4 = testSort(10000);
        double[] test5 = testSort(100000);
        double[] test6 = testSort(1000000);
        for(int i = 0; i<31; i++){
            System.out.println("M = "+i+" | "+test3[i]+" | "+test4[i]+" | "+test5[i]+" | "+test6[i]);
        }
        //find value of M with shortest time from ones of length 1000, use that from here on out
        int M = minArray(test3);
        Integer[] toBeSorted = new Integer[20];
        randomArray(toBeSorted, 0, 50);
        System.out.println("Testing getPivot on subarray from index 2 to 7");
        printArray(toBeSorted);
        System.out.println(sorter.getPivot(toBeSorted,2,7,"first"));
        System.out.println(sorter.getPivot(toBeSorted,2,7,"median"));
        System.out.println(sorter.getPivot(toBeSorted,2,7,"random"));
        System.out.println(sorter.getPivot(toBeSorted,2,7,"median random"));
        System.out.println("Testing insertionsort");
        randomArray(toBeSorted, 0, 50);
        printArray(toBeSorted);
        sorter.insertionSort(toBeSorted,0,19);
        printArray(toBeSorted);
        System.out.println("Testing 3 way quicksort with each pivot method");
        randomArray(toBeSorted, 0, 50);
        printArray(toBeSorted);
        sorter.sort(toBeSorted, "first",M);
        printArray(toBeSorted);
        System.out.println("--------------------");
        randomArray(toBeSorted, 0, 50);
        printArray(toBeSorted);
        sorter.sort(toBeSorted, "median",M);
        printArray(toBeSorted);
        System.out.println("--------------------");
        randomArray(toBeSorted, 0, 50);
        printArray(toBeSorted);
        sorter.sort(toBeSorted, "random",M);
        printArray(toBeSorted);
        System.out.println("--------------------");
        randomArray(toBeSorted, 0, 50);
        printArray(toBeSorted);
        sorter.sort(toBeSorted, "median random",M);
        printArray(toBeSorted);

        System.out.println("Ensuring the code can deal with duplicate keys correctly");
        int[] toBeSorted2 = {5,5,7,2,5,5,5,8,1,5,5};
        printArray(toBeSorted2);
        sorter.sort(toBeSorted2,"first", M);
        printArray(toBeSorted2);
        //this is just to print everything so it can be copied and pasted into Google Sheets
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        printArray(test3);
        printArray(test4);
        printArray(test5);
        printArray(test6);
    }
    //helper methods to help with testing the 3 way quicksort
    public static void randomArray(Integer[] A, int lo, int hi){
        for(int i = 0; i<A.length; i++){
            A[i]= Integer.valueOf((int)(Math.random()*(hi-lo+1)+lo)) ;
        }
    }
    public static void printArray(Object[] A){
        for(int i = 0; i<A.length; i++){
            System.out.print(A[i]+", ");
        }
        System.out.println();
    }
    public static void printArray(int[] A) {
        for(int i = 0; i<A.length; i++){
            System.out.print(A[i]+", ");
        }
        System.out.println();
    }
    public static void printArray(double[] A){
        for(int i = 0; i<A.length; i++){
            System.out.println(A[i]);
        }
        System.out.println();
    }
    public static int minArray(double[] A){
        double min = 100000000;
        int minIndex = 1;
        for(int i = 0; i<A.length; i++){
            if(A[i]<min){
                min=A[i];
                minIndex=i;
            }
        }
        return minIndex;
    }
    public static double[] testSort(int N){
        Integer[] testArray = new Integer[N];
        double[] Mtime = new double[31];
        ThreeWayQuicksort testSorter = new ThreeWayQuicksort();
        for(int M=0; M<=30; M++){
            double sumTime = 0;
            for(int i = 0; i<20; i++){
                randomArray(testArray,0,testArray.length);
                long start = System.nanoTime();  // start timer

                testSorter.sort(testArray, "median random", M);

                long end = System.nanoTime();    // end timer
                double elapsedTime = (end - start) / 1_000_000_000.0; // convert to seconds
                sumTime += elapsedTime;
            }
            double avgTime = sumTime/20;
            //truncate avgTime
            Mtime[M]=avgTime;
        }
        return Mtime;
    }
}