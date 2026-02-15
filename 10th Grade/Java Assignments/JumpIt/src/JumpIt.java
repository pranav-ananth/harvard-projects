public class JumpIt {
    private static int jumpIt(int[] arr){
        return findMinCost(arr, 0);
    }

    private static int findMinCost(int[] arr, int index) {
        if(index >= arr.length) {
            return Integer.MAX_VALUE; // to prevent going out of bounds
        }

        if(index == arr.length - 1) {
            return arr[index];
        }

        return arr[index] + Math.min( findMinCost(arr, index + 1), findMinCost(arr, index + 2) );
    }

    public static void main(String[] args) {
        int[] game1 = {10, 5, 4, 7, 6, 4};
        System.out.println(jumpIt(game1));

        int[] game2 = {2, 3, 4, 1, 6, 7, 3, 43, 12};
        System.out.println(jumpIt(game2));

        int[] game3 = {3, 6, 7, 2, 4, 1, 3, 4};
        System.out.println(jumpIt(game3));

        int[] gameLong = {2, 3, 4, 1, 2, 3, 4, 1, 6, 7, 3, 8, 3, 2, 7, 5, 7, 8, 1, 5, 7, 4, 6, 8, 9, 1, 3, 4, 5, 6, 1
        , 4, 5, 7, 8, 2, 3, 4, 2, 5, 7}; // max it could process in a reasonable amount of time
        System.out.println(jumpIt(gameLong));
    }
}