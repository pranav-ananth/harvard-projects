import java.awt.*;
import java.awt.event.*;
import java.util.*;
/**
 * @author Joshua Tittiranonda
 * @author Sadie Giessner
 * @date 9/29/24
 *
 * Implements a maze displayer, which
 * displays a maze of size m x n.
 *
 */

/**
 * Implements a maze displayer, which displays a maze of size m x n.
 * <p>
 *
 * @see MazeGenerator
 * @see MazePanel
 * @see Cell
 */
public class MazeDisplayer extends Frame {
    /**
     * Constructor for a {@code MazeDisplayer} object
     *
     * @param w the width of the maze in cells
     * @param h the height of the maze in cells
     * @param s the size of each cell in pixels
     * @param cells the maze to be displayed
     */
    public MazeDisplayer(int w, int h, int s, Cell[] cells) {
        ScrollPane scr = new ScrollPane(); // scrollpane to allow scrolling oversized mazes
        scr.add(new MazePanel(w, h, s, cells)); // add maze to scrollpane
        add(scr); // add scrollpane to frame
        setVisible(true); // make frame visible
        setExtendedState(getExtendedState() | Frame.MAXIMIZED_BOTH); // maximize frame
        // quit program when window is closed
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    void drawCell(int xOrigin, int yOrigin, Graphics g, Cell cell, int cellSize) {
        if (cell.t)
            g.drawLine(xOrigin, yOrigin, xOrigin + cellSize, yOrigin);
        if (cell.b)
            g.drawLine(xOrigin, yOrigin + cellSize, xOrigin + cellSize, yOrigin +
                    cellSize);
        if (cell.l)
            g.drawLine(xOrigin, yOrigin, xOrigin, yOrigin + cellSize);
        if (cell.r)
            g.drawLine(xOrigin + cellSize, yOrigin, xOrigin + cellSize, yOrigin +
                    cellSize);
    }
    /**
     * Implements a maze panel, which paints a maze of size m x n.
     * <p>
     *
     * @see MazeDisplayer
     * @see MazeGenerator
     * @see Cell
     */
    class MazePanel extends Panel {
        private int width, height, size; // width and height of maze in cells, size of each cell in pixels
        private Cell[] cells; // maze to be displayed
        /**
         * Constructor for a {@code MazePanel} object
         *
         * @param w the width of the maze in cells
         * @param h the height of the maze in cells
         * @param s the size of each cell in pixels
         * @param cells the maze to be displayed
         */
        public MazePanel(int w, int h, int s, Cell[] cells) {
            this.width = w;
            this.height = h;
            this.size = s;
            this.cells = cells;
            setPreferredSize(new Dimension(width * size + 100, height * size +
                    100)); // set panel size to maze size
            setVisible(true); // make panel visible (also calls paint())
        }
        /**
         * Paints the maze.
         *
         * @param g the {@code Graphics} object used to draw
         */
        public void paint(Graphics g) {
            int xOrigin = 50; // starting x-coordinate
            int yOrigin = 50; // starting y-coordinate
            // draw maze
            for (int i = 0; i < height; i++) {
                xOrigin = 50; // move x back to starting x
                for (int j = 0; j < width; j++) {
                    int x = j + i * width; // convert grid coordinates into 1D array index
                    drawCell(xOrigin, yOrigin, g, cells[x], size); // draw the individual cell
                    xOrigin += size; // move x over to next cell area
                }
                yOrigin += size; // move y down to next row
            }
        }
    }
    /**
     * Contains driver code
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the width and height of the maze to be generated, each separated by a space:\n>>>\t");
        int width = sc.nextInt();
        int height = sc.nextInt();
        System.out.print("Enter the size, in pixels, of each individual cell:\n>>>\t");
        int size = sc.nextInt();
        long start = System.currentTimeMillis();
        new MazeDisplayer(width, height, size, MazeGenerator.generate(width,
                height));
        System.out.println("Took " + Long.toString(System.currentTimeMillis() -
                start) + "ms");
        sc.close();
    }
}