import java.util.*;

public class MazeGenerator {

    private static class Wall {
        int c1, c2; // cells connected by the wall
        Wall(int c1, int c2) {
            this.c1 = c1;
            this.c2 = c2;
        }
    }

    /**
     * Generates a maze.
     * @param width the width of the maze in # of cells
     * @param height the height of the maze in # of cells
     * @return a Cell[] that represents the generated maze.
     */
    public static Cell[] generate(int width, int height) {
        int total = width * height;
        Cell[] cells = new Cell[total];
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(total);
        List<Wall> walls = new ArrayList<>();

        // initialize cells
        for(int i = 0; i < total; i++) {
            cells[i] = new Cell();
        }
        // create entrance and exit
        cells[0].l = false;
        cells[total - 1].r = false;

        // initialize walls
        for(int r = 0; r < height; r++) {
            for(int c = 0; c < width; c++) {
                int index = r * width + c;
                if(c < width - 1) {
                    walls.add(new Wall(index, index + 1)); // right wall
                }
                if(r < height - 1) {
                    walls.add(new Wall(index, index + width)); // bottom wall
                }
            }
        }
        Collections.shuffle(walls, new Random());

        // knock down walls
        for(Wall w : walls) {
            if(!uf.connected(w.c1, w.c2)) {
                uf.union(w.c1, w.c2);
                knockDownWall(cells, w.c1, w.c2, width);
            }
        }

        return cells;
    }

    private static void knockDownWall(Cell[] cells, int c1, int c2, int width) {
        if(c2 == c1 + 1) { // c2 is to the right
            cells[c1].r = false;
            cells[c2].l = false;
        }
        else if(c2 == c1 - 1) { // c2 is to the left
            cells[c1].l = false;
            cells[c2].r = false;
        }
        else if(c2 == c1 - width) { // c2 is to the top
            cells[c1].t = false;
            cells[c2].b = false;
        }
        else if(c2 == c1 + width) { // c2 is to the bottom
            cells[c1].b = false;
            cells[c2].t = false;
        }
        else {
            System.out.println("An error occured.");
        }
    }


}
