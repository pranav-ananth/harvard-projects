import java.util.ArrayList;

/**
 * Write a description of class PriorityQueue here.
 *
 * @author Pranav Ananth
 * @version 11/13/2024
 */


public class PriorityQueue<T>
{
    private ArrayList<T> items;
    private ArrayList<Integer> priorities;


    public PriorityQueue(){
        items = new ArrayList<>();
        priorities = new ArrayList<>();
    }


    public void add(T item, int priority){
        items.add(item);
        priorities.add(priority);
    }

    public T remove(){
        if(priorities.size() == 0)
            return null;

        int highestPriority = priorities.get(1);
        int highestPriorityIndex = 1;
        for(int i = 0; i < priorities.size(); i++) {
            if(priorities.get(i) > highestPriority) {
                highestPriority = priorities.get(i);
                highestPriorityIndex = i;
            }
        }
        T highestPriorityItem = items.get(highestPriorityIndex);
        items.remove(highestPriorityIndex);
        priorities.remove(highestPriorityIndex);
        return highestPriorityItem;
    }

    public String toString(){
        StringBuilder string = new StringBuilder();
        string.append("[ ");
        for(int i = 0; i < priorities.size() - 1; i++) {
            string.append("[" + items.get(i) + "," + priorities.get(i) + "], ");
        }
        string.append("[" + items.get(priorities.size()-1) + "," + priorities.get(priorities.size()-1) + "] ]");
        return "" + string;
    }

    /*
     * Some test code.
     */
    public static void main(String[] args){
        /*
        your output should look like this:

        [ [X,4], [Z,7], [Y,10], [Y,10], [Z,7] ]
        [ [X,4], [Z,7], [Y,10], [Z,7] ]
        [ [X,4], [Z,7], [Z,7] ]
        [ [X,4], [Z,7] ]
        [ [X,4], [Z,7], [A,5], [B,8] ]
        [ [X,4], [Z,7], [A,5] ]
        [ [X,4], [A,5] ]

        */

        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.add("X", 4);
        queue.add("Z", 7);
        queue.add("Y", 10);
        queue.add("Y", 10);
        queue.add("Z", 7);
        System.out.println(queue);
        queue.remove();
        System.out.println(queue);
        queue.remove();
        System.out.println(queue);
        queue.remove();
        System.out.println(queue);
        queue.add("A", 5);
        queue.add("B", 8);
        System.out.println(queue);
        queue.remove();
        System.out.println(queue);
        queue.remove();
        System.out.println(queue);

    }


}