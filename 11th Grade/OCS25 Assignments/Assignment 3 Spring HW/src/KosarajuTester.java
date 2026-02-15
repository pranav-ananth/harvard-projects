import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class KosarajuTester {
    public static void main(String[] args) throws FileNotFoundException {
        // Number of vertices (0–49 → 50 total)
        Digraph G = new Digraph(50);

        // Read edges from file
        Scanner in = new Scanner(new File("graph.txt"));

        while (in.hasNextInt()) {
            int v = in.nextInt();
            int w = in.nextInt();
            G.addEdge(v, w);
        }

        in.close();

        KosarajuSCC scc = new KosarajuSCC(G);

        System.out.println("Number of strongly connected components: " + scc.count());
        scc.printComponents(G);
    }
}
