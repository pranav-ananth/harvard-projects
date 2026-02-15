
import javax.swing.*;
import java.awt.*;

public class SierpinskiTriangle extends JPanel {
    private int depth;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();

        int x1 = width / 2, y1 = 10;
        int x2 = 10, y2 = height - 10;
        int x3 = width - 10, y3 = height - 10;

        drawTriangle(g, depth, x1, y1, x2, y2, x3, y3);
    }

    private void drawTriangle(Graphics g, int depth, int x1, int y1, int x2, int y2, int x3, int y3) {
        if(depth == 0) {
            g.drawPolygon(new int[] {x1, x2, x3}, new int[] {y1, y2, y3}, 3);
        }
        else {
            int midX1 = (x1 + x2) / 2;
            int midY1 = (y1 + y2) / 2;
            int midX2 = (x2 + x3) / 2;
            int midY2 = (y2 + y3) / 2;
            int midX3 = (x3 + x1) / 2;
            int midY3 = (y3 + y1) / 2;

            drawTriangle(g, depth - 1, x1, y1, midX1, midY1, midX3, midY3);
            drawTriangle(g, depth - 1, midX1, midY1, x2, y2, midX2, midY2);
            drawTriangle(g, depth - 1, midX3, midY3, midX2, midY2, x3, y3);
        }
    }

    public void setDepth(int depth) {
        this.depth = depth;
        repaint();
    }

    public SierpinskiTriangle() {
        depth = 4; // default starting depth
        createPanel();
    }

    public void createPanel() {
        JFrame frame = new JFrame("Sierpinski Triangle");


        JPanel depthPanel = new JPanel();
        JTextField depthInput = new JTextField(4);
        JButton depthButton = new JButton("Set Depth");

        depthButton.addActionListener(e -> setDepth(Integer.parseInt(depthInput.getText())));

        JLabel depthLabel = new JLabel("Depth: ");
        depthPanel.add(depthLabel);
        depthPanel.add(depthInput);
        depthPanel.add(depthButton);

        frame.setLayout(new BorderLayout());
        frame.add(depthPanel, BorderLayout.NORTH);
        frame.add(this, BorderLayout.CENTER);

        frame.setSize(800, 820);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        new SierpinskiTriangle();
    }
}
